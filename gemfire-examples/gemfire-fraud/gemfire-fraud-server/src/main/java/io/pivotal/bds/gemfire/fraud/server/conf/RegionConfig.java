package io.pivotal.bds.gemfire.fraud.server.conf;

import java.util.Collection;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.util.Assert;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import org.apache.geode.cache.Cache;
import org.apache.geode.cache.DiskStore;
import org.apache.geode.cache.ExpirationAction;
import org.apache.geode.cache.ExpirationAttributes;
import org.apache.geode.cache.PartitionAttributesFactory;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionFactory;
import org.apache.geode.cache.RegionShortcut;
import org.apache.geode.cache.asyncqueue.AsyncEventQueue;

import io.pivotal.bds.gemfire.fraud.common.Constants;
import io.pivotal.bds.gemfire.fraud.common.data.Account;
import io.pivotal.bds.gemfire.fraud.common.data.AccountAggregate;
import io.pivotal.bds.gemfire.fraud.common.data.AccountBalance;
import io.pivotal.bds.gemfire.fraud.common.data.Alert;
import io.pivotal.bds.gemfire.fraud.common.data.Card;
import io.pivotal.bds.gemfire.fraud.common.data.CardAggregate;
import io.pivotal.bds.gemfire.fraud.common.data.CardBalance;
import io.pivotal.bds.gemfire.fraud.common.data.CardClassifierData;
import io.pivotal.bds.gemfire.fraud.common.data.AccountClassifierData;
import io.pivotal.bds.gemfire.fraud.common.data.ProcessTransactionRequest;
import io.pivotal.bds.gemfire.fraud.common.data.Transaction;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionAggregate;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionHistory;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionStatus;
import io.pivotal.bds.gemfire.fraud.common.data.Vendor;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.common.key.AlertKey;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionHistoryKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;
import io.pivotal.bds.gemfire.fraud.common.key.VendorKey;
import io.pivotal.bds.gemfire.fraud.server.loader.AccountTransactionXrefCacheLoader;
import io.pivotal.bds.gemfire.fraud.server.loader.BaseKeyCassandraCacheLoader;
import io.pivotal.bds.gemfire.fraud.server.loader.CardLockCacheLoader;
import io.pivotal.bds.gemfire.fraud.server.loader.CardNumberAccountKeyXrefCacheLoader;
import io.pivotal.bds.gemfire.fraud.server.loader.CardNumberCardKeyXrefCacheLoader;
import io.pivotal.bds.gemfire.fraud.server.loader.CardTransactionXrefCacheLoader;
import io.pivotal.bds.gemfire.fraud.server.loader.TransactionHistoryXrefCacheLoader;
import io.pivotal.bds.gemfire.keyfw.resolver.ColocationIDPartitionResolver;
import io.pivotal.bds.gemfire.util.DelegatingCacheListener;
import io.pivotal.bds.gemfire.util.DelegatingCacheLoader;
import smile.classification.Classifier;
import smile.regression.Regression;

@Configuration("RegionConfig")
@DependsOn("PropertyConfig")
public class RegionConfig implements Constants {

    @Resource
    private Region<AccountKey, Account> accountRegion;

    @Resource
    private Region<TransactionKey, Transaction> transactionRegion;

    private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

    @Bean
    public DelegatingCacheLoader<AccountKey, AccountAggregate> accountAggregateDelegatingCacheLoader() {
        return new DelegatingCacheLoader<>();
    }

    @Bean
    public DelegatingCacheLoader<TransactionKey, TransactionAggregate> transactionAggregateDelegatingCacheLoader() {
        return new DelegatingCacheLoader<>();
    }

    @Bean
    public DelegatingCacheListener<CardKey, Card> cardNumberAccountKeyXrefDelegatingCacheListener() {
        return new DelegatingCacheListener<>();
    }

    @Bean
    public DelegatingCacheListener<CardKey, Card> cardNumberCardKeyXrefDelegatingCacheListener() {
        return new DelegatingCacheListener<>();
    }

