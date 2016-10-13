package io.pivotal.bds.gemfire.mongodb.loader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.bson.Document;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import io.pivotal.bds.gemfire.mongodb.util.MongoDBClientHelper;

public class MongoDBCriteriaCacheLoader<K, V> implements CacheLoader<K, Collection<V>>, Declarable {

    private Class<V> valueClass;
    private String regionName;
    private static final Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
    private static final ObjectMapper omapper = new ObjectMapper();
    private static final Logger LOG = LoggerFactory.getLogger(MongoDBCriteriaCacheLoader.class);

    @SuppressWarnings("unchecked")
    @Override
    public Collection<V> load(LoaderHelper<K, Collection<V>> helper) throws CacheLoaderException {
        Object arg = helper.getArgument();
        LOG.debug("load: arg={}", arg);

        if (arg == null) {
            throw new CacheLoaderException("Missing criteria");
        }

        Map<String, Object> criteria = null;

        if (arg instanceof Map) {
            criteria = (Map<String, Object>) arg;
        } else if (arg instanceof String) {
            String s = (String) arg;
            try {
                criteria = omapper.readValue(s, Map.class);
            } catch (Exception x) {
                throw new CacheLoaderException(x.toString(), x);
            }
        }

        if (criteria.isEmpty()) {
            throw new CacheLoaderException("Criteria is empty");
        }

        String rn = this.regionName;
        rn = rn == null ? helper.getRegion().getName() : rn;
        LOG.debug("load: regionName={}, criteria={}", rn, criteria);

        MongoCollection<Document> collection = MongoDBClientHelper.getCollection(regionName);

        Document critdoc = new Document(criteria);
        LOG.debug("load: regionName={}, criteria={}, critdoc={}", regionName, criteria, critdoc);

        FindIterable<Document> iter = collection.find(critdoc);
        MongoCursor<Document> cur = iter.iterator();

        List<V> list = new ArrayList<>();

        while (cur.hasNext()) {
            Document vdoc = cur.next();
            V value = mapper.map(vdoc, valueClass);
            LOG.debug("load: regionName={}, criteria={}, valueDoc={}, value={}", regionName, criteria, vdoc, value);
            list.add(value);
        }

        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void init(Properties props) {
        String sc = props.getProperty("valueClass");
        regionName = props.getProperty("regionName");
        LOG.info("init: valueClass={}, regionName={}", sc, regionName);

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
