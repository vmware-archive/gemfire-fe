package io.pivotal.bds.gemfire.geojson.listener;

import java.io.StringReader;
import java.util.Set;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.util.CacheListenerAdapter;
import org.apache.geode.internal.cache.PartitionedRegion;
import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.pivotal.bds.gemfire.geojson.data.Boundary;

public class BucketMappingChangeCacheListener extends CacheListenerAdapter<Integer, String> {

    private Boundary rootBoundary;

    private static final FeatureJSON json = new FeatureJSON();
    private static final Logger LOG = LoggerFactory.getLogger(BucketMappingChangeCacheListener.class);

    public BucketMappingChangeCacheListener(Boundary rootBoundary) {
        this.rootBoundary = rootBoundary;
    }

    @Override
    public void afterCreate(EntryEvent<Integer, String> event) {
        LOG.debug("afterCreate: event={}", event);
        add(event);
    }

    @Override
    public void afterDestroy(EntryEvent<Integer, String> event) {
        LOG.debug("afterDestroy: event={}", event);
        remove(event);
    }

    @Override
    public void afterUpdate(EntryEvent<Integer, String> event) {
        LOG.debug("afterUpdate: event={}", event);
        remove(event);
        add(event);
    }

    @SuppressWarnings("unchecked")
    private void add(EntryEvent<Integer, String> event) {
        String nodeId = event.getNewValue();
        Cache cache = CacheFactory.getAnyInstance();
        String myNodeId = cache.getDistributedSystem().getDistributedMember().getId();

        if (nodeId.equals(myNodeId)) {
            try {
                Region<Integer, String> jsonRegion = cache.getRegion("jsonFeature");
                PartitionedRegion pr = (PartitionedRegion) jsonRegion;

                int bucketId = event.getKey();
                Set<String> keys = pr.getBucketKeys(bucketId);

                for (String id : keys) {
                    String raw = jsonRegion.get(id);
                    LOG.debug("create: id={}, raw={}", id, raw);

                    StringReader reader = new StringReader(raw);
                    SimpleFeature feature = json.readFeature(reader);

                    rootBoundary.addFeature(feature);
                }
            } catch (Exception x) {
                LOG.error("create: x={}", x.toString(), x);
                throw new IllegalArgumentException(x.toString(), x);
            }
        } else {
            LOG.debug("create: different node: nodeId={}, myNodeId={}", nodeId, myNodeId);
        }
    }

    @SuppressWarnings("unchecked")
    private void remove(EntryEvent<Integer, String> event) {
        String nodeId = event.getOldValue();
        Cache cache = CacheFactory.getAnyInstance();
        String myNodeId = cache.getDistributedSystem().getDistributedMember().getId();

        if (nodeId.equals(myNodeId)) {
            Region<Integer, String> jsonRegion = cache.getRegion("jsonFeature");
            PartitionedRegion pr = (PartitionedRegion) jsonRegion;

            int bucketId = event.getKey();
            Set<Integer> keys = pr.getBucketKeys(bucketId);

            for (Integer id : keys) {
                LOG.debug("remove: id={}", id);
                rootBoundary.removeFeature(id);
            }
        } else {
            LOG.debug("remove: different node: nodeId={}, myNodeId={}", nodeId, myNodeId);
        }
    }
}
