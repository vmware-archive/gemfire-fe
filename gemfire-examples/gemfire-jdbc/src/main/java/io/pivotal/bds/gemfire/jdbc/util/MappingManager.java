package io.pivotal.bds.gemfire.jdbc.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.util.Assert;
import org.yaml.snakeyaml.Yaml;

public class MappingManager {

    private boolean doUpdate;
    private boolean doDelete;
    private Map<String, TableMapping> mappingsByTable = new HashMap<>();
    private Map<String, TableMapping> mappingsByRegion = new HashMap<>();

    private static MappingManager instance;

    private static final Logger LOG = LogManager.getLogger(MappingManager.class);

    public static synchronized MappingManager getInstance() {
        if (instance == null) {
            instance = new MappingManager();
        }

        return instance;
    }

    public boolean isDoUpdate() {
        return doUpdate;
    }

    public boolean isDoDelete() {
        return doDelete;
    }

    public TableMapping getMappingForTableName(String tableName) {
        TableMapping tm = mappingsByTable.get(tableName);
        Assert.notNull(tm, "Unknown mapping for table " + tableName);
        return tm;
    }

    public TableMapping getMappingForRegionName(String regionName) {
        TableMapping tm = mappingsByRegion.get(regionName);
        Assert.notNull(tm, "Unknown mapping for region " + regionName);
        return tm;
    }

    @SuppressWarnings("unchecked")
    private MappingManager() {
        try {
            String fn = System.getProperty("gemfire.jdbc.mapping-file-name", "jdbc-config.yml");
            LOG.info("fn={}", fn);
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fn);

            if (is == null) {
                throw new FileNotFoundException("Mapping file " + fn + " not found");
            }

            Yaml yaml = new Yaml();
            Map<String, ?> root = (Map<String, ?>) yaml.load(is);
            Assert.isTrue(!root.isEmpty(), "No mappings found in " + fn);

            Boolean doUpdate = (Boolean) root.get("doUpdate");
            Boolean doDelete = (Boolean) root.get("doDelete");

            this.doUpdate = doUpdate == null ? false : doUpdate;
            this.doDelete = doDelete == null ? false : doDelete;

            LOG.info("doUpdate={}, doDelete={}", doUpdate, doDelete);

            List<Map<String, ?>> configs = (List<Map<String, ?>>) root.get("configs");

            for (Map<String, ?> config : configs) {
                String driverClassString = (String) config.get("jdbcDriverClass");
                Assert.hasText(driverClassString, "Missing property 'jdbcDriverClass'");
                Class<?> driverClass = Class.forName(driverClassString);

                String url = (String) config.get("jdbcUrl");
                Assert.hasText(url, "Missing property 'jdbcUrl'");

                String user = (String) config.get("jdbcUsername");
                Assert.hasText(user, "Missing property 'jdbcUsername'");

                String pass = (String) config.get("jdbcPassword");
                Assert.hasText(pass, "Missing property 'jdbcPassword'");

                Integer minPoolSize = (Integer) config.get("minimumPoolSize");
                Integer maxPoolSize = (Integer) config.get("maximumPoolSize");

                minPoolSize = minPoolSize == null ? 1 : minPoolSize;
                maxPoolSize = maxPoolSize == null ? 10 : maxPoolSize;

                ConnectionConfiguration conn = new ConnectionConfiguration();

                conn.setDriverClass(driverClass);
                conn.setUrl(url);
                conn.setUsername(user);
                conn.setPassword(pass);
                conn.setMinimumPoolSize(minPoolSize);
                conn.setMaximumPoolSize(maxPoolSize);

                LOG.info("conn={}", conn);
                DataSource ds = createDataSource(conn);

                List<Map<String, ?>> tableMappingList = (List<Map<String, ?>>) config.get("tableMappings");
                Assert.notNull(tableMappingList, "Missing property 'tableMappings'");

                for (Map<String, ?> tableMappingMap : tableMappingList) {
                    String tableName = (String) tableMappingMap.get("tableName");
                    Assert.hasText(tableName, "Missing property 'tableName'");

                    String regionName = (String) tableMappingMap.get("regionName");
                    Assert.hasText(regionName, "Missing property 'regionName'");

                    String keyColumnName = (String) tableMappingMap.get("keyColumnName");
                    Assert.hasText(keyColumnName, "Missing property 'keyColumnName'");

                    TableMapping tableMapping = new TableMapping();

                    tableMapping.setConnection(conn);
                    tableMapping.setTableName(tableName);
                    tableMapping.setRegionName(regionName);
                    tableMapping.setKeyColumnName(keyColumnName);

                    Map<String, ColumnMapping> colMapsByCol = new HashMap<>();
                    Map<String, ColumnMapping> colMapsByFld = new HashMap<>();

                    tableMapping.setColumnMappingsByColumn(colMapsByCol);
                    tableMapping.setColumnMappingsByField(colMapsByFld);

                    List<Map<String, ?>> columnMappingList = (List<Map<String, ?>>) tableMappingMap.get("columnMappings");
                    Assert.notNull(columnMappingList, "Missing property 'columnMappings'");

                    for (Map<String, ?> columnMappingMap : columnMappingList) {
                        String columnName = (String) columnMappingMap.get("columnName");
                        Assert.hasText(columnName, "Missing property 'columnName'");

                        String fieldName = (String) columnMappingMap.get("fieldName");
                        Assert.hasText(fieldName, "Missing property 'fieldName'");

                        ColumnMapping columnMapping = new ColumnMapping();

                        columnMapping.setColumnName(columnName);
                        columnMapping.setFieldName(fieldName);

                        getColumnInfo(ds, tableName, columnMapping);

                        colMapsByCol.put(columnName, columnMapping);
                        colMapsByFld.put(fieldName, columnMapping);
                    }

                    LOG.info("tableMapping={}", tableMapping);
                    mappingsByTable.put(tableName, tableMapping);
                    mappingsByRegion.put(regionName, tableMapping);
                }

                DataSourceManager.getInstance().setDataSource(conn, ds);
            }
        } catch (Exception x) {
            LOG.error(x.toString(), x);
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    private void getColumnInfo(DataSource ds, String tableName, ColumnMapping mapping) throws Exception {
        String columnName = mapping.getColumnName();
        Connection conn = ds.getConnection();

        try {
            DatabaseMetaData dbmeta = conn.getMetaData();
            ResultSet res = dbmeta.getColumns(null, null, tableName, columnName);
            Assert.isTrue(res.next(), "Unknown column " + columnName + " in table " + tableName);

            int dt = res.getInt("DATA_TYPE");
            int sz = res.getInt("COLUMN_SIZE");

            mapping.setColumnType(dt);
            mapping.setColumnSize(sz);
        } finally {
            conn.close();
        }
    }

    private DataSource createDataSource(ConnectionConfiguration conf) {
        LOG.info("createDataSource: conf={}", conf);
        DataSource ds = new DataSource();

        ds.setDriverClassName(conf.getDriverClass().getName());
        ds.setUrl(conf.getUrl());
        ds.setUsername(conf.getUsername());
        ds.setPassword(conf.getPassword());
        ds.setDefaultAutoCommit(false);

        return ds;
    }
}
