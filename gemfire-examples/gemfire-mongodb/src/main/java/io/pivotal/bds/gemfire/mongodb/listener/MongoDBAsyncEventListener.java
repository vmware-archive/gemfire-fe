package io.pivotal.bds.gemfire.mongodb.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.bson.Document;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.Operation;
import org.apache.geode.cache.asyncqueue.AsyncEvent;
import org.apache.geode.cache.asyncqueue.AsyncEventListener;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.DeleteOneModel;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.UpdateOneModel;
import com.mongodb.client.model.WriteModel;

import io.pivotal.bds.gemfire.mongodb.util.MongoDBClientHelper;

public class MongoDBAsyncEventListener implements AsyncEventListener, Declarable {

    private static final Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
    private final Set<String> ignoredOperations = new HashSet<>();
    private static final Logger LOG = LoggerFactory.getLogger(MongoDBAsyncEventListener.class);

    @SuppressWarnings("rawtypes")
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        LOG.debug("processEvents: events.size={}", events.size());

        try {
            // organize events by region to facilitate bulk mongo operations
            Map<String, List<AsyncEvent>> eventMap = new HashMap<>();

            for (AsyncEvent event : events) {
                Operation op = event.getOperation(); // ignore loads from CacheLoader
                if (!op.isLoad() && (ignoredOperations.isEmpty() || !ignoredOperations.contains(op.toString()))) {
                    String regionName = event.getRegion().getName();

                    List<AsyncEvent> list = eventMap.get(regionName);

                    if (list == null) {
                        list = new ArrayList<>();
                        eventMap.put(regionName, list);
                    }

                    LOG.debug("processEvents: event={}", event);
                    list.add(event);
                } else {
                    LOG.debug("processEvents: ignoring operation {} for event {}", event.getOperation(), event);
                }
            }

            for (Map.Entry<String, List<AsyncEvent>> entry : eventMap.entrySet()) {
                String regionName = entry.getKey();

                MongoCollection<Document> collection = MongoDBClientHelper.getCollection(regionName);

                List<AsyncEvent> list = entry.getValue();
                List<WriteModel<Document>> opers = new ArrayList<>();

                for (AsyncEvent evt : list) {
                    Operation op = evt.getOperation();
                    Object value = evt.getDeserializedValue();
                    Document doc = mapper.map(value, Document.class);

                    if (op.isCreate()) {
                        InsertOneModel<Document> iom = new InsertOneModel<Document>(doc);
                        opers.add(iom);
                    } else if (op.isUpdate()) {
                        UpdateOneModel<Document> uom = new UpdateOneModel<>(doc, doc);
                        opers.add(uom);
                    } else if (op.isDestroy()) {
                        DeleteOneModel<Document> dom = new DeleteOneModel<>(doc);
                        opers.add(dom);
                    }
                }

                LOG.debug("processEvents: regionName={}, opers.size={}", regionName, opers.size());

                if (!opers.isEmpty()) {
                    collection.bulkWrite(opers);
                } else {
                    LOG.warn("processEvents: regionName={}, operations is empty", regionName);
                }

            }

            return true;
        } catch (Exception x) {
            LOG.error("processEvents: x={}", x.toString(), x);
            return false;
        }
    }

    @Override
    public void init(Properties props) {
        String ignoredOpers = props.getProperty("ignoredOperations");
        LOG.info("init: ignoredOperations={}", ignoredOpers);

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
