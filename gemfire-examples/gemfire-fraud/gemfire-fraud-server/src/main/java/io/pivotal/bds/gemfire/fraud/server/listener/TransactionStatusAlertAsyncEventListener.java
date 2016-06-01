package io.pivotal.bds.gemfire.fraud.server.listener;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.asyncqueue.AsyncEvent;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEventListener;

import io.pivotal.bds.gemfire.fraud.common.data.Alert;
import io.pivotal.bds.gemfire.fraud.common.data.Transaction;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionResultCode;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionStatus;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionStatusCode;
import io.pivotal.bds.gemfire.fraud.common.key.AlertKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;
import io.pivotal.bds.gemfire.fraud.server.dao.AlertDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionDAO;

public class TransactionStatusAlertAsyncEventListener implements AsyncEventListener {

    private AlertDAO alertDAO;
    private TransactionDAO transactionDAO;

    private static final Logger LOG = LoggerFactory.getLogger(TransactionStatusAlertAsyncEventListener.class);

    public TransactionStatusAlertAsyncEventListener(AlertDAO alertDAO, TransactionDAO transactionDAO) {
        this.alertDAO = alertDAO;
        this.transactionDAO = transactionDAO;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        try {
            for (AsyncEvent event : events) {
                TransactionStatus txnStatus = (TransactionStatus) event.getDeserializedValue();
                TransactionStatusCode status = txnStatus.getTransactionStatusCode();
                TransactionResultCode result = txnStatus.getTransactionResultCode();

                if (status == TransactionStatusCode.completed && result == TransactionResultCode.success_flagged) {
                    TransactionKey txnKey = (TransactionKey) event.getKey();
                    LOG.debug("processEvents: alert: txnKey={}", txnKey);
                    Transaction txn = transactionDAO.retrieve(txnKey);

                    String txnId = txnKey.getId();
                    String alertId = UUID.randomUUID().toString();
                    String acctId = txn.getAccountId();

                    AlertKey ak = new AlertKey(alertId, txnId);

                    Alert alert = new Alert();

                    alert.setAlertId(alertId);
                    alert.setTransactionId(txnId);
                    alert.setAccountId(acctId);
                    alert.setCreatedOn(new Date());
                    alert.setMessage("Transaction flagged as possibly fraudulent");

                    alertDAO.put(ak, alert);
                }
            }
            
            return true;
        } catch (Exception x) {
            LOG.error("processEvents: x={}", x.toString(), x);
        }

        return false;
    }

    @Override
    public void close() {
    }

}
