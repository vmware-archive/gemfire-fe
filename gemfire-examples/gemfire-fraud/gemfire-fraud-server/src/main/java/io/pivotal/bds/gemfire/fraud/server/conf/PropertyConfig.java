package io.pivotal.bds.gemfire.fraud.server.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("PropertyConfig")
public class PropertyConfig {

    @Value("${locators:localhost[10334]}")
    public String locators;

    @Value("${cache-server.port:40404}")
    public int port;

    @Value("${diskStoreDirs:./}")
    public String diskStoreDirs;

    @Value("${redundantCopies:1}")
    public int redundantCopies;
    
    @Value("${numberOfBuckets:113}")
    public int numberOfBuckets;
    
    @Value("${cassandraContactPoints:localhost}")
    public String cassandraContactPoints;

    @Value("${cassandraKeyspace:gemfire}")
    public String cassandraKeyspace;

    @Value("${classifierModelSize:10}") 
    public int modelSize;
    
    @Value("${classifierNumberOfTrees:3}")
    public int numberOfTrees;
}
