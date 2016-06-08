package io.pivotal.bds.gemfire.bitcoinj.conf;

import javax.annotation.Resource;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.core.StoredBlock;
import org.bitcoinj.store.BlockStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.RegionFactory;
import com.gemstone.gemfire.cache.RegionShortcut;

import io.pivotal.bds.gemfire.bitcoinj.store.GemfireBlockStore;

@Component
public class BlockStoreConfig {

    private static final Logger LOG = LoggerFactory.getLogger(BlockStoreConfig.class);

    @Resource
    public Region<Sha256Hash, StoredBlock> blockRegion;

    @Bean
    public static Region<Sha256Hash, StoredBlock> blockRegion(Cache cache) {
        LOG.info("blockRegion");
        RegionFactory<Sha256Hash, StoredBlock> rf = cache.createRegionFactory(RegionShortcut.PARTITION_REDUNDANT_PERSISTENT_OVERFLOW);
        return rf.create("block");
    }

    @Bean
    public static BlockStore blockStore(NetworkParameters networkParameters, BlockStoreConfig blockStoreConfig) throws Exception {
        LOG.info("blockStore");
        return new GemfireBlockStore(networkParameters, blockStoreConfig.blockRegion);
    }

}
