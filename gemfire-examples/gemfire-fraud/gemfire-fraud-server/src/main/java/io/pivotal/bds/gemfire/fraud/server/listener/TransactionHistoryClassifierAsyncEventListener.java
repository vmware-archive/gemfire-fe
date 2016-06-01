package io.pivotal.bds.gemfire.fraud.server.listener;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEvent;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEventListener;

import io.pivotal.bds.gemfire.fraud.common.data.AccountAggregate;
import io.pivotal.bds.gemfire.fraud.common.data.Transaction;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionAggregate;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionHistory;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionResultCode;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionStatus;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionStatusCode;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountAggregateDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountClassifierDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionStatusDAO;
import io.pivotal.bds.gemfire.fraud.server.util.Utils;
import smile.classification.RandomForest;

public class TransactionHistoryClassifierAsyncEventListener implements AsyncEventListener {

    private TransactionDAO transactionDAO;
    private TransactionStatusDAO transactionStatusDAO;
    private AccountAggregateDAO accountAggregateDAO;
    private AccountClassifierDAO accountClassifierDAO;

    private int modelSize;
    private int numberOfTrees;

    public TransactionHistoryClassifierAsyncEventListener(TransactionDAO transactionDAO, TransactionStatusDAO transactionStatusDAO,
            AccountAggregateDAO accountAggregateDAO, AccountClassifierDAO accountClassifierDAO, int modelSize, int numberOfTrees) {
        this.transactionDAO = transactionDAO;
        this.transactionStatusDAO = transactionStatusDAO;
        this.accountAggregateDAO = accountAggregateDAO;
        this.accountClassifierDAO = accountClassifierDAO;
        this.modelSize = modelSize;
        this.numberOfTrees = numberOfTrees;
    }

    private static final Logger LOG = LoggerFactory.getLogger(TransactionHistoryClassifierAsyncEventListener.class);

    @SuppressWarnings("rawtypes")
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        LOG.debug("processEvents: events.size={}", events.size());

        try {
            for (AsyncEvent event : events) {
                LOG.debug("processEvents: event={}", event);

                Operation op = event.getOperation();

                if (op.isCreate()) {
                    TransactionHistory history = (TransactionHistory) event.getDeserializedValue();
                    String txnId = history.getTransactionId();
                    String acctId = history.getAccountId();
                    TransactionKey txnKey = new TransactionKey(txnId, acctId);

                    TransactionStatusCode statusCode = history.getTransactionStatusCode();

                    if (statusCode == TransactionStatusCode.completed) {
                        TransactionStatus status = this.transactionStatusDAO.retrieve(txnKey);
                        TransactionResultCode resultCode = status.getTransactionResultCode();

                        switch (resultCode) {
                            case success: {
                                process(txnKey);
                                break;
                            }
                            default: {
                                LOG.debug("processEvents: resultCode={}, event={}", resultCode, event);
                            }
                        }
                    }
                }
            }

            return true;
        } catch (Exception x) {
            LOG.error("processEvents: x={}", x.toString(), x);
            return false;
        }
    }

    private void process(TransactionKey txnKey) {
        Transaction txn = transactionDAO.retrieve(txnKey);
        String acctId = txn.getAccountId();
        AccountKey acctKey = new AccountKey(acctId);
        AccountAggregate acctAggr = accountAggregateDAO.retrieve(acctKey);
        List<TransactionAggregate> transactions = acctAggr.getTransactions();

        if (transactions.size() >= modelSize) { // must have enough to generate model
            List<Integer> yList = new ArrayList<>();
            List<Double> xList = new ArrayList<>();

            for (int i = transactions.size() - 1; i >= 0 && yList.size() <= modelSize; ++i) {
                TransactionAggregate txnAggr = transactions.get(i);
                Transaction t = txnAggr.getTransaction();
                TransactionStatus txnStatus = transactionStatusDAO.retrieve(txnKey);
                TransactionStatusCode status = txnStatus.getTransactionStatusCode();

                if (status == TransactionStatusCode.completed) {
                    TransactionResultCode result = txnStatus.getTransactionResultCode();
                    int label = result == TransactionResultCode.success ? 0 : 1;
                    double amt = t.getAmount();

                    yList.add(label);
                    xList.add(amt);
                }
            }

            if (yList.size() >= modelSize) {
                int[] y = Utils.convertToIntVector(yList);
                double[][] x = Utils.convertToMatrix(xList);

                RandomForest rf = new RandomForest(x, y, numberOfTrees);
                accountClassifierDAO.store(acctKey, rf);
            }
        }
    }

    @Override
    public void close() {
    }

}
