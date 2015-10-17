package io.pivotal.bds.gemfire.ml;

import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;

import com.gemstone.gemfire.cache.Region;

@Service
public class ModelTrainingInitializer implements SmartLifecycle {

    @Resource
    private Region<String, TrainingParameters> svmTrainingRegion;

    @Autowired
    private ModelFactoryManager factories;

    @Autowired
    private ModelManager models;

    private boolean running = false;

    private static final Logger LOG = LoggerFactory.getLogger(ModelTrainingInitializer.class);

    @Override
    public void start() {
        LOG.info("starting");

        for (TrainingParameters params : svmTrainingRegion.values()) {
            LOG.info("training: params={}", params);

            ModelType type = params.getType();
            ModelFactory factory = factories.getFactory(type);

            String name = params.getModelName();
            String attr = params.getAttributeName();
            Properties props = params.getProperties();

            Model model = factory.create(name, attr, props);
    		model.train(params.getX(), params.getY());

            models.createModel(model);
        }

        running = true;
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public int getPhase() {
        return 0;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        running = false;
        callback.run();
    }

}
