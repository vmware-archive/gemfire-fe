package io.pivotal.bds.gemfire.fraud.server.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.DiskStore;
import org.apache.geode.cache.asyncqueue.AsyncEventQueue;
import org.apache.geode.cache.asyncqueue.AsyncEventQueueFactory;

import io.pivotal.bds.gemfire.fraud.common.Constants;
import io.pivotal.bds.gemfire.util.DelegatingAsyncEventListener;

@Configuration("AsyncEventQueueConfig")
public class AsyncEventQueueConfig implements Constants {

    private static final Logger LOG = LoggerFactory.getLogger(AsyncEventQueueConfig.class);

    @Bean
    public DelegatingAsyncEventListener accountTransactionXrefDelegatingAsyncEventListener() {
        LOG.info("accountTransactionXrefDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener accountCassandraDelegatingAsyncEventListener() {
        LOG.info("accountCassandraDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener accountBalanceCassandraDelegatingAsyncEventListener() {
        LOG.info("accountBalanceCassandraDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener transactionCassandraDelegatingAsyncEventListener() {
        LOG.info("transactionCassandraDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener transactionStatusCassandraDelegatingAsyncEventListener() {
        LOG.info("transactionStatusCassandraDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener transactionStatusAlertDelegatingAsyncEventListener() {
        LOG.info("transactionStatusAlertDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener transactionHistoryCassandraDelegatingAsyncEventListener() {
        LOG.info("transactionHistoryCassandraDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener transactionHistoryXrefDelegatingAsyncEventListener() {
        LOG.info("transactionHistoryXrefDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener transactionStatusClassifierDelegatingAsyncEventListener() {
        LOG.info("transactionStatusClassifierDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener vendorCassandraDelegatingAsyncEventListener() {
        LOG.info("vendorCassandraDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener cardCassandraDelegatingAsyncEventListener() {
        LOG.info("cardCassandraDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener cardClassifierDataCassandraDelegatingAsyncEventListener() {
        LOG.info("cardClassifierDataCassandraDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener cardClassifierDataDelegatingAsyncEventListener() {
        LOG.info("cardClassifierDataDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener accountClassifierDataCassandraDelegatingAsyncEventListener() {
        LOG.info("accountClassifierDataCassandraDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener accountClassifierDataDelegatingAsyncEventListener() {
        LOG.info("accountClassifierDataDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener cardBalanceCassandraDelegatingAsyncEventListener() {
        LOG.info("cardBalanceCassandraDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener cardTransactionXrefDelegatingAsyncEventListener() {
        LOG.info("cardTransactionXrefDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public DelegatingAsyncEventListener alertCassandraDelegatingAsyncEventListener() {
        LOG.info("alertCassandraDelegatingAsyncEventListener");
        return new DelegatingAsyncEventListener();
    }

    @Bean
    public AsyncEventQueue accountTransactionXrefAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener accountTransactionXrefDelegatingAsyncEventListener) {
        LOG.info("accountTransactionXrefAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(ACCOUNT_TRANSACTION_XREF_ASYNC_EVENT_QUEUE_NAME, accountTransactionXrefDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue accountCassandraAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener accountCassandraDelegatingAsyncEventListener) {
        LOG.info("accountCassandraAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(ACCOUNT_ASYNC_EVENT_QUEUE_NAME, accountCassandraDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue accountBalanceCassandraAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener accountBalanceCassandraDelegatingAsyncEventListener) {
        LOG.info("accountBalanceCassandraAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(ACCOUNT_BALANCE_ASYNC_EVENT_QUEUE_NAME, accountBalanceCassandraDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue transactionCassandraAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener transactionCassandraDelegatingAsyncEventListener) {
        LOG.info("transactionCassandraAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(TRANSACTION_ASYNC_EVENT_QUEUE_NAME, transactionCassandraDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue transactionHistoryCassandraAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener transactionHistoryCassandraDelegatingAsyncEventListener) {
        LOG.info("transactionHistoryCassandraAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(TRANSACTION_HISTORY_ASYNC_EVENT_QUEUE_NAME, transactionHistoryCassandraDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue transactionStatusCassandraAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener transactionStatusCassandraDelegatingAsyncEventListener) {
        LOG.info("transactionStatusCassandraAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(TRANSACTION_STATUS_CASSANDRA_ASYNC_EVENT_QUEUE_NAME,
                transactionStatusCassandraDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue transactionStatusAlertAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener transactionStatusAlertDelegatingAsyncEventListener) {
        LOG.info("transactionStatusAlertAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(TRANSACTION_STATUS_ALERT_ASYNC_EVENT_QUEUE_NAME, transactionStatusAlertDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue transactionStatusClassifierAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener transactionStatusClassifierDelegatingAsyncEventListener) {
        LOG.info("transactionStatusClassifierAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(TRANSACTION_STATUS_CLASSIFIER_ASYNC_EVENT_QUEUE_NAME,
                transactionStatusClassifierDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue transactionHistoryXrefAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener transactionHistoryXrefDelegatingAsyncEventListener) {
        LOG.info("transactionHistoryCassandraAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(TRANSACTION_HISTORY_XREF_ASYNC_EVENT_QUEUE_NAME, transactionHistoryXrefDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue cardCassandraAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener cardCassandraDelegatingAsyncEventListener) {
        LOG.info("cardCassandraAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(CARD_CASSANDRA_ASYNC_EVENT_QUEUE_NAME, cardCassandraDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue cardClassifierDataCassandraAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener cardClassifierDataCassandraDelegatingAsyncEventListener) {
        LOG.info("cardClassifierDataCassandraAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(CARD_CLASSIFIER_DATA_CASSANDRA_ASYNC_EVENT_QUEUE_NAME,
                cardClassifierDataCassandraDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue cardClassifierDataAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener cardClassifierDataDelegatingAsyncEventListener) {
        LOG.info("cardClassifierDataAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(CARD_CLASSIFIER_DATA_ASYNC_EVENT_QUEUE_NAME, cardClassifierDataDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue accountClassifierDataCassandraAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener accountClassifierDataCassandraDelegatingAsyncEventListener) {
        LOG.info("accountClassifierDataCassandraAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(ACCOUNT_CLASSIFIER_DATA_CASSANDRA_ASYNC_EVENT_QUEUE_NAME,
                accountClassifierDataCassandraDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue accountClassifierDataAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener accountClassifierDataDelegatingAsyncEventListener) {
        LOG.info("accountClassifierDataAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(ACCOUNT_CLASSIFIER_DATA_ASYNC_EVENT_QUEUE_NAME, accountClassifierDataDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue cardBalanceCassandraAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener cardBalanceCassandraDelegatingAsyncEventListener) {
        LOG.info("cardBalanceCassandraAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(CARD_BALANCE_CASSANDRA_ASYNC_EVENT_QUEUE_NAME, cardBalanceCassandraDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue cardTransactionXrefAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener cardTransactionXrefDelegatingAsyncEventListener) {
        LOG.info("cardTransactionXrefAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(CARD_TRANSACTION_XREF_ASYNC_EVENT_QUEUE_NAME, cardTransactionXrefDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue vendorAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener vendorCassandraDelegatingAsyncEventListener) {
        LOG.info("vendorAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(VENDOR_CASSANDRA_ASYNC_EVENT_QUEUE_NAME, vendorCassandraDelegatingAsyncEventListener);
    }

    @Bean
    public AsyncEventQueue alertCassandraAsyncEventQueue(Cache cache, DiskStore queueDiskStore,
            DelegatingAsyncEventListener alertCassandraDelegatingAsyncEventListener) {
        LOG.info("alertAsyncEventQueue");
        AsyncEventQueueFactory f = cache.createAsyncEventQueueFactory();
        f.setParallel(true);
        f.setPersistent(true);
        f.setDiskStoreName(queueDiskStore.getName());
        return f.create(ALERT_CASSANDRA_ASYNC_EVENT_QUEUE_NAME, alertCassandraDelegatingAsyncEventListener);
    }
}
