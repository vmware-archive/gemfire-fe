package io.pivotal.bds.gemfire.fraud.server.listener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Operation;
import org.apache.geode.cache.asyncqueue.AsyncEvent;
import org.apache.geode.cache.asyncqueue.AsyncEventListener;

import io.pivotal.bds.gemfire.fraud.common.data.CardClassifierData;
import io.pivotal.bds.gemfire.fraud.common.data.AccountClassifierData;
import io.pivotal.bds.gemfire.fraud.common.data.Transaction;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionResultCode;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionStatus;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionStatusCode;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountClassifierDataDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountTransactionXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardClassifierDataDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardTransactionXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionStatusDAO;
import io.pivotal.bds.gemfire.fraud.server.util.Utils;

public class TransactionStatusClassifierAsyncEventListener implements AsyncEventListener {

    private TransactionDAO transactionDAO;
    private TransactionStatusDAO transactionStatusDAO;
    private AccountTransactionXrefDAO accountTransactionXrefDAO;
    private CardTransactionXrefDAO cardTransactionXrefDAO;
    private AccountClassifierDataDAO accountClassifierDataDAO;
    private CardClassifierDataDAO cardClassifierDataDAO;

    private int modelSize;

    private static final Logger LOG = LoggerFactory.getLogger(TransactionStatusClassifierAsyncEventListener.class);

    public TransactionStatusClassifierAsyncEventListener(TransactionDAO transactionDAO, TransactionStatusDAO transactionStatusDAO,
            AccountTransactionXrefDAO accountTransactionXrefDAO, CardTransactionXrefDAO cardTransactionXrefDAO,
            AccountClassifierDataDAO accountClassifierDataDAO, CardClassifierDataDAO cardClassifierDataDAO, int modelSize) {
        this.transactionDAO = transactionDAO;
        this.transactionStatusDAO = transactionStatusDAO;
        this.accountTransactionXrefDAO = accountTransactionXrefDAO;
        this.cardTransactionXrefDAO = cardTransactionXrefDAO;
        this.accountClassifierDataDAO = accountClassifierDataDAO;
        this.cardClassifierDataDAO = cardClassifierDataDAO;
        this.modelSize = modelSize;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        LOG.debug("processEvents: events.size={}", events.size());

        try {
            for (AsyncEvent event : events) {
                LOG.debug("processEvents: event={}", event);

                Operation op = event.getOperation();

                if (op.isCreate() || op.isUpdate()) {
                    TransactionKey txnKey = (TransactionKey) event.getKey();
                    TransactionStatus status = (TransactionStatus) event.getDeserializedValue();

                    TransactionStatusCode statusCode = status.getTransactionStatusCode();

                    if (statusCode == TransactionStatusCode.completed) {
                        processAccount(txnKey);
                        processCard(txnKey);
                    }
                }
            }

            return true;
        } catch (Exception x) {
            LOG.error("processEvents: x={}", x.toString(), x);
            return false;
        }
    }

