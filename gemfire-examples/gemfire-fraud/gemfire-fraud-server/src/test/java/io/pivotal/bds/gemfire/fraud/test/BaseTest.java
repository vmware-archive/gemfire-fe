package io.pivotal.bds.gemfire.fraud.test;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;

import io.pivotal.bds.gemfire.fraud.common.data.Account;
import io.pivotal.bds.gemfire.fraud.common.data.AccountBalance;
import io.pivotal.bds.gemfire.fraud.common.data.Card;
import io.pivotal.bds.gemfire.fraud.common.data.CardBalance;
import io.pivotal.bds.gemfire.fraud.common.data.ProcessTransactionRequest;
import io.pivotal.bds.gemfire.fraud.common.data.Transaction;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionStatus;
import io.pivotal.bds.gemfire.fraud.common.data.Vendor;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;
import io.pivotal.bds.gemfire.fraud.common.key.VendorKey;

public abstract class BaseTest {

    protected ClientCache cache;
    protected Region<AccountKey, Account> accountRegion;
    protected Region<AccountKey, AccountBalance> accountBalanceRegion;
    protected Region<VendorKey, Vendor> vendorRegion;
    protected Region<CardKey, Card> cardRegion;
    protected Region<CardKey, CardBalance> cardBalanceRegion;
    protected Region<TransactionKey, Transaction> transactionRegion;
    protected Region<TransactionKey, TransactionStatus> transactionStatusRegion;
    protected Region<ProcessTransactionRequest, String> transactionRoutingRegion;

    protected final Logger LOG;

    public BaseTest() {
        LOG = LoggerFactory.getLogger(getClass());
    }

    private void init(String locatorHost) {
        LOG.info("init: locatorHost={}", locatorHost);
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator(locatorHost, 10334);
        ccf.setPdxPersistent(false);
        ccf.setPdxReadSerialized(false);
        ccf.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.fraud.common.data.*"));

        cache = ccf.create();

        accountRegion = createRegion("account");
        accountBalanceRegion = createRegion("accountBalance");
        vendorRegion = createRegion("vendor");
        cardRegion = createRegion("card");
        cardBalanceRegion = createRegion("cardBalance");
        transactionRegion = createRegion("transaction");
        transactionStatusRegion = createRegion("transactionStatus");
        transactionRoutingRegion = createRegion("transactionRouting");
    }

    private <K, V> Region<K, V> createRegion(String name) {
        LOG.info("createRegion: name={}", name);
        ClientRegionFactory<K, V> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        return crf.create(name);
    }

    protected void run(String[] args) throws Exception {
        LOG.info("run: args={}", Arrays.toString(args));
        String locatorHost = "localhost";

        if (args.length > 0) {
            locatorHost = args[0];
        }

        init(locatorHost);
        go();
    }

    protected abstract void go() throws Exception;
}
