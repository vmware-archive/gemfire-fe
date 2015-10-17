package io.pivotal.bds.gemfire.analytics.client.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gemstone.gemfire.cache.InterestResultPolicy;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.cache.client.Pool;

import io.pivotal.bds.gemfire.analytics.client.mvc.listener.SensorAnomalyCacheListener;
import io.pivotal.bds.gemfire.analytics.common.Sensor;
import io.pivotal.bds.gemfire.analytics.common.SensorAnomaly;
import io.pivotal.bds.gemfire.analytics.common.SensorAnomalyKey;
import io.pivotal.bds.gemfire.analytics.common.SensorKey;
import io.pivotal.bds.gemfire.analytics.common.SensorReading;
import io.pivotal.bds.gemfire.analytics.common.SensorReadingKey;
import io.pivotal.bds.gemfire.analytics.common.TrainingParameters;
import io.pivotal.bds.gemfire.analytics.common.TrainingParametersKey;

@Configuration
public class RegionConfig {

    @Autowired
    private Pool pool;

    private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

    @Bean(name = "TrainingParametersRegionBean")
    public Region<TrainingParametersKey, TrainingParameters> createTrainingRegion(ClientCache cache) {
        LOG.info("creating TrainingParameters Region");
        ClientRegionFactory<TrainingParametersKey, TrainingParameters> crf = cache
                .createClientRegionFactory(ClientRegionShortcut.PROXY);
        crf.setPoolName(pool.getName());
        Region<TrainingParametersKey, TrainingParameters> r = crf.create("TrainingParameters");
        return r;
    }

    @Bean(name = "SensorRegionBean")
    public Region<SensorKey, Sensor> createSensorRegion(ClientCache cache) {
        LOG.info("creating Sensor Region");
        ClientRegionFactory<SensorKey, Sensor> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        crf.setPoolName(pool.getName());
        Region<SensorKey, Sensor> r = crf.create("Sensor");
        return r;
    }

    @Bean(name = "SensorReadingRegionBean")
    public Region<SensorReadingKey, SensorReading> createSensorReadingRegion(ClientCache cache) {
        LOG.info("creating SensorReading Region");
        ClientRegionFactory<SensorReadingKey, SensorReading> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        crf.setPoolName(pool.getName());
        Region<SensorReadingKey, SensorReading> r = crf.create("SensorReading");
        return r;
    }

    @Bean(name = "SensorAnomalyRegionBean")
    public Region<SensorAnomalyKey, SensorAnomaly> createSensorAnomalyRegion(ClientCache cache) {
        LOG.info("creating SensorAnomaly Region");
        ClientRegionFactory<SensorAnomalyKey, SensorAnomaly> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        crf.setPoolName(pool.getName());
        crf.addCacheListener(new SensorAnomalyCacheListener());
        Region<SensorAnomalyKey, SensorAnomaly> r = crf.create("SensorAnomaly");
        r.registerInterestRegex(".*", InterestResultPolicy.DEFAULT, false);
        return r;
    }
}
