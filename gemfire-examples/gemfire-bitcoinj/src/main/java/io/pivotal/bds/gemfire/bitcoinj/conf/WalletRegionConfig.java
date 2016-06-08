package io.pivotal.bds.gemfire.bitcoinj.conf;

import javax.annotation.Resource;

import org.bitcoinj.core.BlockChain;
import org.bitcoinj.core.PeerGroup;
import org.bitcoinj.wallet.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.RegionFactory;
import com.gemstone.gemfire.cache.RegionShortcut;

import io.pivotal.bds.gemfire.bitcoinj.writer.WalletCacheWriter;

@Component
public class WalletRegionConfig {
    
    private static final Logger LOG = LoggerFactory.getLogger(WalletRegionConfig.class);
    
    @Resource
    public Region<String, Wallet> walletRegion;

    @Bean
    public static Region<String, Wallet> walletRegion(Cache cache, PeerGroup peerGroup, BlockChain chain) {
        LOG.info("walletRegion");
        RegionFactory<String, Wallet> rf = cache.createRegionFactory(RegionShortcut.LOCAL);
        WalletCacheWriter writer = new WalletCacheWriter(peerGroup, chain);
        rf.setCacheWriter(writer);
        return rf.create("wallet");
    }
}
