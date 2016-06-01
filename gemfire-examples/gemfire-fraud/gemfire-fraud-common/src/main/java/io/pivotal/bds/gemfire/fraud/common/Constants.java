package io.pivotal.bds.gemfire.fraud.common;

public interface Constants {

    String ACCOUNT_REGION_NAME = "account";

    String ACCOUNT_REGION_BEAN_NAME = "accountRegion";

    String ACCOUNT_DISK_STORE_NAME = "account";

    String ACCOUNT_ASYNC_EVENT_QUEUE_NAME = "accountQueue";

    String ACCOUNT_BALANCE_REGION_NAME = "accountBalance";

    String ACCOUNT_BALANCE_REGION_BEAN_NAME = "accountBalanceRegion";

    String ACCOUNT_BALANCE_DISK_STORE_NAME = "accountBalance";

    String ACCOUNT_BALANCE_ASYNC_EVENT_QUEUE_NAME = "accountBalanceQueue";

    String ACCOUNT_AGGREGATE_REGION_NAME = "accountAggregate";

    String ACCOUNT_AGGREGATE_REGION_BEAN_NAME = "accountAggregateRegion";

    String ACCOUNT_CLASSIFIER_REGION_NAME = "accountClassifier";

    String ACCOUNT_CLASSIFIER_REGION_BEAN_NAME = "accountClassifierRegion";

    String ACCOUNT_CLASSIFIER_DATA_DISK_STORE_NAME = "accountClassifierData";

    String ACCOUNT_CLASSIFIER_DATA_REGION_NAME = "accountClassifierData";

    String ACCOUNT_CLASSIFIER_DATA_REGION_BEAN_NAME = "accountClassifierDataRegion";

    String ACCOUNT_CLASSIFIER_DATA_ASYNC_EVENT_QUEUE_NAME = "accountClassifierDataQueue";

    String ACCOUNT_CLASSIFIER_DATA_CASSANDRA_ASYNC_EVENT_QUEUE_NAME = "accountClassifierDataCassandraQueue";

    String ACCOUNT_REGRESSION_REGION_NAME = "accountRegression";

    String ACCOUNT_REGRESSION_REGION_BEAN_NAME = "accountRegressionRegion";

    String ACCOUNT_TRANSACTION_XREF_REGION_NAME = "accountTransactionXref";

    String ACCOUNT_TRANSACTION_XREF_REGION_BEAN_NAME = "accountTransactionXrefRegion";

    String ACCOUNT_TRANSACTION_XREF_ASYNC_EVENT_QUEUE_NAME = "accountTransactionXrefQueue";

    String CARD_REGION_NAME = "card";

    String CARD_REGION_BEAN_NAME = "cardRegion";

    String CARD_DISK_STORE_NAME = "card";

    String CARD_CASSANDRA_ASYNC_EVENT_QUEUE_NAME = "cardCassandraQueue";

    String CARD_BALANCE_REGION_NAME = "cardBalance";

    String CARD_BALANCE_REGION_BEAN_NAME = "cardBalanceRegion";

    String CARD_BALANCE_DISK_STORE_NAME = "cardBalance";

    String CARD_BALANCE_CASSANDRA_ASYNC_EVENT_QUEUE_NAME = "cardBalanceCassandraQueue";

    String CARD_TRANSACTION_XREF_REGION_NAME = "cardTransactionXref";

    String CARD_TRANSACTION_XREF_REGION_BEAN_NAME = "cardTransactionXrefRegion";

    String CARD_TRANSACTION_XREF_ASYNC_EVENT_QUEUE_NAME = "cardTransactionXrefQueue";

    String CARD_CLASSIFIER_REGION_NAME = "cardClassifier";

    String CARD_CLASSIFIER_REGION_BEAN_NAME = "cardClassifierRegion";

    String CARD_CLASSIFIER_DATA_REGION_NAME = "cardClassifierData";

    String CARD_CLASSIFIER_DATA_REGION_BEAN_NAME = "cardClassifierDataRegion";

    String CARD_CLASSIFIER_DATA_DISK_STORE_NAME = "cardClassifierData";

