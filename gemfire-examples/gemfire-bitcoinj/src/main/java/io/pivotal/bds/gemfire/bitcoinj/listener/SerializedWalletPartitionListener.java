package io.pivotal.bds.gemfire.bitcoinj.listener;

import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.Set;

import org.bitcoinj.wallet.Wallet;
import org.bitcoinj.wallet.WalletExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.partition.PartitionListener;
import org.apache.geode.cache.partition.PartitionRegionHelper;
import org.apache.geode.internal.cache.PartitionedRegion;

public class SerializedWalletPartitionListener implements PartitionListener {

    private Region<?, ?> region;
    private Region<String, Wallet> walletRegion;
    private WalletExtension[] extensions;

    private static final Logger LOG = LoggerFactory.getLogger(SerializedWalletPartitionListener.class);

    public SerializedWalletPartitionListener(Region<String, Wallet> walletRegion, WalletExtension extensions) {
        this.walletRegion = walletRegion;
        this.extensions = extensions == null ? new WalletExtension[0] : new WalletExtension[] { extensions };
    }

    @Override
    public void afterBucketCreated(int bucketId, Iterable<?> keys) {
        LOG.info("afterBucketCreated: bucketId={}", bucketId);
    }

    @Override
    public void afterBucketRemoved(int bucketId, Iterable<?> keys) {
        LOG.info("afterBucketRemoved: bucketId={}", bucketId);
        for (Object ok : keys) {
            LOG.info("afterBucketRemoved: bucketId={}, key={}", bucketId, ok);
            walletRegion.remove(ok);
        }
    }

    @Override
    public void afterPrimary(int bucketId) {
        LOG.info("afterPrimary: bucketId={}", bucketId);

        if (region == null) {
            LOG.warn("afterPrimary: region not fully created yet: bucketId={}", bucketId);
        } else {
            try {
                PartitionedRegion preg = (PartitionedRegion) region;
                Set<?> keys = preg.getBucketKeys(bucketId);
                for (Object ok : keys) {
                    LOG.info("afterPrimary: bucketId={}, key={}", bucketId, ok);

                    String key = (String) ok;
                    byte[] buf = (byte[]) region.get(key);

                    ByteArrayInputStream bis = new ByteArrayInputStream(buf);
                    Wallet wallet = Wallet.loadFromFileStream(bis, extensions);

                    walletRegion.put(key, wallet);
                }
            } catch (Exception x) {
                LOG.error("afterPrimary: bucketId={}, x={}", bucketId, x.toString(), x);
            }
        }
    }

    @Override
    public void afterRegionCreate(Region<?, ?> region) {
        LOG.info("afterRegionCreate: region={}", region.getName());
        this.region = region;

        try {
            Region<?, ?> pr = PartitionRegionHelper.getLocalPrimaryData(region);

            for (Map.Entry<?, ?> entry : pr.entrySet()) {
                String key = (String) entry.getKey();
                LOG.info("afterRegionCreate: region={}, key={}", region.getName(), key);

                byte[] data = (byte[]) entry.getValue();

                ByteArrayInputStream bis = new ByteArrayInputStream(data);
                Wallet wallet = Wallet.loadFromFileStream(bis, extensions);

                walletRegion.put(key, wallet);
            }
        } catch (Exception x) {
            LOG.error("afterRegionCreate: region={}, x={}", region.getName(), x.toString(), x);
        }
    }

}
