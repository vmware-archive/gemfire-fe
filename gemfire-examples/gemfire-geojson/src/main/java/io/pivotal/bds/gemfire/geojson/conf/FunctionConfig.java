package io.pivotal.bds.gemfire.geojson.conf;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gemstone.gemfire.cache.execute.FunctionService;

import io.pivotal.bds.gemfire.geojson.data.Boundary;
import io.pivotal.bds.gemfire.geojson.function.AddFeatureFunction;
import io.pivotal.bds.gemfire.geojson.function.FindFeaturesFunction;

@Configuration
public class FunctionConfig {

    private static final Logger LOG = LoggerFactory.getLogger(FunctionConfig.class);

    @Bean
    public AddFeatureFunction addFeatureFunction(Boundary rootBoundary) {
        LOG.info("addFeatureFunction");
        AddFeatureFunction f = new AddFeatureFunction(rootBoundary);
        FunctionService.registerFunction(f);
        return f;
    }
    
    @Bean
    public FindFeaturesFunction findFeaturesFunction(Boundary rootBoundary) {
        LOG.info("findFeaturesFunction");
        FindFeaturesFunction f = new FindFeaturesFunction(rootBoundary);
        FunctionService.registerFunction(f);
        return f;
    }
}
