package io.pivotal.bds.gemfire.fraud.server.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datastax.driver.mapping.Mapper;

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
import io.pivotal.bds.gemfire.fraud.common.data.Transaction;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionAggregate;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionHistory;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionStatus;
import io.pivotal.bds.gemfire.fraud.common.data.Vendor;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountClassifierDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountClassifierDataDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountTransactionXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AlertDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardClassifierDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardClassifierDataDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardNumberAccountKeyXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardNumberCardKeyXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardTransactionXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionAggregateDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionHistoryDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionHistoryXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionStatusDAO;
import io.pivotal.bds.gemfire.fraud.server.listener.AccountTransactionXrefAsyncEventListener;
import io.pivotal.bds.gemfire.fraud.server.listener.CardClassifierDataAsyncEventListener;
import io.pivotal.bds.gemfire.fraud.server.listener.CardNumberAccountKeyXrefCacheListener;
import io.pivotal.bds.gemfire.fraud.server.listener.CardNumberCardKeyXrefCacheListener;
import io.pivotal.bds.gemfire.fraud.server.listener.CardTransactionXrefAsyncEventListener;
import io.pivotal.bds.gemfire.fraud.server.listener.CassandraAsyncEventListener;
import io.pivotal.bds.gemfire.fraud.server.listener.AccountClassifierDataAsyncEventListener;
import io.pivotal.bds.gemfire.fraud.server.listener.TransactionStatusAlertAsyncEventListener;
import io.pivotal.bds.gemfire.fraud.server.listener.TransactionStatusClassifierAsyncEventListener;
import io.pivotal.bds.gemfire.fraud.server.loader.AccountAggregateCacheLoader;
import io.pivotal.bds.gemfire.fraud.server.loader.CardAggregateCacheLoader;
import io.pivotal.bds.gemfire.fraud.server.loader.TransactionAggregateCacheLoader;
import io.pivotal.bds.gemfire.util.DelegatingAsyncEventListener;
import io.pivotal.bds.gemfire.util.DelegatingCacheListener;
import io.pivotal.bds.gemfire.util.DelegatingCacheLoader;

@Configuration("PostRegionConfig")
public class PostRegionConfig implements Constants {

    @Autowired
    private PropertyConfig properties;

    private static final Logger LOG = LoggerFactory.getLogger(PostRegionConfig.class);

    @Bean
    public CassandraAsyncEventListener<Alert> alertCassandraAsyncEventListener(Mapper<Alert> alertMapper,
            DelegatingAsyncEventListener alertCassandraDelegatingAsyncEventListener) {
        LOG.info("alertCassandraAsyncEventListener");
        CassandraAsyncEventListener<Alert> ael = new CassandraAsyncEventListener<>(alertMapper);
        alertCassandraDelegatingAsyncEventListener.addDelegate(ael);
        return ael;
    }

    @Bean
    public CassandraAsyncEventListener<Account> accountCassandraAsyncEventListener(Mapper<Account> accountMapper,
            DelegatingAsyncEventListener accountCassandraDelegatingAsyncEventListener) {
        LOG.info("accountCassandraAsyncEventListener");
        CassandraAsyncEventListener<Account> ael = new CassandraAsyncEventListener<>(accountMapper);
        accountCassandraDelegatingAsyncEventListener.addDelegate(ael);
        return ael;
    }

    @Bean
    public CassandraAsyncEventListener<AccountClassifierData> accountClassifierDataCassandraAsyncEventListener(
            Mapper<AccountClassifierData> classifierDataMapper,
            DelegatingAsyncEventListener accountClassifierDataCassandraDelegatingAsyncEventListener) {
        LOG.info("accountClassifierDataCassandraAsyncEventListener");
        CassandraAsyncEventListener<AccountClassifierData> ael = new CassandraAsyncEventListener<>(classifierDataMapper);
        accountClassifierDataCassandraDelegatingAsyncEventListener.addDelegate(ael);
        return ael;
    }

