package io.pivotal.bds.gemfire.fraud.server.listener;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEvent;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEventListener;

import io.pivotal.bds.gemfire.fraud.common.data.Transaction;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountTransactionXrefDAO;

public class AccountTransactionXrefAsyncEventListener implements AsyncEventListener {

    private AccountTransactionXrefDAO accountTransactionXrefDAO;

    private static final Logger LOG = LoggerFactory.getLogger(AccountTransactionXrefAsyncEventListener.class);

    public AccountTransactionXrefAsyncEventListener(AccountTransactionXrefDAO accountTransactionXrefDAO) {
        this.accountTransactionXrefDAO = accountTransactionXrefDAO;
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
                    TransactionKey txnKey = (TransactionKey) event.getKey();
                    Transaction txn = (Transaction) event.getDeserializedValue();
                    String acctId = txn.getAccountId();
                    AccountKey acctKey = new AccountKey(acctId);

                    Collection<TransactionKey> txnKeys = accountTransactionXrefDAO.get(acctKey, true);
                    txnKeys.add(txnKey);
                    accountTransactionXrefDAO.put(acctKey, txnKeys);
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
