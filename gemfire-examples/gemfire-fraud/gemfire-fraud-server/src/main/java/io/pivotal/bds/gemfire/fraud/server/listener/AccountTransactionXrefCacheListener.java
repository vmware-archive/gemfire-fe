package io.pivotal.bds.gemfire.fraud.server.listener;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.fraud.common.data.Transaction;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountTransactionXrefDAO;

public class AccountTransactionXrefCacheListener extends CacheListenerAdapter<TransactionKey, Transaction> {

    private AccountTransactionXrefDAO accountTransactionXrefDAO;

    private static final Logger LOG = LoggerFactory.getLogger(AccountTransactionXrefCacheListener.class);

    public AccountTransactionXrefCacheListener(AccountTransactionXrefDAO accountTransactionXrefDAO) {
        this.accountTransactionXrefDAO = accountTransactionXrefDAO;
    }

    @Override
    public void afterCreate(EntryEvent<TransactionKey, Transaction> event) {
        LOG.debug("afterCreate: event={}", event);
        process(event);
    }

    @Override
    public void afterUpdate(EntryEvent<TransactionKey, Transaction> event) {
        LOG.debug("afterUpdate: event={}", event);
        process(event);
    }

    private void process(EntryEvent<TransactionKey, Transaction> event) {
        TransactionKey key = event.getKey();
        Transaction txn = event.getNewValue();

        String acctId = txn.getAccountId();
        AccountKey acctKey = new AccountKey(acctId);

        Collection<TransactionKey> txnKeys = accountTransactionXrefDAO.get(acctKey, true);
        txnKeys.add(key);
        accountTransactionXrefDAO.put(acctKey, txnKeys);
    }

}
