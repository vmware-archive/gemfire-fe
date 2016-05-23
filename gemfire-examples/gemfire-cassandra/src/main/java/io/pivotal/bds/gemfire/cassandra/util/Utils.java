package io.pivotal.bds.gemfire.cassandra.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;

public class Utils {

    private static Cluster cluster;
    private static Session session;
    private static MappingManager mappingManager;
    private static Map<Class<?>, Mapper<?>> mappers = new HashMap<>();
    private static final Logger LOG = LoggerFactory.getLogger(Utils.class);

    public static synchronized Cluster getCluster() {
        if (cluster == null) {
            String host = System.getProperty("cassandra.host", "localhost");
            LOG.info("getCluster: host={}", host);
            cluster = Cluster.builder().addContactPoint(host).build();
        }

        return cluster;
    }

    public static synchronized Session getSession() {
        if (session == null) {
            String keyspace = System.getProperty("cassandra.keyspace", "gemfire");
            LOG.info("getSession: keyspace={}", keyspace);
            session = getCluster().connect(keyspace);
        }

        return session;
    }

    public static synchronized MappingManager getMappingManager() {
        if (mappingManager == null) {
            LOG.info("getMappingManager");
            mappingManager = new MappingManager(getSession());
        }

        return mappingManager;
    }

    @SuppressWarnings("unchecked")
    public static synchronized <T> Mapper<T> getMapper(Class<T> cls) {
        Mapper<?> m = mappers.get(cls);

        if (m == null) {
            m = getMappingManager().mapper(cls);
            mappers.put(cls, m);
        }

        return (Mapper<T>) m;
    }
}
