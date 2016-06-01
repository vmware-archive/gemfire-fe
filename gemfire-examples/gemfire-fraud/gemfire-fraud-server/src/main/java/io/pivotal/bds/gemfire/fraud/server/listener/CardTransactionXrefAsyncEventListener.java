package io.pivotal.bds.gemfire.fraud.server.listener;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEvent;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEventListener;

import io.pivotal.bds.gemfire.fraud.common.data.Transaction;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;
import io.pivotal.bds.gemfire.fraud.server.dao.CardTransactionXrefDAO;

public class CardTransactionXrefAsyncEventListener implements AsyncEventListener {

    private CardTransactionXrefDAO cardTransactionXrefDAO;

    private static final Logger LOG = LoggerFactory.getLogger(CardTransactionXrefAsyncEventListener.class);

    public CardTransactionXrefAsyncEventListener(CardTransactionXrefDAO cardTransactionXrefDAO) {
        this.cardTransactionXrefDAO = cardTransactionXrefDAO;
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
                    String cardId = txn.getCardId();
                    String acctId = txn.getAccountId();
                    CardKey cardKey = new CardKey(cardId, acctId);

                    Collection<TransactionKey> txnKeys = cardTransactionXrefDAO.get(cardKey, true);
                    txnKeys.add(txnKey);
                    cardTransactionXrefDAO.put(cardKey, txnKeys);
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
