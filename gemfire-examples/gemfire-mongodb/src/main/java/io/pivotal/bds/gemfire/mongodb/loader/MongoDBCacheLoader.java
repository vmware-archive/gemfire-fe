package io.pivotal.bds.gemfire.mongodb.loader;

import java.util.Properties;

import org.bson.Document;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import io.pivotal.bds.gemfire.mongodb.util.MongoDBClientHelper;

public class MongoDBCacheLoader<K, V> implements CacheLoader<K, V>, Declarable {

    private Class<V> valueClass;
    private static final Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
    private static final Logger LOG = LoggerFactory.getLogger(MongoDBCacheLoader.class);

    @Override
    public V load(LoaderHelper<K, V> helper) throws CacheLoaderException {
        String regionName = helper.getRegion().getName();
        LOG.debug("load: regionName={}", regionName);

        MongoCollection<Document> collection = MongoDBClientHelper.getCollection(regionName);

        K key = helper.getKey();
        LOG.debug("load: regionName={}, key={}", regionName, key);

        Document kdoc = mapper.map(key, Document.class);
        LOG.debug("load: regionName={}, key={}, keyDoc={}", regionName, key, kdoc);

        FindIterable<Document> iter = collection.find(kdoc);
        MongoCursor<Document> cur = iter.iterator();

        if (!cur.hasNext()) {
            LOG.debug("load: regionName={}, key={}: value not found in mongodb", regionName, key);
            return null;
        }

        Document vdoc = cur.next();
        LOG.debug("load: regionName={}, key={}, valueDoc={}", regionName, key, vdoc);

        if (cur.hasNext()) {
            LOG.debug("load: regionName={}, key={}: multiple values found in mongodb", regionName, key);
            throw new CacheLoaderException("More than one document found for key " + kdoc);
        }

        V value = mapper.map(vdoc, valueClass);
        LOG.debug("load: regionName={}, key={}, valueDoc={}, value={}", regionName, key, vdoc, value);

        return value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void init(Properties props) {
        String sc = props.getProperty("valueClass");
        LOG.info("init: valueClass={}", sc);

        if (sc == null || sc.trim().length() == 0) {
            throw new IllegalArgumentException("Missing property 'valueClass'");
        }

        try {
            valueClass = (Class<V>) Class.forName(sc);
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    @Override
    public void close() {
    }

}