    String CARD_CLASSIFIER_DATA_ASYNC_EVENT_QUEUE_NAME = "cardClassifierDataQueue";

    String CARD_CLASSIFIER_DATA_CASSANDRA_ASYNC_EVENT_QUEUE_NAME = "cardClassifierDataCassandraQueue";

    String CARD_AGGREGATE_REGION_NAME = "cardAggregate";

    String CARD_AGGREGATE_REGION_BEAN_NAME = "cardAggregateRegion";

    String CARD_LOCK_REGION_NAME = "cardLock";

    String CARD_LOCK_REGION_BEAN_NAME = "cardLockRegion";

    String TRANSACTION_REGION_NAME = "transaction";

    String TRANSACTION_REGION_BEAN_NAME = "transactionRegion";

    String TRANSACTION_ROUTING_REGION_NAME = "transactionRouting";

    String TRANSACTION_ROUTING_REGION_BEAN_NAME = "transactionRoutingRegion";

    String TRANSACTION_DISK_STORE_NAME = "transaction";

    String TRANSACTION_ASYNC_EVENT_QUEUE_NAME = "transactionQueue";

    String TRANSACTION_HISTORY_REGION_NAME = "transactionHistory";

    String TRANSACTION_HISTORY_REGION_BEAN_NAME = "transactionHistoryRegion";

    String TRANSACTION_HISTORY_DISK_STORE_NAME = "transactionHistory";

    String TRANSACTION_HISTORY_ASYNC_EVENT_QUEUE_NAME = "transactionHistoryQueue";

    String TRANSACTION_AGGREGATE_REGION_NAME = "transactionAggregate";

    String TRANSACTION_AGGREGATE_REGION_BEAN_NAME = "transactionAggregateRegion";

    String TRANSACTION_HISTORY_XREF_REGION_NAME = "transactionHistoryXref";

    String TRANSACTION_HISTORY_XREF_REGION_BEAN_NAME = "transactionHistoryXrefRegion";

    String TRANSACTION_HISTORY_XREF_ASYNC_EVENT_QUEUE_NAME = "transactionHistoryXrefQueue";

    String TRANSACTION_STATUS_REGION_NAME = "transactionStatus";

    String TRANSACTION_STATUS_REGION_BEAN_NAME = "transactionStatusRegion";

    String TRANSACTION_STATUS_DISK_STORE_NAME = "transactionStatus";

    String TRANSACTION_STATUS_CASSANDRA_ASYNC_EVENT_QUEUE_NAME = "transactionStatusCassandraQueue";

    String TRANSACTION_STATUS_ALERT_ASYNC_EVENT_QUEUE_NAME = "transactionStatusAlertQueue";

    String TRANSACTION_STATUS_CLASSIFIER_ASYNC_EVENT_QUEUE_NAME = "transactionStatusClassifierQueue";

    String VENDOR_REGION_NAME = "vendor";

    String VENDOR_REGION_BEAN_NAME = "vendorRegion";

    String VENDOR_DISK_STORE_NAME = "vendor";

    String VENDOR_CASSANDRA_ASYNC_EVENT_QUEUE_NAME = "vendorQueue";

    String QUEUE_DISK_STORE_NAME = "queue";

    String CARD_NUMBER_ACCOUNTKEY_XREF_REGION_NAME = "cardNumberAccountKeyXref";

    String CARD_NUMBER_ACCOUNTKEY_XREF_REGION_BEAN_NAME = "cardNumberAccountKeyXrefRegion";

    String CARD_NUMBER_CARDKEY_XREF_REGION_NAME = "cardNumberCardKeyXref";

    String CARD_NUMBER_CARDKEY_XREF_REGION_BEAN_NAME = "cardNumberCardKeyXrefRegion";

    String ALERT_REGION_NAME = "alert";

    String ALERT_REGION_BEAN_NAME = "alertRegion";

    String ALERT_DISK_STORE_NAME = "alert";

    String ALERT_CASSANDRA_ASYNC_EVENT_QUEUE_NAME = "alertQueue";

}
