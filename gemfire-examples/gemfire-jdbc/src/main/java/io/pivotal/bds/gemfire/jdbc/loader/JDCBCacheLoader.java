package io.pivotal.bds.gemfire.jdbc.loader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.LoaderHelper;
import org.apache.geode.pdx.PdxInstance;
import org.apache.geode.pdx.PdxInstanceFactory;

import io.pivotal.bds.gemfire.jdbc.util.ColumnMapping;
import io.pivotal.bds.gemfire.jdbc.util.ConnectionConfiguration;
import io.pivotal.bds.gemfire.jdbc.util.DataSourceManager;
import io.pivotal.bds.gemfire.jdbc.util.MappingManager;
import io.pivotal.bds.gemfire.jdbc.util.TableMapping;

public class JDCBCacheLoader implements CacheLoader<String, PdxInstance>, Declarable {

    private static final Logger LOG = LogManager.getLogger(JDCBCacheLoader.class);

    @Override
    public PdxInstance load(LoaderHelper<String, PdxInstance> helper) throws CacheLoaderException {
        String key = helper.getKey();
        String regionName = helper.getRegion().getName();

        LOG.debug("load: key={}, regionName={}", key, regionName);

        try {
            TableMapping tableMapping = MappingManager.getInstance().getMappingForRegionName(regionName);
            String tableName = tableMapping.getTableName();

            ConnectionConfiguration connConf = tableMapping.getConnection();
            DataSource ds = DataSourceManager.getInstance().getDataSource(connConf);

            String sql = createSelect(tableMapping);
            LOG.debug("load: key={}, regionName={}, sql={}", key, regionName, sql);

            PdxInstance inst = null;
            Connection conn = ds.getConnection();

            try {
                PreparedStatement stmt = conn.prepareStatement(sql);

                try {
                    stmt.setString(1, key);
                    ResultSet res = stmt.executeQuery();

                    if (res.next()) {
                        PdxInstanceFactory pif = CacheFactory.getAnyInstance().createPdxInstanceFactory(tableName);

                        for (ColumnMapping colMap : tableMapping.getColumnMappingsByColumn().values()) {
                            String colName = colMap.getColumnName();
                            String fieldName = colMap.getFieldName();

                            Object fieldValue = res.getObject(colName);

                            if (fieldValue != null) {
                                pif.writeObject(fieldName, fieldValue);
                            }
                        }

                        inst = pif.create();
                    }
                } finally {
                    stmt.close();
                }

                conn.commit();
            } catch (Exception x) {
                conn.rollback();
            } finally {
                conn.close();
            }

            LOG.debug("load: key={}, regionName={}, inst={}", key, regionName, inst);
            return inst;
        } catch (Exception x) {
            LOG.error("load: key={}, regionName={}, x={}", key, regionName, x.toString(), x);
            throw new CacheLoaderException(x.toString(), x);
        }
    }

    private String createSelect(TableMapping tm) {
        String tableName = tm.getTableName();
        String keyColumn = tm.getKeyColumnName();
        StringBuilder buf = new StringBuilder();

        buf.append("SELECT * FROM ").append(tableName).append(" WHERE ").append(keyColumn).append("=?");

        return buf.toString();
    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public void close() {
    }
}