    private void processAccount(TransactionKey txnKey) throws Exception {
        LOG.debug("processAccount: txnKey={}", txnKey);

        String acctId = txnKey.getColocationId();
        AccountKey acctKey = new AccountKey(acctId);
        Collection<TransactionKey> transactionKeys = accountTransactionXrefDAO.get(acctKey);

        if (transactionKeys.size() >= modelSize) { // must have enough to generate model
            Map<TransactionKey, Transaction> transactionMap = transactionDAO.getAll(transactionKeys);
            Collection<Transaction> transactions = transactionMap.values();
            List<Transaction> list = new ArrayList<>(transactions);
            list.sort(comp);

            Set<Integer> classes = new HashSet<>();
            List<Integer> yList = new ArrayList<>();
            List<Double> xList = new ArrayList<>();

            for (int i = 0; i < list.size() && yList.size() < modelSize; ++i) {
                Transaction t = list.get(i);
                TransactionKey tk = new TransactionKey(t.getTransactionId(), t.getAccountId());
                TransactionStatus txnStatus = transactionStatusDAO.retrieve(tk);
                TransactionStatusCode status = txnStatus.getTransactionStatusCode();

                if (status == TransactionStatusCode.completed) {
                    TransactionResultCode result = txnStatus.getTransactionResultCode();
                    int label = result == TransactionResultCode.success ? 0 : 1;
                    double amt = t.getAmount();

                    yList.add(label);
                    xList.add(amt);
                    classes.add(label);
                }
            }

            if (yList.size() < modelSize) {
                LOG.debug("processAccount: not enought transactions for account={}: {}", acctId, yList.size());
            } else if (classes.size() < 2) {
                LOG.debug("processAccount: not enought classes for account={}", acctId);
            } else {
                int[] y = Utils.convertToIntVector(yList);
                double[][] x = Utils.convertToMatrix(xList);

                AccountClassifierData data = new AccountClassifierData();

                data.setAccountId(acctId);
                data.setX(x);
                data.setY(y);

                accountClassifierDataDAO.put(acctKey, data);
            }
        } else {
            LOG.debug("processAccount: not enough transactions for account={}, transactionKeys.size={}", acctId,
                    transactionKeys.size());
        }
    }

    private void processCard(TransactionKey txnKey) throws Exception {
        LOG.debug("processCard: txnKey={}", txnKey);

        Transaction txn = transactionDAO.retrieve(txnKey);

        String cardId = txn.getCardId();
        String acctId = txn.getAccountId();

        CardKey cardKey = new CardKey(cardId, acctId);
        LOG.debug("processCard: cardKey={}, txnKey={}", cardKey, txnKey);

        Collection<TransactionKey> transactionKeys = cardTransactionXrefDAO.get(cardKey);

        if (transactionKeys.size() >= modelSize) { // must have enough to generate model
            Map<TransactionKey, Transaction> transactionMap = transactionDAO.getAll(transactionKeys);
            Collection<Transaction> transactions = transactionMap.values();
            List<Transaction> list = new ArrayList<>(transactions);
            list.sort(comp);

            Set<Integer> classes = new HashSet<>();
            List<Integer> yList = new ArrayList<>();
            List<Double> xList = new ArrayList<>();

            for (int i = 0; i < list.size() && yList.size() < modelSize; ++i) {
                Transaction t = list.get(i);
                TransactionKey tk = new TransactionKey(t.getTransactionId(), t.getAccountId());
                TransactionStatus txnStatus = transactionStatusDAO.retrieve(tk);
                TransactionStatusCode status = txnStatus.getTransactionStatusCode();

                if (status == TransactionStatusCode.completed) {
                    TransactionResultCode result = txnStatus.getTransactionResultCode();
                    int label = result == TransactionResultCode.success ? 0 : 1;
                    double amt = t.getAmount();

                    yList.add(label);
                    xList.add(amt);
                    classes.add(label);
                }
            }

            if (yList.size() < modelSize) {
                LOG.debug("processCard: not enought transactions for card={}: {}", cardId, yList.size());
            } else if (classes.size() < 2) {
                LOG.debug("processCard: not enought classes for card={}", cardId);
            } else {
                int[] y = Utils.convertToIntVector(yList);
                double[][] x = Utils.convertToMatrix(xList);

                CardClassifierData data = new CardClassifierData();

                data.setCardId(cardId);
                data.setAccountId(acctId);
                data.setX(x);
                data.setY(y);

                cardClassifierDataDAO.put(cardKey, data);
            }
        } else {
            LOG.debug("processCard: not enough transactions for card={}, transactionKeys.size={}", cardId, transactionKeys.size());
        }
    }

    @Override
    public void close() {
    }

    private static final Comp comp = new Comp();

    private static class Comp implements Comparator<Transaction> {

        @Override
        public int compare(Transaction o1, Transaction o2) {
            return o2.getCreatedOn().compareTo(o1.getCreatedOn());
        }
    }
}
