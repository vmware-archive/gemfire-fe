package io.pivotal.bds.metrics.cassandra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(name = "metric", keyspace = "metrics")
public class CassandraMetric {

    @PartitionKey
    @Column(name = "metric_id")
    private String id;

    @Column(name = "metric_name")
    private String name;

    @Column(name = "metric_ts")
    private long ts;

    private final Map<String, String> tags = new HashMap<String, String>();
    private final List<CassandraMetricValue> values = new ArrayList<>();

    public CassandraMetric(long ts) {
        this.ts = ts;
    }

    public long getTs() {
        return ts;
    }

    public List<CassandraMetricValue> getValues() {
        return values;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "CassandraMetric [id=" + id + ", name=" + name + ", ts=" + ts + ", tags=" + tags + ", values=" + values + "]";
    }

}