    @Bean
    public DelegatingCacheLoader<CardKey, CardAggregate> cardAggregateDelegatingCacheLoader() {
        return new DelegatingCacheLoader<>();
    }

    @Bean(name = TRANSACTION_ROUTING_REGION_BEAN_NAME)
    public Region<ProcessTransactionRequest, String> transactionRoutingRegion(Cache cache) {
        LOG.info("transactionRoutingRegion");
        RegionFactory<ProcessTransactionRequest, String> rf = cache.createRegionFactory(RegionShortcut.PARTITION);
        PartitionAttributesFactory<ProcessTransactionRequest, String> paf = new PartitionAttributesFactory<>();
        paf.setRedundantCopies(0);
        paf.setTotalNumBuckets(113);
        rf.setPartitionAttributes(paf.create());
        return rf.create(TRANSACTION_ROUTING_REGION_NAME);
    }

    @Bean(name = ACCOUNT_REGION_BEAN_NAME)
    public Region<AccountKey, Account> accountRegion(Cache cache, DiskStore accountDiskStore, Mapper<Account> accountMapper,
            AsyncEventQueue accountCassandraAsyncEventQueue, PropertyConfig properties) {

        LOG.info("accountRegion");
        BaseKeyCassandraCacheLoader<AccountKey, Account> accountCacheLoader = new BaseKeyCassandraCacheLoader<>(accountMapper);
        RegionFactory<AccountKey, Account> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);

        rf.setDiskStoreName(accountDiskStore.getName());
        rf.setCacheLoader(accountCacheLoader);
        rf.addAsyncEventQueueId(accountCassandraAsyncEventQueue.getId());

        PartitionAttributesFactory<AccountKey, Account> paf = new PartitionAttributesFactory<>();

        paf.setRedundantCopies(properties.redundantCopies);
        paf.setTotalNumBuckets(properties.numberOfBuckets);

        rf.setPartitionAttributes(paf.create());

