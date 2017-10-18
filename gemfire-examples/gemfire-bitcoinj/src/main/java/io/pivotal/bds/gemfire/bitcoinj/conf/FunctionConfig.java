package io.pivotal.bds.gemfire.bitcoinj.conf;

import javax.annotation.Resource;

import org.bitcoinj.core.NetworkParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.FunctionService;

import io.pivotal.bds.gemfire.bitcoinj.function.AddWalletFunction;

@Component
public class FunctionConfig {
    
    private static final Logger LOG = LoggerFactory.getLogger(FunctionConfig.class);

    @Autowired
    public NetworkParameters networkParameters;
    
    @Resource
    public Region<String, byte[]> serializedWalletRegion;
    
    @Bean
    public static AddWalletFunction addWalletFunction(FunctionConfig functionConfig) {
        LOG.info("addWalletFunction");
        AddWalletFunction f = new AddWalletFunction(functionConfig.networkParameters, functionConfig.serializedWalletRegion);
        FunctionService.registerFunction(f);
        return f;
    }
}
