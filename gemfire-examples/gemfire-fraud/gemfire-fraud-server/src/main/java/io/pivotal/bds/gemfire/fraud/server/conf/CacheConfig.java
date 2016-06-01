package io.pivotal.bds.gemfire.fraud.server.conf;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.DiskStore;
import com.gemstone.gemfire.cache.DiskStoreFactory;
import com.gemstone.gemfire.cache.server.CacheServer;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;

import io.pivotal.bds.gemfire.fraud.common.Constants;

@Configuration("CacheConfig")
public class CacheConfig implements Constants {

    @Autowired
    private PropertyConfig properties;

    private static final Logger LOG = LoggerFactory.getLogger(CacheConfig.class);

    @Bean
    public Cache createCache() throws Exception {
        LOG.info("creating Cache: locators={}, port={}", properties.locators, properties.port);
        CacheFactory cf = new CacheFactory();
        cf.set("locators", properties.locators);

        cf.setPdxPersistent(true);
        cf.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.fraud.common.data.*"));

        Cache c = cf.create();

        LOG.info("creating CacheServer");
        CacheServer cs = c.addCacheServer();
        cs.setPort(properties.port);
        cs.start();

        return c;
    }

    @Bean
    public DiskStore accountDiskStore(Cache cache) {
        LOG.info("accountDiskStore");
        return createDiskStore(cache, ACCOUNT_DISK_STORE_NAME);
    }

    @Bean
    public DiskStore accountClassifierDataDiskStore(Cache cache) {
        LOG.info("accountClassifierDataDiskStore");
        return createDiskStore(cache, ACCOUNT_CLASSIFIER_DATA_DISK_STORE_NAME);
    }

    @Bean
    public DiskStore accountBalanceDiskStore(Cache cache) {
        LOG.info("accountBalanceDiskStore");
        return createDiskStore(cache, ACCOUNT_BALANCE_DISK_STORE_NAME);
    }

    @Bean
    public DiskStore transactionDiskStore(Cache cache) {
        LOG.info("transactionDiskStore");
        return createDiskStore(cache, TRANSACTION_DISK_STORE_NAME);
    }

    @Bean
    public DiskStore transactionHistoryDiskStore(Cache cache) {
        LOG.info("transactionHistoryDiskStore");
        return createDiskStore(cache, TRANSACTION_HISTORY_DISK_STORE_NAME);
    }

    @Bean
    public DiskStore transactionStatusDiskStore(Cache cache) {
        LOG.info("transactionStatusDiskStore");
        return createDiskStore(cache, TRANSACTION_STATUS_DISK_STORE_NAME);
    }

    @Bean
    public DiskStore cardDiskStore(Cache cache) {
        LOG.info("cardDiskStore");
        return createDiskStore(cache, CARD_DISK_STORE_NAME);
    }

    @Bean
    public DiskStore cardBalanceDiskStore(Cache cache) {
        LOG.info("cardBalanceDiskStore");
        return createDiskStore(cache, CARD_BALANCE_DISK_STORE_NAME);
    }

    @Bean
    public DiskStore cardClassifierDataDiskStore(Cache cache) {
        LOG.info("cardClassifierDataDiskStore");
        return createDiskStore(cache, CARD_CLASSIFIER_DATA_DISK_STORE_NAME);
    }

    @Bean
    public DiskStore vendorDiskStore(Cache cache) {
        LOG.info("vendorDiskStore");
        return createDiskStore(cache, VENDOR_DISK_STORE_NAME);
    }

    @Bean
    public DiskStore alertDiskStore(Cache cache) {
        LOG.info("alertDiskStore");
        return createDiskStore(cache, ALERT_DISK_STORE_NAME);
    }

    @Bean
    public DiskStore queueDiskStore(Cache cache) {
        LOG.info("queueDiskStore");
        return createDiskStore(cache, QUEUE_DISK_STORE_NAME);
    }

    private DiskStore createDiskStore(Cache cache, String name) {
        LOG.info("createDiskStore: name={}, diskStoreDirs={}", name, properties.diskStoreDirs);
        DiskStoreFactory f = cache.createDiskStoreFactory();

        String[] ss = properties.diskStoreDirs.split(",");
        File[] dirs = new File[ss.length];

        for (int i = 0; i < ss.length; ++i) {
            dirs[i] = new File(ss[i]);
        }

        f.setDiskDirs(dirs);
        return f.create(name);
    }

}
