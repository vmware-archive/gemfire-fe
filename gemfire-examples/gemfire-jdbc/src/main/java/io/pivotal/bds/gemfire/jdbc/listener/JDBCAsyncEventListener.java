package io.pivotal.bds.gemfire.jdbc.listener;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEvent;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEventListener;
import com.gemstone.gemfire.pdx.PdxInstance;

import io.pivotal.bds.gemfire.jdbc.util.ColumnMapping;
import io.pivotal.bds.gemfire.jdbc.util.ConnectionConfiguration;
import io.pivotal.bds.gemfire.jdbc.util.DataSourceManager;
import io.pivotal.bds.gemfire.jdbc.util.MappingManager;
import io.pivotal.bds.gemfire.jdbc.util.TableMapping;

public class JDBCAsyncEventListener implements AsyncEventListener, Declarable {

    private static final Logger LOG = LogManager.getLogger(JDBCAsyncEventListener.class);

    @SuppressWarnings("rawtypes")
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        LOG.debug("processEvents: events={}", events);

        MappingManager mappings = MappingManager.getInstance();
        DataSourceManager dsMgr = DataSourceManager.getInstance();

        try {
            // sort the events by region then by operation type
            Map<String, RegionHolder> holders = new HashMap<>();

            for (AsyncEvent evt : events) {
                Operation op = evt.getOperation();

                if (check(op, mappings)) {
                    String regionName = evt.getRegion().getName();
                    RegionHolder regionHolder = holders.get(regionName);

                    if (regionHolder == null) {
                        regionHolder = new RegionHolder(regionName);
                        holders.put(regionName, regionHolder);
                    }

                    OperationType ot = null;

                    if (op.isCreate()) {
                        ot = OperationType.insert;
                    } else if (op.isUpdate()) {
                        ot = OperationType.update;
                    } else if (op.isDestroy()) {
                        ot = OperationType.delete;
                    } else {
                        throw new IllegalArgumentException("Cannot handle op " + op);
                    }

                    OperationHolder operationHolder = regionHolder.operations.get(ot);

                    if (operationHolder == null) {
                        operationHolder = new OperationHolder(ot);
                        regionHolder.operations.put(ot, operationHolder);
                    }

                    operationHolder.events.add(evt);
                }
            }

            LOG.debug("processEvents: holders={}", holders);

            // process batch sql statements on sorted events
            for (RegionHolder regionHolder : holders.values()) {
                String regionName = regionHolder.regionName;

                TableMapping tableMapping = mappings.getMappingForRegionName(regionName);
                ConnectionConfiguration connConf = tableMapping.getConnection();
                DataSource ds = dsMgr.getDataSource(connConf);
                Connection conn = ds.getConnection();

                try {
                    for (OperationHolder operationHolder : regionHolder.operations.values()) {
                        process(regionHolder, operationHolder, conn, tableMapping);
                    }

                    LOG.debug("processEvents: committing transactions");
                    conn.commit();
                } catch (Exception x) {
                    LOG.error("processEvents: rolling back transaction: x={}", x.toString(), x);
                    conn.rollback();
                    throw x;
                } finally {
                    conn.close();
                }
            }

            return true;
        } catch (BatchUpdateException x) {
            SQLException sqlx = x.getNextException();
            LOG.error("processEvents: sqlx={}", sqlx.toString(), sqlx);
            return true;
        } catch (Exception x) {
            LOG.error("processEvents: x={}", x.toString(), x);
            return false;
        }
    }

    private void process(RegionHolder regionHolder, OperationHolder operationHolder, Connection conn, TableMapping tableMapping)
            throws Exception {
        OperationType ot = operationHolder.op;
        String sql = null;

        switch (ot) {
            case insert: {
                sql = createInsert(tableMapping);
                break;
            }
            case update: {
                sql = createUpdate(tableMapping);
                break;
            }
            case delete: {
                sql = createDelete(tableMapping);
                break;
            }
            default: {
                throw new IllegalArgumentException(); // should never happen
            }
        }

        LOG.debug("process: sql={}", sql);

        PreparedStatement stmt = conn.prepareStatement(sql);

        try {
            addBatches(operationHolder, stmt, tableMapping);
            int[] res = stmt.executeBatch();

            if (LOG.isDebugEnabled()) {
                LOG.debug("process: res={}", Arrays.toString(res));
            }

            for (int t : res) {
                if (t == Statement.EXECUTE_FAILED) {
                    LOG.warn("process: a batch statement failed");
                }
            }
        } finally {
            stmt.close();
        }

    }

    private void addBatches(OperationHolder operationHolder, PreparedStatement stmt, TableMapping tableMapping) throws Exception {
        Map<String, ColumnMapping> columnMappings = tableMapping.getColumnMappingsByColumn();
        OperationType ot = operationHolder.op;
        switch (ot) {
            case insert: {
                addInsert(operationHolder, stmt, columnMappings);
                break;
            }
            case update: {
                addUpdate(operationHolder, stmt, columnMappings, tableMapping);
                break;
            }
            case delete: {
                addDelete(operationHolder, stmt, columnMappings, tableMapping);
                break;
            }
            default: {
                throw new IllegalArgumentException(); // should never happen
            }
        }
    }

    @SuppressWarnings("rawtypes")
    private void addDelete(OperationHolder operationHolder, PreparedStatement stmt, Map<String, ColumnMapping> columnMappings,
            TableMapping tableMapping) throws Exception {
        String keyColumn = tableMapping.getKeyColumnName();
        ColumnMapping keyColumnMapping = columnMappings.get(keyColumn);
        String keyFieldName = keyColumnMapping.getFieldName();

        for (AsyncEvent evt : operationHolder.events) {
            PdxInstance inst = (PdxInstance) evt.getDeserializedValue();

            Object fieldValue = inst.getField(keyFieldName);
            stmt.setObject(1, fieldValue);

            stmt.addBatch();
        }
    }

    @SuppressWarnings("rawtypes")
    private void addUpdate(OperationHolder operationHolder, PreparedStatement stmt, Map<String, ColumnMapping> columnMappings,
            TableMapping tableMapping) throws Exception {
        String keyColumn = tableMapping.getKeyColumnName();
        ColumnMapping keyColumnMapping = columnMappings.get(keyColumn);
        String keyFieldName = keyColumnMapping.getFieldName();

        List<String> cols = new ArrayList<>();

        for (Iterator<ColumnMapping> iter = columnMappings.values().iterator(); iter.hasNext();) {
            ColumnMapping columnMapping = iter.next();
            String columnName = columnMapping.getColumnName();
            if (!columnName.equals(keyColumn)) {
                cols.add(columnName);
            }
        }

        for (AsyncEvent evt : operationHolder.events) {
            PdxInstance inst = (PdxInstance) evt.getDeserializedValue();

            int colIndex = 1;

            for (String colName : cols) {
                ColumnMapping columnMapping = columnMappings.get(colName);
                String fieldName = columnMapping.getFieldName();
                Object fieldValue = inst.getField(fieldName);
                stmt.setObject(colIndex++, fieldValue);
            }

            Object fieldValue = inst.getField(keyFieldName);
            stmt.setObject(colIndex, fieldValue);

            stmt.addBatch();
        }
    }

    @SuppressWarnings("rawtypes")
    private void addInsert(OperationHolder operationHolder, PreparedStatement stmt, Map<String, ColumnMapping> columnMappings)
            throws Exception {
        for (AsyncEvent evt : operationHolder.events) {
            PdxInstance inst = (PdxInstance) evt.getDeserializedValue();

            int colIndex = 1;
            for (ColumnMapping columnMapping : columnMappings.values()) {
                String fieldName = columnMapping.getFieldName();
                Object fieldValue = inst.getField(fieldName);
                stmt.setObject(colIndex++, fieldValue);
            }

            stmt.addBatch();
        }
    }

    private String createDelete(TableMapping tableMapping) throws Exception {
        String tableName = tableMapping.getTableName();
        String keyColumn = tableMapping.getKeyColumnName();

        StringBuilder buf = new StringBuilder();

        buf.append("DELETE FROM ").append(tableName).append(" WHERE ").append(keyColumn).append("=?");
        return buf.toString();
    }

    private String createUpdate(TableMapping tableMapping) throws Exception {
        String tableName = tableMapping.getTableName();
        String keyColumn = tableMapping.getKeyColumnName();
        Map<String, ColumnMapping> columnMappings = tableMapping.getColumnMappingsByColumn();

        List<String> cols = new ArrayList<>();

        for (Iterator<ColumnMapping> iter = columnMappings.values().iterator(); iter.hasNext();) {
            ColumnMapping columnMapping = iter.next();
            String columnName = columnMapping.getColumnName();
            if (!columnName.equals(keyColumn)) {
                cols.add(columnName);
            }
        }

        StringBuilder buf = new StringBuilder();

        buf.append("UPDATE ").append(tableName).append(" SET ");

        for (int i = 0; i < cols.size(); ++i) {
            if (i > 0) {
                buf.append(',');
            }
            String cn = cols.get(i);
            buf.append(cn).append("=?");
        }

        buf.append(" WHERE ").append(keyColumn).append("=?");

        return buf.toString();
    }

    private String createInsert(TableMapping tableMapping) throws Exception {
        String tableName = tableMapping.getTableName();
        Map<String, ColumnMapping> columnMappings = tableMapping.getColumnMappingsByColumn();

        StringBuilder buf = new StringBuilder();

        buf.append("INSERT INTO ").append(tableName).append(" (");

        for (Iterator<ColumnMapping> iter = columnMappings.values().iterator(); iter.hasNext();) {
            ColumnMapping columnMapping = iter.next();
            String columnName = columnMapping.getColumnName();
            buf.append(columnName);
            if (iter.hasNext()) {
                buf.append(',');
            }
        }

        buf.append(") VALUES (");

        for (Iterator<ColumnMapping> iter = columnMappings.values().iterator(); iter.hasNext();) {
            iter.next();
            buf.append('?');
            if (iter.hasNext()) {
                buf.append(',');
            }
        }

        buf.append(")");
        return buf.toString();
    }

    private boolean check(Operation op, MappingManager mgr) {
        if (op.isEviction()) {
            return false;
        }

        if (op.isExpiration()) {
            return false;
        }

        if (!mgr.isDoUpdate() && op.isUpdate()) {
            return false;
        }

        if (!mgr.isDoDelete() && op.isDestroy()) {
            return false;
        }

        if (op.isCreate() && op.isLoad()) {
            return false;
        }

        return true;
    }

    private static enum OperationType {
        insert, update, delete;
    }

    private static class RegionHolder {
        public String regionName;
        public Map<OperationType, OperationHolder> operations = new HashMap<>();

        public RegionHolder(String regionName) {
            this.regionName = regionName;
        }

        @Override
        public String toString() {
            return "RegionHolder [regionName=" + regionName + ", operations=" + operations + "]";
        }

    }

    private static class OperationHolder {
        public OperationType op;
        @SuppressWarnings("rawtypes")
        public List<AsyncEvent> events = new ArrayList<>();

        public OperationHolder(OperationType op) {
            this.op = op;
        }

        @Override
        public String toString() {
            return "OperationHolder [op=" + op + ", events=" + events + "]";
        }

    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public void close() {
    }

}
