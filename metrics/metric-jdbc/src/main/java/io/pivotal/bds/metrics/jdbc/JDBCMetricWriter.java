package io.pivotal.bds.metrics.jdbc;

import java.sql.Connection;

import javax.sql.DataSource;

import io.pivotal.bds.metrics.data.Metric;
import io.pivotal.bds.metrics.writer.MetricWriter;

public class JDBCMetricWriter extends MetricWriter {
    
    private DataSource source;

    public JDBCMetricWriter(String name, DataSource source) {
        super(name);
        this.source = source;
    }

    @Override
    protected void doWriter(Metric metric) throws Exception {
        Connection conn = source.getConnection();
        
        try {
            
        } finally {
            conn.close();
        }
    }
}
