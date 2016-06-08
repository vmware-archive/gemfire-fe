package io.pivotal.bds.gemfire.bitcoinj.conf;

import org.bitcoinj.core.BlockChain;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.PeerGroup;
import org.bitcoinj.params.RegTestParams;
import org.bitcoinj.store.BlockStore;
import org.bitcoinj.wallet.WalletExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.pivotal.bds.gemfire.bitcoinj.serializer.StoredBlockSerializer;

@Configuration
public class BitcoinConfig {
    
    private static final Logger LOG = LoggerFactory.getLogger(BitcoinConfig.class);

    @Bean
    public static NetworkParameters networkParameters() {
        LOG.info("networkParameters");
        NetworkParameters params = RegTestParams.get();
        StoredBlockSerializer.setParams(params);
        return params;
    }

    @Bean
    public static PeerGroup peerGroup(NetworkParameters networkParameters, BlockChain blockChain) {
        LOG.info("peerGroup");
        PeerGroup peerGroup = new PeerGroup(networkParameters, blockChain);
        peerGroup.start();
        peerGroup.connectToLocalHost();
        return peerGroup;
    }

    @Bean
    public static BlockChain blockChain(NetworkParameters networkParameters, BlockStore blockStore) throws Exception {
        LOG.info("blockChain");
        BlockChain ch = new BlockChain(networkParameters, blockStore);
        return ch;
    }
    
    public static WalletExtension walletExtension() {
        return null;
    }
}
