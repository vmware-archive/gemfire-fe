package io.pivotal.bds.gemfire.fraud.server.conf;

import java.util.Collection;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.Resource;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.gemstone.gemfire.cache.Region;

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
import smile.classification.Classifier;
import smile.regression.Regression;

@Component("RegionHolder")
@DependsOn("RegionConfig")
public class RegionHolder implements Constants {

    @Resource(name = TRANSACTION_ROUTING_REGION_BEAN_NAME)
    public Region<ProcessTransactionRequest, String> transactionRoutingRegion;

    @Resource(name = ACCOUNT_REGION_BEAN_NAME)
    public Region<AccountKey, Account> accountRegion;

    @Resource(name = ACCOUNT_BALANCE_REGION_BEAN_NAME)
    public Region<AccountKey, AccountBalance> accountBalanceRegion;

    @Resource(name = ACCOUNT_AGGREGATE_REGION_BEAN_NAME)
    public Region<AccountKey, AccountAggregate> accountAggregateRegion;

    @Resource(name = ACCOUNT_CLASSIFIER_REGION_BEAN_NAME)
    public Region<AccountKey, Classifier<double[]>> accountClassifierRegion;

    @Resource(name = ACCOUNT_REGRESSION_REGION_BEAN_NAME)
    public Region<AccountKey, Regression<double[]>> accountRegressionRegion;

    @Resource(name = ACCOUNT_TRANSACTION_XREF_REGION_BEAN_NAME)
    public Region<AccountKey, Collection<TransactionKey>> accountTransactionXrefRegion;

    @Resource(name = TRANSACTION_REGION_BEAN_NAME)
    public Region<TransactionKey, Transaction> transactionRegion;

    @Resource(name = TRANSACTION_AGGREGATE_REGION_BEAN_NAME)
    public Region<TransactionKey, TransactionAggregate> transactionAggregateRegion;

    @Resource(name = TRANSACTION_HISTORY_REGION_BEAN_NAME)
    public Region<TransactionHistoryKey, TransactionHistory> transactionHistoryRegion;

    @Resource(name = TRANSACTION_HISTORY_XREF_REGION_BEAN_NAME)
    public Region<TransactionKey, Collection<TransactionHistoryKey>> transactionHistoryXrefRegion;

    @Resource(name = TRANSACTION_STATUS_REGION_BEAN_NAME)
    public Region<TransactionKey, TransactionStatus> transactionStatusRegion;

    @Resource(name = VENDOR_REGION_BEAN_NAME)
    public Region<VendorKey, Vendor> vendorRegion;

    @Resource(name = CARD_REGION_BEAN_NAME)
    public Region<CardKey, Card> cardRegion;

    @Resource(name = CARD_BALANCE_REGION_BEAN_NAME)
    public Region<CardKey, CardBalance> cardBalanceRegion;

    @Resource(name = CARD_LOCK_REGION_BEAN_NAME)
    public Region<CardKey, ReentrantReadWriteLock> cardLockRegion;

    @Resource(name = CARD_AGGREGATE_REGION_BEAN_NAME)
    public Region<CardKey, CardAggregate> cardAggregateRegion;

    @Resource(name = CARD_NUMBER_ACCOUNTKEY_XREF_REGION_BEAN_NAME)
    public Region<String, AccountKey> cardNumberAccountKeyXrefRegion;

    @Resource(name = CARD_NUMBER_CARDKEY_XREF_REGION_BEAN_NAME)
    public Region<String, CardKey> cardNumberCardKeyXrefRegion;

    @Resource(name = CARD_TRANSACTION_XREF_REGION_BEAN_NAME)
    public Region<CardKey, Collection<TransactionKey>> cardTransactionXrefRegion;

    @Resource(name = CARD_CLASSIFIER_REGION_BEAN_NAME)
    public Region<CardKey, Classifier<double[]>> cardClassifierRegion;

    @Resource(name = CARD_CLASSIFIER_DATA_REGION_BEAN_NAME)
    public Region<CardKey, CardClassifierData> cardClassifierDataRegion;

    @Resource(name = ACCOUNT_CLASSIFIER_DATA_REGION_BEAN_NAME)
    public Region<AccountKey, AccountClassifierData> accountClassifierDataRegion;

    @Resource(name = ALERT_REGION_BEAN_NAME)
    public Region<AlertKey, Alert> alertRegion;

}
