package io.pivotal.bds.gemfire.analytics.server.conf;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.util.Assert;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.PartitionAttributes;
import org.apache.geode.cache.PartitionAttributesFactory;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionFactory;
import org.apache.geode.cache.RegionShortcut;

import io.pivotal.bds.gemfire.analytics.common.Sensor;
import io.pivotal.bds.gemfire.analytics.common.SensorAnomaly;
import io.pivotal.bds.gemfire.analytics.common.SensorAnomalyKey;
import io.pivotal.bds.gemfire.analytics.common.SensorKey;
import io.pivotal.bds.gemfire.analytics.common.SensorReading;
import io.pivotal.bds.gemfire.analytics.common.SensorReadingKey;
import io.pivotal.bds.gemfire.analytics.common.TrainingParameters;
import io.pivotal.bds.gemfire.analytics.common.TrainingParametersKey;
import io.pivotal.bds.gemfire.analytics.server.listener.SensorReadingCacheListener;
import io.pivotal.bds.gemfire.analytics.server.listener.TrainingCacheListener;
import smile.classification.SVM;
import smile.math.kernel.GaussianKernel;
import smile.math.kernel.MercerKernel;

@Configuration
public class RegionConfig {

    @Autowired
    private PropertyConfig config;

    @Resource(name = "SVMRegionBean")
    private Region<String, SVM<double[]>> svmRegion;

    @Resource(name = "SensorReadingRegionBean")
    private Region<SensorReadingKey, SensorReading> sensorReadingRegion;

    @Resource(name = "SensorAnomalyRegionBean")
    private Region<SensorAnomalyKey, SensorAnomaly> sensorAnomalyRegion;

    private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

    @Bean(name = "SVMRegionBean")
    public Region<String, SVM<double[]>> createSVMRegion(Cache cache) {
        LOG.info("creating SVMRegionBean");
        RegionFactory<String, SVM<double[]>> rf = cache.createRegionFactory(RegionShortcut.LOCAL);
        Region<String, SVM<double[]>> r = rf.create("SVM");
        return r;
    }

    @Bean(name = "TrainingRegionBean")
    @DependsOn("SVMRegionBean")
    public Region<TrainingParametersKey, TrainingParameters> createTrainingRegion(Cache cache) {
        LOG.info("creating TrainingRegionBean");

        Assert.notNull(svmRegion, "SMVRegionBean is null");

        RegionFactory<TrainingParametersKey, TrainingParameters> rf = cache
                .createRegionFactory(RegionShortcut.REPLICATE_PERSISTENT);

        double sigma = config.svmSigma;
        double c = config.svmSoftMargin;
        MercerKernel<double[]> kernel = new GaussianKernel(sigma);
        LOG.info("creating TrainingRegionBean: sigma={}, c={}", sigma, c);

        rf.addCacheListener(new TrainingCacheListener(kernel, c, c, svmRegion));

        Region<TrainingParametersKey, TrainingParameters> r = rf.create("TrainingParameters");
        return r;
    }

    @Bean(name = "SensorRegionBean")
    public Region<SensorKey, Sensor> createSensorRegion(Cache cache) {
        LOG.info("creating SensorRegionBean");

        RegionFactory<SensorKey, Sensor> rf = cache.createRegionFactory(RegionShortcut.REPLICATE_PERSISTENT);

        Region<SensorKey, Sensor> r = rf.create("Sensor");
        return r;
    }

    @Bean(name = "SensorReadingRegionBean")
    @DependsOn("SVMRegionBean")
    public Region<SensorReadingKey, SensorReading> createSensorReadingRegion(Cache cache) {
        LOG.info("creating SensorReadingRegionBean");

        RegionFactory<SensorReadingKey, SensorReading> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT_OVERFLOW);

        Region<SensorReadingKey, SensorReading> r = rf.create("SensorReading");
        return r;
    }

    @Bean(name = "SensorAnomalyRegionBean")
    @DependsOn("SensorReadingRegionBean")
    public Region<SensorAnomalyKey, SensorAnomaly> createSensorAnomalyRegion(Cache cache) {
        LOG.info("creating SensorAnomalyRegionBean");

        RegionFactory<SensorAnomalyKey, SensorAnomaly> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT_OVERFLOW);

        PartitionAttributesFactory<SensorAnomalyKey, SensorAnomaly> paf = new PartitionAttributesFactory<>();
        paf.setColocatedWith(sensorReadingRegion.getFullPath());
        PartitionAttributes<SensorAnomalyKey, SensorAnomaly> pattrs = paf.create();
        rf.setPartitionAttributes(pattrs);

        Region<SensorAnomalyKey, SensorAnomaly> r = rf.create("SensorAnomaly");
        return r;
    }

    @PostConstruct
    public void post() {
        LOG.info("attaching SensorReadingCacheListener");
        sensorReadingRegion.getAttributesMutator().addCacheListener(new SensorReadingCacheListener(svmRegion, sensorAnomalyRegion));
    }
}
