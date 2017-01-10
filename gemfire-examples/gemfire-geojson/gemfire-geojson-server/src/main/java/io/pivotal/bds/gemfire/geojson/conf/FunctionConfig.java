package io.pivotal.bds.gemfire.geojson.conf;

import org.slf4j.LoggerFactory;
import org.apache.geode.cache.execute.FunctionService;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codahale.metrics.MetricRegistry;

import io.pivotal.bds.gemfire.geojson.data.Boundary;
import io.pivotal.bds.gemfire.geojson.function.FindFeaturesFunction;

@Configuration
public class FunctionConfig {

    private static final Logger LOG = LoggerFactory.getLogger(FunctionConfig.class);

    @Bean
    public FindFeaturesFunction findFeaturesFunction(Boundary rootBoundary, MetricRegistry registry) {
        LOG.info("findFeaturesFunction");
        FindFeaturesFunction f = new FindFeaturesFunction(rootBoundary, registry);
        FunctionService.registerFunction(f);
        return f;
    }
}
