package io.pivotal.bds.gemfire.bitcoinj.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.PartitionAttributes;
import com.gemstone.gemfire.cache.PartitionAttributesFactory;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.RegionFactory;
import com.gemstone.gemfire.cache.RegionShortcut;

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
