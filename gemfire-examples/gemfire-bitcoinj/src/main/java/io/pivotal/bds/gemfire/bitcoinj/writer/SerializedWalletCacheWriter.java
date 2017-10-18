package io.pivotal.bds.gemfire.bitcoinj.writer;

import java.io.ByteArrayInputStream;

import org.bitcoinj.wallet.Wallet;
import org.bitcoinj.wallet.WalletExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.CacheWriterException;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.util.CacheWriterAdapter;

public class SerializedWalletCacheWriter extends CacheWriterAdapter<String, byte[]> {

    private Region<String, Wallet> walletRegion;
    private WalletExtension[] extensions;

    private static final Logger LOG = LoggerFactory.getLogger(SerializedWalletCacheWriter.class);

    public SerializedWalletCacheWriter(Region<String, Wallet> walletRegion, WalletExtension extensions) {
        this.walletRegion = walletRegion;
        this.extensions = extensions == null ? new WalletExtension[0] : new WalletExtension[] { extensions };
    }

    @Override
    public void beforeCreate(EntryEvent<String, byte[]> event) throws CacheWriterException {
        LOG.info("beforeCreate: event={}", event);
        put(event);
    }

    @Override
    public void beforeDestroy(EntryEvent<String, byte[]> event) throws CacheWriterException {
        LOG.info("beforeDestroy: event={}", event);
        String key = event.getKey();
        walletRegion.remove(key);
    }

    @Override
    public void beforeUpdate(EntryEvent<String, byte[]> event) throws CacheWriterException {
        LOG.info("beforeUpdate: event={}", event);
        put(event);
    }

    private void put(EntryEvent<String, byte[]> event) throws CacheWriterException {
        String key = event.getKey();
        LOG.info("put: key={}", key);

        try {
            byte[] buf = event.getNewValue();
            ByteArrayInputStream bis = new ByteArrayInputStream(buf);

            Wallet wallet = Wallet.loadFromFileStream(bis, extensions);
            LOG.info("put: key={}, wallet={}", key, wallet);

            walletRegion.put(key, wallet);
        } catch (Exception x) {
            LOG.error("put: key={}, x={}", key, x.toString(), x);
        }
    }

}
