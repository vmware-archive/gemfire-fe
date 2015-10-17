package io.pivotal.bds.gemfire.script.conf;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScriptConfig {

    @Value("${engineName:groovy}")
    private String engineName;

    private static final Logger LOG = LoggerFactory.getLogger(ScriptConfig.class);

    @Bean
    public ScriptEngine createEngine() {
        LOG.info("creating ScriptEngine: engineName={}", engineName);
        ScriptEngine engine = new ScriptEngineManager().getEngineByName(engineName);
        return engine;
    }
}