        return rf.create(ACCOUNT_REGION_NAME);
    }

    @Bean(name = ACCOUNT_BALANCE_REGION_BEAN_NAME)
    public Region<AccountKey, AccountBalance> accountBalanceRegion(Cache cache, DiskStore accountBalanceDiskStore,
            Mapper<AccountBalance> accountBalanceMapper, AsyncEventQueue accountBalanceCassandraAsyncEventQueue,
            PropertyConfig properties) {

        LOG.info("accountBalanceRegion");
        Assert.notNull(accountRegion, "accountRegion is null");
        BaseKeyCassandraCacheLoader<AccountKey, AccountBalance> accountBalanceCacheLoader = new BaseKeyCassandraCacheLoader<>(
                accountBalanceMapper);
        RegionFactory<AccountKey, AccountBalance> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);

        rf.setDiskStoreName(accountBalanceDiskStore.getName());
        rf.setCacheLoader(accountBalanceCacheLoader);
        rf.addAsyncEventQueueId(accountBalanceCassandraAsyncEventQueue.getId());

        PartitionAttributesFactory<AccountKey, AccountBalance> paf = new PartitionAttributesFactory<>();

        paf.setRedundantCopies(properties.redundantCopies);
        paf.setTotalNumBuckets(properties.numberOfBuckets);
        paf.setColocatedWith(accountRegion.getFullPath());

        rf.setPartitionAttributes(paf.create());

        return rf.create(ACCOUNT_BALANCE_REGION_NAME);
    }

    @Bean(name = ACCOUNT_AGGREGATE_REGION_BEAN_NAME)
    public Region<AccountKey, AccountAggregate> accountAggregateRegion(Cache cache,
            DelegatingCacheLoader<AccountKey, AccountAggregate> accountAggregateDelegatingCacheLoader) {

        LOG.info("accountAggregateRegion");
        RegionFactory<AccountKey, AccountAggregate> rf = cache.createRegionFactory(RegionShortcut.LOCAL_HEAP_LRU);
        rf.setCacheLoader(accountAggregateDelegatingCacheLoader);

        return rf.create(ACCOUNT_AGGREGATE_REGION_NAME);
    }

    @Bean(name = CARD_AGGREGATE_REGION_BEAN_NAME)
    public Region<CardKey, CardAggregate> cardAggregateRegion(Cache cache,
            DelegatingCacheLoader<CardKey, CardAggregate> cardAggregateDelegatingCacheLoader) {

        LOG.info("cardAggregateRegion");
        RegionFactory<CardKey, CardAggregate> rf = cache.createRegionFactory(RegionShortcut.LOCAL_HEAP_LRU);
        rf.setCacheLoader(cardAggregateDelegatingCacheLoader);

        return rf.create(CARD_AGGREGATE_REGION_NAME);
    }

    @Bean(name = ACCOUNT_CLASSIFIER_REGION_BEAN_NAME)
    public Region<AccountKey, Classifier<double[]>> accountClassifierRegion(Cache cache) {
        LOG.info("accountClassifierRegion");
        RegionFactory<AccountKey, Classifier<double[]>> rf = cache.createRegionFactory(RegionShortcut.LOCAL);
        return rf.create(ACCOUNT_CLASSIFIER_REGION_NAME);
    }

    @Bean(name = CARD_CLASSIFIER_REGION_BEAN_NAME)
    public Region<CardKey, Classifier<double[]>> cardClassifierRegion(Cache cache) {
        LOG.info("cardClassifierRegion");
        RegionFactory<CardKey, Classifier<double[]>> rf = cache.createRegionFactory(RegionShortcut.LOCAL);
        return rf.create(CARD_CLASSIFIER_REGION_NAME);
    }

    @Bean(name = CARD_LOCK_REGION_BEAN_NAME)
    public Region<CardKey, ReentrantReadWriteLock> cardLockRegion(Cache cache) {
        LOG.info("cardLockRegion");
        RegionFactory<CardKey, ReentrantReadWriteLock> rf = cache.createRegionFactory(RegionShortcut.LOCAL);
        rf.setCacheLoader(new CardLockCacheLoader());
        ExpirationAttributes ea = new ExpirationAttributes(60, ExpirationAction.DESTROY); // 60 seconds
        rf.setEntryIdleTimeout(ea);
        return rf.create(CARD_LOCK_REGION_NAME);
    }

    @Bean(name = ACCOUNT_REGRESSION_REGION_BEAN_NAME)
    public Region<AccountKey, Regression<double[]>> accountRegressionRegion(Cache cache) {
        LOG.info("accountRegressionRegion");
        RegionFactory<AccountKey, Regression<double[]>> rf = cache.createRegionFactory(RegionShortcut.LOCAL);
        return rf.create(ACCOUNT_REGRESSION_REGION_NAME);
    }

    @Bean(name = ACCOUNT_TRANSACTION_XREF_REGION_BEAN_NAME)
    public Region<AccountKey, Collection<TransactionKey>> accountTransactionXrefRegion(Cache cache, Mapper<Transaction> mapper) {
        LOG.info("accountTransactionXrefRegion");
        AccountTransactionXrefCacheLoader cl = new AccountTransactionXrefCacheLoader(mapper);
        RegionFactory<AccountKey, Collection<TransactionKey>> rf = cache.createRegionFactory(RegionShortcut.LOCAL_HEAP_LRU);
        rf.setCacheLoader(cl);
        return rf.create(ACCOUNT_TRANSACTION_XREF_REGION_NAME);
    }

    @Bean(name = CARD_TRANSACTION_XREF_REGION_BEAN_NAME)
    public Region<CardKey, Collection<TransactionKey>> cardTransactionXrefRegion(Cache cache, Mapper<Transaction> mapper) {
        LOG.info("cardTransactionXrefRegion");
        CardTransactionXrefCacheLoader cl = new CardTransactionXrefCacheLoader(mapper);
        RegionFactory<CardKey, Collection<TransactionKey>> rf = cache.createRegionFactory(RegionShortcut.LOCAL_HEAP_LRU);
        rf.setCacheLoader(cl);
        return rf.create(CARD_TRANSACTION_XREF_REGION_NAME);
    }

    @Bean(name = TRANSACTION_HISTORY_XREF_REGION_BEAN_NAME)
    public Region<TransactionKey, Collection<TransactionHistoryKey>> transactionHistoryXrefRegion(Cache cache,
            Mapper<TransactionHistory> mapper) {
        LOG.info("transactionHistoryXrefRegion");
        TransactionHistoryXrefCacheLoader cl = new TransactionHistoryXrefCacheLoader(mapper);
        RegionFactory<TransactionKey, Collection<TransactionHistoryKey>> rf = cache
                .createRegionFactory(RegionShortcut.LOCAL_HEAP_LRU);
        rf.setCacheLoader(cl);
        return rf.create(TRANSACTION_HISTORY_XREF_REGION_NAME);
    }

    @Bean(name = TRANSACTION_REGION_BEAN_NAME)
    public Region<TransactionKey, Transaction> transactionRegion(Cache cache, DiskStore transactionDiskStore,
            Mapper<Transaction> transactionMapper, AsyncEventQueue accountTransactionXrefAsyncEventQueue,
            AsyncEventQueue cardTransactionXrefAsyncEventQueue, AsyncEventQueue transactionCassandraAsyncEventQueue,
            PropertyConfig properties) {

        LOG.info("transactionRegion");
        Assert.notNull(accountRegion, "accountRegion is null");

        RegionFactory<TransactionKey, Transaction> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);

        BaseKeyCassandraCacheLoader<TransactionKey, Transaction> cl = new BaseKeyCassandraCacheLoader<>(transactionMapper);

        rf.setCacheLoader(cl);
        rf.setDiskStoreName(transactionDiskStore.getName());
        rf.addAsyncEventQueueId(transactionCassandraAsyncEventQueue.getId());
        rf.addAsyncEventQueueId(accountTransactionXrefAsyncEventQueue.getId());
        rf.addAsyncEventQueueId(cardTransactionXrefAsyncEventQueue.getId());

        PartitionAttributesFactory<TransactionKey, Transaction> paf = new PartitionAttributesFactory<>();

        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setRedundantCopies(properties.redundantCopies);
        paf.setTotalNumBuckets(properties.numberOfBuckets);
        paf.setPartitionResolver(new ColocationIDPartitionResolver<TransactionKey, Transaction>());

        return rf.create(TRANSACTION_REGION_NAME);
    }

    @Bean(name = CARD_REGION_BEAN_NAME)
    public Region<CardKey, Card> cardRegion(Cache cache, DiskStore cardDiskStore, Mapper<Card> cardMapper,
            DelegatingCacheListener<CardKey, Card> cardNumberAccountKeyXrefDelegatingCacheListener,
            DelegatingCacheListener<CardKey, Card> cardNumberCardKeyXrefDelegatingCacheListener,
            AsyncEventQueue cardCassandraAsyncEventQueue, PropertyConfig properties) {

        LOG.info("cardRegion");
        Assert.notNull(accountRegion, "accountRegion is null");

        RegionFactory<CardKey, Card> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);

        BaseKeyCassandraCacheLoader<CardKey, Card> cl = new BaseKeyCassandraCacheLoader<>(cardMapper);

        rf.setCacheLoader(cl);
        rf.setDiskStoreName(cardDiskStore.getName());
        rf.addCacheListener(cardNumberAccountKeyXrefDelegatingCacheListener);
        rf.addCacheListener(cardNumberCardKeyXrefDelegatingCacheListener);
        rf.addAsyncEventQueueId(cardCassandraAsyncEventQueue.getId());

        PartitionAttributesFactory<CardKey, Card> paf = new PartitionAttributesFactory<>();

        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setRedundantCopies(properties.redundantCopies);
        paf.setTotalNumBuckets(properties.numberOfBuckets);
        paf.setPartitionResolver(new ColocationIDPartitionResolver<CardKey, Card>());

        rf.setPartitionAttributes(paf.create());

        return rf.create(CARD_REGION_NAME);
    }

    @Bean(name = CARD_BALANCE_REGION_BEAN_NAME)
    public Region<CardKey, CardBalance> cardBalanceRegion(Cache cache, DiskStore cardBalanceDiskStore,
            Mapper<CardBalance> cardBalanceMapper, AsyncEventQueue cardBalanceCassandraAsyncEventQueue, PropertyConfig properties) {

        LOG.info("cardBalanceRegion");
        Assert.notNull(accountRegion, "accountRegion is null");

        RegionFactory<CardKey, CardBalance> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);

        BaseKeyCassandraCacheLoader<CardKey, CardBalance> cl = new BaseKeyCassandraCacheLoader<>(cardBalanceMapper);

        rf.setCacheLoader(cl);
        rf.setDiskStoreName(cardBalanceDiskStore.getName());
        rf.addAsyncEventQueueId(cardBalanceCassandraAsyncEventQueue.getId());

        PartitionAttributesFactory<CardKey, CardBalance> paf = new PartitionAttributesFactory<>();

        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setRedundantCopies(properties.redundantCopies);
        paf.setTotalNumBuckets(properties.numberOfBuckets);
        paf.setPartitionResolver(new ColocationIDPartitionResolver<CardKey, CardBalance>());

        rf.setPartitionAttributes(paf.create());

        return rf.create(CARD_BALANCE_REGION_NAME);
    }

    @Bean(name = CARD_CLASSIFIER_DATA_REGION_BEAN_NAME)
    public Region<CardKey, CardClassifierData> cardClassifierDataRegion(Cache cache, DiskStore cardClassifierDataDiskStore,
            Mapper<CardClassifierData> cardClassifierDataMapper, AsyncEventQueue cardClassifierDataCassandraAsyncEventQueue,
            AsyncEventQueue cardClassifierDataAsyncEventQueue, PropertyConfig properties) {

        LOG.info("cardClassifierDataRegion");
        Assert.notNull(accountRegion, "accountRegion is null");

        RegionFactory<CardKey, CardClassifierData> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);

        BaseKeyCassandraCacheLoader<CardKey, CardClassifierData> cl = new BaseKeyCassandraCacheLoader<>(cardClassifierDataMapper);

        rf.setCacheLoader(cl);
        rf.setDiskStoreName(cardClassifierDataDiskStore.getName());
        rf.addAsyncEventQueueId(cardClassifierDataCassandraAsyncEventQueue.getId());
        rf.addAsyncEventQueueId(cardClassifierDataAsyncEventQueue.getId());

        PartitionAttributesFactory<CardKey, CardClassifierData> paf = new PartitionAttributesFactory<>();

        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setRedundantCopies(properties.redundantCopies);
        paf.setTotalNumBuckets(properties.numberOfBuckets);
        paf.setPartitionResolver(new ColocationIDPartitionResolver<CardKey, CardClassifierData>());

        rf.setPartitionAttributes(paf.create());

        return rf.create(CARD_CLASSIFIER_DATA_REGION_NAME);
    }

    @Bean(name = ACCOUNT_CLASSIFIER_DATA_REGION_BEAN_NAME)
    public Region<AccountKey, AccountClassifierData> accountClassifierDataRegion(Cache cache,
            DiskStore accountClassifierDataDiskStore, Mapper<AccountClassifierData> accountClassifierDataMapper,
            AsyncEventQueue accountClassifierDataCassandraAsyncEventQueue, AsyncEventQueue accountClassifierDataAsyncEventQueue,
            PropertyConfig properties) {

        LOG.info("accountClassifierDataRegion");
        Assert.notNull(accountRegion, "accountRegion is null");

        RegionFactory<AccountKey, AccountClassifierData> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);

        BaseKeyCassandraCacheLoader<AccountKey, AccountClassifierData> cl = new BaseKeyCassandraCacheLoader<>(accountClassifierDataMapper);

        rf.setCacheLoader(cl);
        rf.setDiskStoreName(accountClassifierDataDiskStore.getName());
        rf.addAsyncEventQueueId(accountClassifierDataCassandraAsyncEventQueue.getId());
        rf.addAsyncEventQueueId(accountClassifierDataAsyncEventQueue.getId());

        PartitionAttributesFactory<AccountKey, AccountClassifierData> paf = new PartitionAttributesFactory<>();

        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setRedundantCopies(properties.redundantCopies);
        paf.setTotalNumBuckets(properties.numberOfBuckets);

        rf.setPartitionAttributes(paf.create());

        return rf.create(ACCOUNT_CLASSIFIER_DATA_REGION_NAME);
    }

    @Bean(name = TRANSACTION_HISTORY_REGION_BEAN_NAME)
    public Region<TransactionHistoryKey, TransactionHistory> transactionHistoryRegion(Cache cache,
            DiskStore transactionHistoryDiskStore, Mapper<TransactionHistory> transactionHistoryMapper,
            AsyncEventQueue transactionHistoryCassandraAsyncEventQueue, AsyncEventQueue transactionHistoryXrefAsyncEventQueue,
            PropertyConfig properties) {

        LOG.info("transactionHistoryRegion");
        Assert.notNull(transactionRegion, "transactionRegion is null");

        RegionFactory<TransactionHistoryKey, TransactionHistory> rf = cache
                .createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);

        BaseKeyCassandraCacheLoader<TransactionHistoryKey, TransactionHistory> cl = new BaseKeyCassandraCacheLoader<>(
                transactionHistoryMapper);

        rf.setCacheLoader(cl);
        rf.setDiskStoreName(transactionHistoryDiskStore.getName());
        rf.addAsyncEventQueueId(transactionHistoryCassandraAsyncEventQueue.getId());
        rf.addAsyncEventQueueId(transactionHistoryXrefAsyncEventQueue.getId());

        PartitionAttributesFactory<TransactionKey, Transaction> paf = new PartitionAttributesFactory<>();

        paf.setColocatedWith(transactionRegion.getFullPath());
        paf.setRedundantCopies(properties.redundantCopies);
        paf.setTotalNumBuckets(properties.numberOfBuckets);
        paf.setPartitionResolver(new ColocationIDPartitionResolver<TransactionKey, Transaction>());

        return rf.create(TRANSACTION_HISTORY_REGION_NAME);
    }

    @Bean(name = TRANSACTION_STATUS_REGION_BEAN_NAME)
    public Region<TransactionKey, TransactionStatus> transactionStatusRegion(Cache cache, DiskStore transactionStatusDiskStore,
            Mapper<TransactionStatus> transactionStatusMapper, AsyncEventQueue transactionStatusCassandraAsyncEventQueue,
            AsyncEventQueue transactionStatusAlertAsyncEventQueue, AsyncEventQueue transactionStatusClassifierAsyncEventQueue,
            PropertyConfig properties) {

        LOG.info("transactionHistoryRegion");
        Assert.notNull(transactionRegion, "transactionRegion is null");

        RegionFactory<TransactionKey, TransactionStatus> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);

        BaseKeyCassandraCacheLoader<TransactionKey, TransactionStatus> cl = new BaseKeyCassandraCacheLoader<>(
                transactionStatusMapper);

        rf.setCacheLoader(cl);
        rf.setDiskStoreName(transactionStatusDiskStore.getName());
        rf.addAsyncEventQueueId(transactionStatusCassandraAsyncEventQueue.getId());
        rf.addAsyncEventQueueId(transactionStatusClassifierAsyncEventQueue.getId());
        rf.addAsyncEventQueueId(transactionStatusAlertAsyncEventQueue.getId());

        PartitionAttributesFactory<TransactionKey, TransactionStatus> paf = new PartitionAttributesFactory<>();

        paf.setColocatedWith(transactionRegion.getFullPath());
        paf.setRedundantCopies(properties.redundantCopies);
        paf.setTotalNumBuckets(properties.numberOfBuckets);
        paf.setPartitionResolver(new ColocationIDPartitionResolver<TransactionKey, TransactionStatus>());

        return rf.create(TRANSACTION_STATUS_REGION_NAME);
    }

    @Bean(name = TRANSACTION_AGGREGATE_REGION_BEAN_NAME)
    public Region<TransactionKey, TransactionAggregate> transactionAggregateRegion(Cache cache,
            DelegatingCacheLoader<TransactionKey, TransactionAggregate> transactionAggregateDelegatingCacheLoader) {
        LOG.info("transactionAggregateRegion");
        RegionFactory<TransactionKey, TransactionAggregate> rf = cache.createRegionFactory(RegionShortcut.LOCAL_HEAP_LRU);
        rf.setCacheLoader(transactionAggregateDelegatingCacheLoader);
        return rf.create(TRANSACTION_AGGREGATE_REGION_NAME);
    }

    @Bean(name = VENDOR_REGION_BEAN_NAME)
    public Region<VendorKey, Vendor> vendorRegion(Cache cache, Mapper<Vendor> vendorMapper, DiskStore vendorDiskStore,
            AsyncEventQueue vendorAsyncEventQueue, PropertyConfig properties) {

        LOG.info("vendorRegion");
        RegionFactory<VendorKey, Vendor> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);

        BaseKeyCassandraCacheLoader<VendorKey, Vendor> cl = new BaseKeyCassandraCacheLoader<>(vendorMapper);

        rf.setCacheLoader(cl);
        rf.setDiskStoreName(vendorDiskStore.getName());
        rf.addAsyncEventQueueId(vendorAsyncEventQueue.getId());

        PartitionAttributesFactory<AccountKey, AccountBalance> paf = new PartitionAttributesFactory<>();

        paf.setRedundantCopies(properties.redundantCopies);
        paf.setTotalNumBuckets(properties.numberOfBuckets);

        rf.setPartitionAttributes(paf.create());

        return rf.create(VENDOR_REGION_NAME);
    }

    @Bean(name = CARD_NUMBER_ACCOUNTKEY_XREF_REGION_BEAN_NAME)
    public Region<String, AccountKey> cardNumberAccountKeyXrefRegion(Cache cache, Session session) {
        LOG.info("cardNumberAccountKeyXrefRegion");
        RegionFactory<String, AccountKey> rf = cache.createRegionFactory(RegionShortcut.LOCAL_HEAP_LRU);
        CardNumberAccountKeyXrefCacheLoader cl = new CardNumberAccountKeyXrefCacheLoader(session);
        rf.setCacheLoader(cl);
        return rf.create(CARD_NUMBER_ACCOUNTKEY_XREF_REGION_NAME);
    }

    @Bean(name = CARD_NUMBER_CARDKEY_XREF_REGION_BEAN_NAME)
    public Region<String, CardKey> cardNumberCardKeyXrefRegion(Cache cache, Session session) {
        LOG.info("cardNumberCardKeyXrefRegion");
        RegionFactory<String, CardKey> rf = cache.createRegionFactory(RegionShortcut.LOCAL_HEAP_LRU);
        CardNumberCardKeyXrefCacheLoader cl = new CardNumberCardKeyXrefCacheLoader(session);
        rf.setCacheLoader(cl);
        return rf.create(CARD_NUMBER_CARDKEY_XREF_REGION_NAME);
    }

    @Bean(name = ALERT_REGION_BEAN_NAME)
    public Region<AlertKey, Alert> alertRegion(Cache cache, DiskStore alertDiskStore, Mapper<Alert> alertMapper,
            AsyncEventQueue alertCassandraAsyncEventQueue, PropertyConfig properties) {

        LOG.info("alertRegion");
        Assert.notNull(transactionRegion, "transactionRegion is null");

        RegionFactory<AlertKey, Alert> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);

        BaseKeyCassandraCacheLoader<AlertKey, Alert> cl = new BaseKeyCassandraCacheLoader<>(alertMapper);

        rf.setCacheLoader(cl);
        rf.setDiskStoreName(alertDiskStore.getName());
        rf.addAsyncEventQueueId(alertCassandraAsyncEventQueue.getId());

        PartitionAttributesFactory<AlertKey, Alert> paf = new PartitionAttributesFactory<>();

        paf.setColocatedWith(transactionRegion.getFullPath());
        paf.setRedundantCopies(properties.redundantCopies);
        paf.setTotalNumBuckets(properties.numberOfBuckets);
        paf.setPartitionResolver(new ColocationIDPartitionResolver<AlertKey, Alert>());

        return rf.create(ALERT_REGION_NAME);
    }

}
