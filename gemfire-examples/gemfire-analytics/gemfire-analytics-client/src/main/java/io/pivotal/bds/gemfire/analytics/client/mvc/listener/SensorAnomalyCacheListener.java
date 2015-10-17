package io.pivotal.bds.gemfire.analytics.client.mvc.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.analytics.common.SensorAnomaly;
import io.pivotal.bds.gemfire.analytics.common.SensorAnomalyKey;

public class SensorAnomalyCacheListener extends CacheListenerAdapter<SensorAnomalyKey, SensorAnomaly> {

    private static final Logger LOG = LoggerFactory.getLogger(SensorAnomalyCacheListener.class);

    @Override
    public void afterCreate(EntryEvent<SensorAnomalyKey, SensorAnomaly> event) {
        SensorAnomalyKey key = event.getKey();
        SensorAnomaly anomaly = event.getNewValue();
        LOG.error("afterCreate: key={}, anomaly={}", key, anomaly);
    }

}
