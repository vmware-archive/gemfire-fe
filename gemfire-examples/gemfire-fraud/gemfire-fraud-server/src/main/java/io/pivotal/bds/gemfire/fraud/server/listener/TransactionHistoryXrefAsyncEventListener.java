package io.pivotal.bds.gemfire.fraud.server.listener;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Operation;
import org.apache.geode.cache.asyncqueue.AsyncEvent;
import org.apache.geode.cache.asyncqueue.AsyncEventListener;

import io.pivotal.bds.gemfire.fraud.common.data.TransactionHistory;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionHistoryKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionHistoryXrefDAO;

public class TransactionHistoryXrefAsyncEventListener implements AsyncEventListener {

    private TransactionHistoryXrefDAO transactionHistoryXrefDAO;

    private static final Logger LOG = LoggerFactory.getLogger(TransactionHistoryXrefAsyncEventListener.class);

    public TransactionHistoryXrefAsyncEventListener(TransactionHistoryXrefDAO transactionHistoryXrefDAO) {
        this.transactionHistoryXrefDAO = transactionHistoryXrefDAO;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        LOG.debug("processEvents: events.size={}", events.size());

        try {
            for (AsyncEvent event : events) {
                LOG.debug("processEvents: event={}", event);

                Operation op = event.getOperation();

                if (op.isCreate()) {
                    TransactionHistoryKey txnHistKey = (TransactionHistoryKey) event.getKey();
                    TransactionHistory history = (TransactionHistory) event.getDeserializedValue();
                    String txnId = history.getTransactionId();
                    String acctId = history.getAccountId();
                    TransactionKey txnKey = new TransactionKey(txnId, acctId);

                    Collection<TransactionHistoryKey> txnHistKeys = transactionHistoryXrefDAO.get(txnKey, true);
                    txnHistKeys.add(txnHistKey);
                    transactionHistoryXrefDAO.put(txnKey, txnHistKeys);
                }
            }

            return true;
        } catch (Exception x) {
            LOG.error("processEvents: x={}", x.toString(), x);
            return false;
        }
    }

    @Override
    public void close() {
    }

}
