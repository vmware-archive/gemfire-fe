package io.pivotal.bds.gemfire.bitcoinj.store;

import org.bitcoinj.core.Block;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.core.StoredBlock;
import org.bitcoinj.store.BlockStore;
import org.bitcoinj.store.BlockStoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Region;

public class GemfireBlockStore implements BlockStore {

    private NetworkParameters params;
    private Region<Sha256Hash, StoredBlock> region;
    private static final Sha256Hash head = Sha256Hash.ZERO_HASH;

    private static final Logger LOG = LoggerFactory.getLogger(GemfireBlockStore.class);

    public GemfireBlockStore(NetworkParameters params, Region<Sha256Hash, StoredBlock> region) throws Exception {
        this.params = params;
        this.region = region;

        StoredBlock storedGenesis = get(head);

        if (storedGenesis == null) {
            LOG.info("storedGenesis is null, creating new genesis block");
            Block genesisHeader = params.getGenesisBlock().cloneAsHeader();
            storedGenesis = new StoredBlock(genesisHeader, genesisHeader.getWork(), 0);
            setChainHead(storedGenesis);
        } else {
            LOG.info("storedGenesis is NOT null");
        }
    }

    @Override
    public void put(StoredBlock block) throws BlockStoreException {
        LOG.info("put: block={}", block);
        Sha256Hash hash = block.getHeader().getHash();
        region.put(hash, block);
    }

    @Override
    public StoredBlock get(Sha256Hash hash) throws BlockStoreException {
        StoredBlock block = region.get(hash);
        LOG.info("get: hash={}, block={}", hash, block);
        return block;
    }

    @Override
    public StoredBlock getChainHead() throws BlockStoreException {
        StoredBlock block = region.get(head);
        LOG.info("getChainHead: head={}, block={}", head, block);
        return block;
    }

    @Override
    public void setChainHead(StoredBlock chainHead) throws BlockStoreException {
        LOG.info("setChainHead: head={}, chainHead={}", head, chainHead);
        region.put(head, chainHead);
    }

    @Override
    public void close() throws BlockStoreException {

    }

    @Override
    public NetworkParameters getParams() {
        return params;
    }

}
