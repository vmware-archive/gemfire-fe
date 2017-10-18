package io.pivotal.bds.gemfire.analytics.server.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.analytics.common.SensorAnomaly;
import io.pivotal.bds.gemfire.analytics.common.SensorAnomalyKey;
import io.pivotal.bds.gemfire.analytics.common.SensorKey;
import io.pivotal.bds.gemfire.analytics.common.SensorReading;
import io.pivotal.bds.gemfire.analytics.common.SensorReadingKey;
import smile.classification.SVM;

public class SensorReadingCacheListener extends CacheListenerAdapter<SensorReadingKey, SensorReading> {

    private Region<String, SVM<double[]>> svmRegion;
    private Region<SensorAnomalyKey, SensorAnomaly> anomalyRegion;

    private static final Logger LOG = LoggerFactory.getLogger(SensorReadingCacheListener.class);

    public SensorReadingCacheListener(Region<String, SVM<double[]>> svmRegion,
            Region<SensorAnomalyKey, SensorAnomaly> anomalyRegion) {
        this.svmRegion = svmRegion;
        this.anomalyRegion = anomalyRegion;
    }

    @Override
    public void afterCreate(EntryEvent<SensorReadingKey, SensorReading> event) {
        LOG.info("afterCreate: event={}", event);
        predict(event);
    }

    @Override
    public void afterUpdate(EntryEvent<SensorReadingKey, SensorReading> event) {
        LOG.info("afterCreate: event={}", event);
        predict(event);
    }

    private void predict(EntryEvent<SensorReadingKey, SensorReading> event) {
        SensorReadingKey srk = event.getKey();
        SensorReading reading = event.getNewValue();
        LOG.info("predict: srk={}, reading={}", srk, reading);

        SensorKey sk = reading.getSensorKey();
        String id = sk.getId();
        double val = reading.getValue();

        SVM<double[]> svm = svmRegion.get(id);
        Assert.notNull(svm, "Unknown model " + id);

        double[] vals = new double[] { val };
        int y = svm.predict(vals);

        if (y == 1) {
            LOG.error("predict: y={}, srk={}, reading={}", y, srk, reading);
            SensorAnomalyKey sak = new SensorAnomalyKey(srk.getId());
            SensorAnomaly anom = new SensorAnomaly(sak, srk, sk);
            anomalyRegion.put(sak, anom);
        } else {
            LOG.info("predict: y={}, srk={}, reading={}", y, srk, reading);
        }
    }
}
