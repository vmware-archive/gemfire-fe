package io.pivotal.bds.gemfire.drools.server.conf;

import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.io.KieResources;
import org.kie.api.runtime.KieContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KieConfig {

    private static final Logger LOG = LoggerFactory.getLogger(KieConfig.class);

    @Bean
    public KieServices createKieServices() {
        LOG.info("creating KieServices");
        return KieServices.Factory.get();
    }

    @Bean
    public KieFileSystem createKieFileSystem(KieServices svcs) {
        LOG.info("creating KieFileSystem");
        return svcs.newKieFileSystem();
    }

    @Bean
    public KieResources createKieResources(KieServices svcs) {
        LOG.info("creating KieResources");
        return svcs.getResources();
    }

    @Bean
    public KieContainer createKieContainer(KieServices svcs) {
        LOG.info("creating KieContainer");
        return svcs.newKieClasspathContainer();
    }

    @Bean
    public KieRepository createKieRepository(KieServices svcs) {
        return svcs.getRepository();
    }
}
