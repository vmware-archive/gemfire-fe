package io.pivotal.bds.gemfire.fraud.server.listener;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.fraud.common.data.Transaction;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;
import io.pivotal.bds.gemfire.fraud.server.dao.CardTransactionXrefDAO;

public class CardTransactionXrefCacheListener extends CacheListenerAdapter<TransactionKey, Transaction> {

    private CardTransactionXrefDAO cardTransactionXrefDAO;

    private static final Logger LOG = LoggerFactory.getLogger(CardTransactionXrefCacheListener.class);

    public CardTransactionXrefCacheListener(CardTransactionXrefDAO cardTransactionXrefDAO) {
        this.cardTransactionXrefDAO = cardTransactionXrefDAO;
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

        String cardId = txn.getCardId();
        String acctId = txn.getAccountId();
        CardKey cardKey = new CardKey(cardId, acctId);

        Collection<TransactionKey> txnKeys = cardTransactionXrefDAO.get(cardKey, true);
        txnKeys.add(key);
        cardTransactionXrefDAO.put(cardKey, txnKeys);
    }

}
