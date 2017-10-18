package io.pivotal.bds.gemfire.bitcoinj.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.PartitionAttributes;
import org.apache.geode.cache.PartitionAttributesFactory;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionFactory;
import org.apache.geode.cache.RegionShortcut;

import io.pivotal.bds.gemfire.bitcoinj.listener.SerializedWalletPartitionListener;
import io.pivotal.bds.gemfire.bitcoinj.writer.SerializedWalletCacheWriter;

@Component
public class SerializedWalletRegionConfig {

    private static final Logger LOG = LoggerFactory.getLogger(SerializedWalletRegionConfig.class);

    @Bean
    public static Region<String, byte[]> serializedWalletRegion(Cache cache, WalletRegionConfig walletRegionConfig) {
        LOG.info("serializedWalletRegion");
        RegionFactory<String, byte[]> rf = cache.createRegionFactory(RegionShortcut.PARTITION_REDUNDANT_PERSISTENT_OVERFLOW);

        SerializedWalletCacheWriter writer = new SerializedWalletCacheWriter(walletRegionConfig.walletRegion, null);
        rf.setCacheWriter(writer);

        PartitionAttributesFactory<String, byte[]> paf = new PartitionAttributesFactory<>();
        paf.addPartitionListener(new SerializedWalletPartitionListener(walletRegionConfig.walletRegion, null));
        PartitionAttributes<String, byte[]> pattrs = paf.create();
        rf.setPartitionAttributes(pattrs);

        return rf.create("serializedWallet");
    }
}