    @Bean
    public CassandraAsyncEventListener<CardClassifierData> cardClassifierDataCassandraAsyncEventListener(
            Mapper<CardClassifierData> cardClassifierDataMapper,
            DelegatingAsyncEventListener cardClassifierDataCassandraDelegatingAsyncEventListener) {
        LOG.info("cardClassifierDataCassandraAsyncEventListener");
        CassandraAsyncEventListener<CardClassifierData> ael = new CassandraAsyncEventListener<>(cardClassifierDataMapper);
        cardClassifierDataCassandraDelegatingAsyncEventListener.addDelegate(ael);
        return ael;
    }

    @Bean
    public CassandraAsyncEventListener<AccountBalance> accountBalanceCassandraAsyncEventListener(
            Mapper<AccountBalance> accountBalanceMapper,
            DelegatingAsyncEventListener accountBalanceCassandraDelegatingAsyncEventListener) {
        LOG.info("accountCassandraAsyncEventListener");
        CassandraAsyncEventListener<AccountBalance> ael = new CassandraAsyncEventListener<>(accountBalanceMapper);
        accountBalanceCassandraDelegatingAsyncEventListener.addDelegate(ael);
        return ael;
    }

    @Bean
    public CassandraAsyncEventListener<Vendor> vendorCassandraAsyncEventListener(Mapper<Vendor> vendorMapper,
            DelegatingAsyncEventListener vendorCassandraDelegatingAsyncEventListener) {
        LOG.info("vendorCassandraAsyncEventListener");
        CassandraAsyncEventListener<Vendor> ael = new CassandraAsyncEventListener<>(vendorMapper);
        vendorCassandraDelegatingAsyncEventListener.addDelegate(ael);
        return ael;
    }

    @Bean
    public CassandraAsyncEventListener<Card> cardCassandraAsyncEventListener(Mapper<Card> cardMapper,
            DelegatingAsyncEventListener cardCassandraDelegatingAsyncEventListener) {
        LOG.info("cardCassandraAsyncEventListener");
        CassandraAsyncEventListener<Card> ael = new CassandraAsyncEventListener<>(cardMapper);
        cardCassandraDelegatingAsyncEventListener.addDelegate(ael);
        return ael;
    }

    @Bean
    public CassandraAsyncEventListener<CardBalance> cardBalanceCassandraAsyncEventListener(Mapper<CardBalance> cardBalanceMapper,
            DelegatingAsyncEventListener cardBalanceCassandraDelegatingAsyncEventListener) {
        LOG.info("cardBalanceCassandraAsyncEventListener");
        CassandraAsyncEventListener<CardBalance> ael = new CassandraAsyncEventListener<>(cardBalanceMapper);
        cardBalanceCassandraDelegatingAsyncEventListener.addDelegate(ael);
        return ael;
    }

    @Bean
    public CassandraAsyncEventListener<Transaction> transactionCassandraAsyncEventListener(Mapper<Transaction> transactionMapper,
            DelegatingAsyncEventListener transactionCassandraDelegatingAsyncEventListener) {
        LOG.info("transactionCassandraAsyncEventListener");
        CassandraAsyncEventListener<Transaction> ael = new CassandraAsyncEventListener<>(transactionMapper);
        transactionCassandraDelegatingAsyncEventListener.addDelegate(ael);
        return ael;
    }

    @Bean
    public CassandraAsyncEventListener<TransactionHistory> transactionHistoryCassandraAsyncEventListener(
            Mapper<TransactionHistory> transactionHistoryMapper,
            DelegatingAsyncEventListener transactionHistoryCassandraDelegatingAsyncEventListener) {
        LOG.info("transactionHistoryCassandraAsyncEventListener");
        CassandraAsyncEventListener<TransactionHistory> ael = new CassandraAsyncEventListener<>(transactionHistoryMapper);
        transactionHistoryCassandraDelegatingAsyncEventListener.addDelegate(ael);
        return ael;
    }

