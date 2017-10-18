package io.pivotal.bds.gemfire.pmml.train.loader;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.geode.cache.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import io.pivotal.bds.gemfire.pmml.common.data.Model;
import io.pivotal.bds.gemfire.pmml.common.keys.ModelKey;

@Component
@EnableConfigurationProperties(LoaderProperties.class)
public class Loader implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Loader.class);

    private LoaderProperties loaderProperties;
    private Region<ModelKey, Model> modelRegion;

    public Loader(LoaderProperties loaderProperties, Region<ModelKey, Model> modelRegion) {
        this.loaderProperties = loaderProperties;
        this.modelRegion = modelRegion;
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("run: pmml file={}, model name={}, args={}", loaderProperties.pmmlModelFile, loaderProperties.pmmlModelName,
                (Object[]) args);

        byte[] b = Files.readAllBytes(Paths.get(loaderProperties.pmmlModelFile));
        String pmmlData = new String(b, "UTF-8");

        ModelKey key = new ModelKey(loaderProperties.pmmlModelName);
        Model model = new Model(key, pmmlData);
        
        modelRegion.put(key, model);
    }

}
