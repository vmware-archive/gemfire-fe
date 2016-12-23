package io.pivotal.bds.gemfire.geojson.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfig {

    @Value("${locators:localhost[10334]}")
    public String locators;
    
    @Value("${cache-server.port:40404}")
    public int port;
    
}