    @Bean
    public CassandraAsyncEventListener<TransactionStatus> transactionStatusCassandraAsyncEventListener(
            Mapper<TransactionStatus> transactionStatusMapper,
            DelegatingAsyncEventListener transactionStatusCassandraDelegatingAsyncEventListener) {
        LOG.info("transactionStatusCassandraAsyncEventListener");
        CassandraAsyncEventListener<TransactionStatus> ael = new CassandraAsyncEventListener<>(transactionStatusMapper);
        transactionStatusCassandraDelegatingAsyncEventListener.addDelegate(ael);
        return ael;
    }

    @Bean
    public TransactionStatusAlertAsyncEventListener transactionStatusAlertAsyncEventListener(AlertDAO alertDAO,
            TransactionDAO transactionDAO, DelegatingAsyncEventListener transactionStatusAlertDelegatingAsyncEventListener) {
        LOG.info("transactionStatusAlertAsyncEventListener");
        TransactionStatusAlertAsyncEventListener ael = new TransactionStatusAlertAsyncEventListener(alertDAO, transactionDAO);
        transactionStatusAlertDelegatingAsyncEventListener.addDelegate(ael);
        return ael;
    }

    @Bean
    public AccountTransactionXrefAsyncEventListener accountTransactionXrefAsyncEventListener(
            AccountTransactionXrefDAO accountTransactionXrefDAO,
            DelegatingAsyncEventListener accountTransactionXrefDelegatingAsyncEventListener) {
        LOG.info("accountTransactionXrefAsyncEventListener");
        AccountTransactionXrefAsyncEventListener l = new AccountTransactionXrefAsyncEventListener(accountTransactionXrefDAO);
        accountTransactionXrefDelegatingAsyncEventListener.addDelegate(l);
        return l;
    }

    @Bean
    public CardTransactionXrefAsyncEventListener cardTransactionXrefAsyncEventListener(
            CardTransactionXrefDAO cardTransactionXrefDAO,
            DelegatingAsyncEventListener cardTransactionXrefDelegatingAsyncEventListener) {
        LOG.info("cardTransactionXrefAsyncEventListener");
        CardTransactionXrefAsyncEventListener l = new CardTransactionXrefAsyncEventListener(cardTransactionXrefDAO);
        cardTransactionXrefDelegatingAsyncEventListener.addDelegate(l);
        return l;
    }

    @Bean
    public AccountAggregateCacheLoader accountAggregateCacheLoader(AccountDAO accountDAO,
            AccountTransactionXrefDAO accountTransactionDAO, TransactionAggregateDAO transactionAggregateDAO,
            DelegatingCacheLoader<AccountKey, AccountAggregate> accountAggregateDelegatingCacheLoader) {
        LOG.info("accountTransactionXrefAsyncEventListener");
        AccountAggregateCacheLoader cl = new AccountAggregateCacheLoader(accountDAO, accountTransactionDAO,
                transactionAggregateDAO);
        accountAggregateDelegatingCacheLoader.setDelegate(cl);
        return cl;
    }

    @Bean
    public CardAggregateCacheLoader cardAggregateCacheLoader(CardDAO cardDAO, CardTransactionXrefDAO cardTransactionXrefDAO,
            TransactionAggregateDAO transactionAggregateDAO,
            DelegatingCacheLoader<CardKey, CardAggregate> cardAggregateDelegatingCacheLoader) {
        LOG.info("cardAggregateCacheLoader");
        CardAggregateCacheLoader cl = new CardAggregateCacheLoader(cardDAO, cardTransactionXrefDAO, transactionAggregateDAO);
        cardAggregateDelegatingCacheLoader.setDelegate(cl);
        return cl;
    }

