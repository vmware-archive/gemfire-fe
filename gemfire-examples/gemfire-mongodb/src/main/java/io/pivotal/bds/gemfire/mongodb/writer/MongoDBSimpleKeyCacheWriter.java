package io.pivotal.bds.gemfire.mongodb.writer;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.bson.Document;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.CacheWriter;
import org.apache.geode.cache.CacheWriterException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Operation;
import org.apache.geode.cache.RegionEvent;
import com.mongodb.client.MongoCollection;

import io.pivotal.bds.gemfire.mongodb.util.MongoDBClientHelper;

public class MongoDBSimpleKeyCacheWriter<K, V> implements CacheWriter<K, V>, Declarable {

    private String keyFieldName;
    private static final Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
    private final Set<String> ignoredOperations = new HashSet<>();
    private static final Logger LOG = LoggerFactory.getLogger(MongoDBSimpleKeyCacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<K, V> event) throws CacheWriterException {
        LOG.debug("beforeCreate: event={}", event);

        Operation op = event.getOperation();

        if (!op.isLoad() && (ignoredOperations.isEmpty() || !ignoredOperations.contains(op.toString()))) {
            String regionName = event.getRegion().getName();
            MongoCollection<Document> collection = MongoDBClientHelper.getCollection(regionName);

            V value = event.getNewValue();
            Document doc = mapper.map(value, Document.class);

            collection.insertOne(doc);
        } else {
            LOG.debug("beforeCreate: ignoring operation {} for event {}", op, event);
        }
    }

    @Override
    public void beforeUpdate(EntryEvent<K, V> event) throws CacheWriterException {
        LOG.debug("beforeUpdate: event={}", event);

        Operation op = event.getOperation();

        if (ignoredOperations.isEmpty() || !ignoredOperations.contains(op.toString())) {
            String regionName = event.getRegion().getName();
            MongoCollection<Document> collection = MongoDBClientHelper.getCollection(regionName);

            K key = event.getKey();

            Document kdoc = new Document();
            kdoc.put(keyFieldName, key);
            LOG.debug("beforeUpdate: regionName={}, key={}, keyDoc={}", regionName, key, kdoc);

            V value = event.getNewValue();
            Document vdoc = mapper.map(value, Document.class);

            collection.updateOne(kdoc, vdoc);
        } else {
            LOG.debug("beforeUpdate: ignoring operation {} for event {}", op, event);
        }
    }

    @Override
    public void beforeDestroy(EntryEvent<K, V> event) throws CacheWriterException {
        LOG.debug("beforeDestroy: event={}", event);

        Operation op = event.getOperation();

        if (ignoredOperations.isEmpty() || !ignoredOperations.contains(op.toString())) {
            String regionName = event.getRegion().getName();
            MongoCollection<Document> collection = MongoDBClientHelper.getCollection(regionName);

            K key = event.getKey();

            Document kdoc = new Document();
            kdoc.put(keyFieldName, key);
            LOG.debug("beforeDestroy: regionName={}, key={}, keyDoc={}", regionName, key, kdoc);

            collection.deleteOne(kdoc);
        } else {
            LOG.debug("beforeDestroy: ignoring operation {} for event {}", op, event);
        }
    }

    @Override
    public void beforeRegionClear(RegionEvent<K, V> event) throws CacheWriterException {
    }

    @Override
    public void beforeRegionDestroy(RegionEvent<K, V> event) throws CacheWriterException {
    }

    @Override
    public void init(Properties props) {
        keyFieldName = props.getProperty("keyFieldName", "id");
        String ignoredOpers = props.getProperty("ignoredOperations");
        LOG.info("init: keyFieldName={}, ignoredOperations={}", keyFieldName, ignoredOpers);

        if (ignoredOpers != null && ignoredOpers.trim().length() > 0) {
            String[] sa = ignoredOpers.split(",");

            for (String s : sa) {
                ignoredOperations.add(s);
            }
        }
    }

    @Override
    public void close() {
    }

}
