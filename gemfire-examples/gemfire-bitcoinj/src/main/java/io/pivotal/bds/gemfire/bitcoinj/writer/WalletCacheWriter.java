package io.pivotal.bds.gemfire.bitcoinj.writer;

import org.bitcoinj.core.BlockChain;
import org.bitcoinj.core.PeerGroup;
import org.bitcoinj.wallet.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.CacheWriterException;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.util.CacheWriterAdapter;

public class WalletCacheWriter extends CacheWriterAdapter<String, Wallet> {

    private PeerGroup peerGroup;
    private BlockChain chain;

    private static final Logger LOG = LoggerFactory.getLogger(WalletCacheWriter.class);

    public WalletCacheWriter(PeerGroup peerGroup, BlockChain chain) {
        this.peerGroup = peerGroup;
        this.chain = chain;
    }

    @Override
    public void beforeCreate(EntryEvent<String, Wallet> event) throws CacheWriterException {
        String key = event.getKey();
        Wallet wallet = event.getNewValue();
        LOG.info("beforeCreate: key={}, wallet={}", key, wallet);

        peerGroup.addWallet(wallet);
        chain.addWallet(wallet);
    }

    @Override
    public void beforeDestroy(EntryEvent<String, Wallet> event) throws CacheWriterException {
        String key = event.getKey();
        Wallet wallet = event.getOldValue();
        LOG.info("beforeDestroy: key={}, wallet={}", key, wallet);

        peerGroup.removeWallet(wallet);
        chain.removeWallet(wallet);
    }

    @Override
    public void beforeUpdate(EntryEvent<String, Wallet> event) throws CacheWriterException {
        String key = event.getKey();
        Wallet oldWallet = event.getOldValue();
        Wallet newWallet = event.getNewValue();
        LOG.info("beforeUpdate: key={}, oldWallet={}, newWallet={}", key, oldWallet, newWallet);

        peerGroup.removeWallet(oldWallet);
        chain.removeWallet(oldWallet);

        peerGroup.addWallet(newWallet);
        chain.addWallet(newWallet);
    }

}
