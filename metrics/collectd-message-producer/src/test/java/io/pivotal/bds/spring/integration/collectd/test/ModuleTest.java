package io.pivotal.bds.spring.integration.collectd.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.xd.dirt.server.singlenode.SingleNodeApplication;
import org.springframework.xd.dirt.test.SingleNodeIntegrationTestSupport;
import org.springframework.xd.dirt.test.SingletonModuleRegistry;
import org.springframework.xd.dirt.test.process.SingleNodeProcessingChainConsumer;
import org.springframework.xd.module.ModuleType;
import org.springframework.xd.test.RandomConfigurationSupport;

public class ModuleTest {

    private static SingleNodeApplication application;
    private static int RECEIVE_TIMEOUT = 6000;

    @BeforeClass
    public static void setUp() {
        RandomConfigurationSupport randomConfigSupport = new RandomConfigurationSupport();
        application = new SingleNodeApplication().run();
        SingleNodeIntegrationTestSupport singleNodeIntegrationTestSupport = new SingleNodeIntegrationTestSupport(application);
        singleNodeIntegrationTestSupport.addModuleRegistry(new SingletonModuleRegistry(ModuleType.source, "collectd"));
    }

    @Test
    public void test() {
        SingleNodeProcessingChainConsumer chain = new SingleNodeProcessingChainConsumer(application, "collectdStream", "collectd");

        Object payload = chain.receivePayload(RECEIVE_TIMEOUT);

        chain.destroy();
    }
}
