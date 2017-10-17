package io.pivotal.bds.gemfire.analytics.server.listener;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.RegionEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.analytics.common.TrainingParameters;
import io.pivotal.bds.gemfire.analytics.common.TrainingParametersKey;
import smile.classification.SVM;
import smile.math.kernel.MercerKernel;

public class TrainingCacheListener extends CacheListenerAdapter<TrainingParametersKey, TrainingParameters> {

    private MercerKernel<double[]> kernel;
    private double cp;
    private double cn;
    private Region<String, SVM<double[]>> svmRegion;

    private static final Logger LOG = LoggerFactory.getLogger(TrainingCacheListener.class);

    public TrainingCacheListener(MercerKernel<double[]> kernel, double cp, double cn, Region<String, SVM<double[]>> svmRegion) {
        this.kernel = kernel;
        this.cp = cp;
        this.cn = cn;
        this.svmRegion = svmRegion;
    }

    @Override
    public void afterCreate(EntryEvent<TrainingParametersKey, TrainingParameters> event) {
        String name = event.getKey().getId();
        TrainingParameters params = event.getNewValue();
        LOG.debug("afterCreate: name={}, params={}", name, params);
        train(name, params);
    }

    @Override
    public void afterUpdate(EntryEvent<TrainingParametersKey, TrainingParameters> event) {
        String name = event.getKey().getId();
        TrainingParameters params = event.getNewValue();
        LOG.debug("afterUpdate: name={}, params={}", name, params);
        train(name, params);
    }

    @Override
    public void afterDestroy(EntryEvent<TrainingParametersKey, TrainingParameters> event) {
        String name = event.getKey().getId();
        LOG.debug("afterDestroy: name={}", name);
        svmRegion.remove(name);
    }

    @Override
    public void afterRegionCreate(RegionEvent<TrainingParametersKey, TrainingParameters> event) {
        LOG.info("afterRegionCreate");
        Region<TrainingParametersKey, TrainingParameters> trainingRegion = event.getRegion();
        for (Map.Entry<TrainingParametersKey, TrainingParameters> entry: trainingRegion.entrySet()) {
            train(entry.getKey().getId(), entry.getValue());
        }
    }

    private void train(String name, TrainingParameters params) {
        LOG.debug("train: name={}, params={}", name, params);
        double[][] x = params.getX();
        int[] y = params.getY();

        SVM<double[]> svm = new SVM<>(kernel, cp, cn);
        svm.learn(x, y);

        svmRegion.put(name, svm);
    }
}
