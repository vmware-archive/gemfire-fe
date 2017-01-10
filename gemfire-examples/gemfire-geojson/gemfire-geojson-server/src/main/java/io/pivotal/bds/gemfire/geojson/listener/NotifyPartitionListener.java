package io.pivotal.bds.gemfire.geojson.listener;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.partition.PartitionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotifyPartitionListener implements PartitionListener {

    private static final Logger LOG = LoggerFactory.getLogger(NotifyPartitionListener.class);

    @Override
    public void afterPrimary(int bucketId) {
        Cache cache = CacheFactory.getAnyInstance();
        String myNodeId = cache.getDistributedSystem().getDistributedMember().getId();
        LOG.info("afterPrimary: bucketId={}, myNodeId={}", bucketId, myNodeId);
        
        Region<Integer, String> bucketMappingRegion = cache.getRegion("bucketMapping");
        bucketMappingRegion.put(bucketId, myNodeId);
    }

    @Override
    public void afterRegionCreate(Region<?, ?> region) {
    }

    @Override
    public void afterBucketRemoved(int bucketId, Iterable<?> keys) {
    }

    @Override
    public void afterBucketCreated(int bucketId, Iterable<?> keys) {
    }

}
