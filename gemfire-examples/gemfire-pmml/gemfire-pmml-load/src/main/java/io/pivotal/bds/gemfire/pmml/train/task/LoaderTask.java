package io.pivotal.bds.gemfire.pmml.train.task;

import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.transform.Source;

import org.apache.geode.cache.Region;
import org.dmg.pmml.Output;
import org.dmg.pmml.OutputField;
import org.dmg.pmml.PMML;
import org.dmg.pmml.Target;
import org.dmg.pmml.Targets;
import org.jpmml.model.ImportFilter;
import org.jpmml.model.JAXBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;

import io.pivotal.bds.gemfire.pmml.common.data.Model;
import io.pivotal.bds.gemfire.pmml.common.keys.ModelKey;
import io.pivotal.bds.gemfire.pmml.train.conf.LoaderProperties;

@Component
@EnableConfigurationProperties(LoaderProperties.class)
public class LoaderTask implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(LoaderTask.class);

    private LoaderProperties loaderProperties;
    private Region<ModelKey, Model> modelRegion;

    public LoaderTask(LoaderProperties loaderProperties, Region<ModelKey, Model> modelRegion) {
        this.loaderProperties = loaderProperties;
        this.modelRegion = modelRegion;
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("run: pmml file={}, model name={}, args={}", loaderProperties.pmmlModelFile, loaderProperties.pmmlModelName,
                (Object[]) args);

        byte[] b = Files.readAllBytes(Paths.get(loaderProperties.pmmlModelFile));
        String pmmlData = new String(b, "UTF-8");

        Source source = ImportFilter.apply(new InputSource(new StringReader(pmmlData)));
        PMML pmml = JAXBUtil.unmarshalPMML(source);

        for (org.dmg.pmml.Model m : pmml.getModels()) {
            String mn = m.getModelName();
            LOG.info("model: name={}", mn);
            
            Targets targets = m.getTargets();

            if (targets != null) {
                for (Target t : targets) {
                    String fn = t.getField().getValue();
                    LOG.info("model: name={}, target field={}", mn, fn);
                }
            }
            
            Output output = m.getOutput();
            
            if (output != null) {
                List<OutputField> outputFields = output.getOutputFields();
                
                for (OutputField of: outputFields) {
                    String on = of.getName().getValue();
                    LOG.info("model: name={}, output field={}", mn, on);
                }
            }
        }

        ModelKey key = new ModelKey(loaderProperties.pmmlModelName);
        Model model = new Model(key, pmmlData);

        modelRegion.put(key, model);
    }

}