    @Bean
    public TransactionAggregateCacheLoader transactionAggregateCacheLoader(TransactionHistoryXrefDAO transactionHistoryXrefDAO,
            TransactionHistoryDAO transactionHistoryDAO, TransactionDAO transactionDAO,
            DelegatingCacheLoader<TransactionKey, TransactionAggregate> transactionAggregateDelegatingCacheLoader) {
        LOG.info("transactionAggregateCacheLoader");
        TransactionAggregateCacheLoader cl = new TransactionAggregateCacheLoader(transactionHistoryXrefDAO, transactionHistoryDAO,
                transactionDAO);
        transactionAggregateDelegatingCacheLoader.setDelegate(cl);
        return cl;
    }

    @Bean
    public CardNumberAccountKeyXrefCacheListener cardNumberAccountKeyXrefCacheListener(CardNumberAccountKeyXrefDAO dao,
            DelegatingCacheListener<CardKey, Card> cardNumberAccountKeyXrefDelegatingCacheListener) {
        LOG.info("cardNumberAccountKeyXrefCacheListener");
        CardNumberAccountKeyXrefCacheListener cl = new CardNumberAccountKeyXrefCacheListener(dao);
        cardNumberAccountKeyXrefDelegatingCacheListener.addDelegate(cl);
        return cl;
    }

    @Bean
    public CardNumberCardKeyXrefCacheListener cardNumberCardKeyXrefCacheListener(CardNumberCardKeyXrefDAO dao,
            DelegatingCacheListener<CardKey, Card> cardNumberCardKeyXrefDelegatingCacheListener) {
        LOG.info("cardNumberCardKeyXrefCacheListener");
        CardNumberCardKeyXrefCacheListener cl = new CardNumberCardKeyXrefCacheListener(dao);
        cardNumberCardKeyXrefDelegatingCacheListener.addDelegate(cl);
        return cl;
    }

    @Bean
    public TransactionStatusClassifierAsyncEventListener transactionStatusClassifierAsyncEventListener(
            TransactionDAO transactionDAO, TransactionStatusDAO transactionStatusDAO,
            AccountTransactionXrefDAO accountTransactionXrefDAO, CardTransactionXrefDAO cardTransactionXrefDAO,
            AccountClassifierDataDAO accountClassifierDataDAO, CardClassifierDataDAO cardClassifierDataDAO,
            DelegatingAsyncEventListener transactionStatusClassifierDelegatingAsyncEventListener) {
        LOG.info("transactionStatusClassifierAsyncEventListener");
        TransactionStatusClassifierAsyncEventListener ael = new TransactionStatusClassifierAsyncEventListener(transactionDAO,
                transactionStatusDAO, accountTransactionXrefDAO, cardTransactionXrefDAO, accountClassifierDataDAO,
                cardClassifierDataDAO, properties.modelSize);
        transactionStatusClassifierDelegatingAsyncEventListener.addDelegate(ael);
        return ael;
    }

    @Bean
    public CardClassifierDataAsyncEventListener cardClassifierDataAsyncEventListener(CardClassifierDAO cardClassifierDAO,
            PropertyConfig properties, DelegatingAsyncEventListener cardClassifierDataDelegatingAsyncEventListener) {
        LOG.info("cardClassifierDataAsyncEventListener");
        CardClassifierDataAsyncEventListener ael = new CardClassifierDataAsyncEventListener(cardClassifierDAO,
                properties.numberOfTrees);
        cardClassifierDataDelegatingAsyncEventListener.addDelegate(ael);
        return ael;
    }

    @Bean
    public AccountClassifierDataAsyncEventListener accountClassifierDataAsyncEventListener(
            AccountClassifierDAO accountClassifierDAO, PropertyConfig properties,
            DelegatingAsyncEventListener accountClassifierDataDelegatingAsyncEventListener) {
        LOG.info("accountClassifierDataAsyncEventListener");
        AccountClassifierDataAsyncEventListener ael = new AccountClassifierDataAsyncEventListener(accountClassifierDAO,
                properties.numberOfTrees);
        accountClassifierDataDelegatingAsyncEventListener.addDelegate(ael);
        return ael;
    }
}
