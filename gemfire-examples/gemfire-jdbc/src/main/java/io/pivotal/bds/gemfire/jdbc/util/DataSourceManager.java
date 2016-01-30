package io.pivotal.bds.gemfire.jdbc.util;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.util.Assert;

public class DataSourceManager {

    private Map<ConnectionConfiguration, DataSource> sources = new HashMap<>();

    private static DataSourceManager instance = new DataSourceManager();

    public static DataSourceManager getInstance() {
        return instance;
    }

    public DataSource getDataSource(ConnectionConfiguration conn) {
        DataSource ds = sources.get(conn);
        Assert.notNull(ds);
        return ds;
    }

    public void setDataSource(ConnectionConfiguration conn, DataSource ds) {
        Assert.isTrue(sources.putIfAbsent(conn, ds) == null, "DataSource for URL " + conn.getUrl() + " is duplicated");
    }
}
