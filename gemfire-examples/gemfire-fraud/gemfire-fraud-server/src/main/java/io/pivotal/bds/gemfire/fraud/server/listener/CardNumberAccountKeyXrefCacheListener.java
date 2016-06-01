package io.pivotal.bds.gemfire.fraud.server.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.fraud.common.data.Card;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;
import io.pivotal.bds.gemfire.fraud.server.dao.CardNumberAccountKeyXrefDAO;

public class CardNumberAccountKeyXrefCacheListener extends CacheListenerAdapter<CardKey, Card> {

    private CardNumberAccountKeyXrefDAO dao;
    private static final Logger LOG = LoggerFactory.getLogger(CardNumberAccountKeyXrefCacheListener.class);

    public CardNumberAccountKeyXrefCacheListener(CardNumberAccountKeyXrefDAO dao) {
        this.dao = dao;
    }

    @Override
    public void afterCreate(EntryEvent<CardKey, Card> event) {
        String cardNumber = event.getNewValue().getCardNumber();
        String acctId = event.getNewValue().getAccountId();
        LOG.debug("afterCreate: acctId={}, cardNumber={}", acctId, cardNumber);
        AccountKey acctKey = new AccountKey(acctId);
        dao.put(cardNumber, acctKey);
    }

    @Override
    public void afterDestroy(EntryEvent<CardKey, Card> event) {
        String cardNumber = event.getOldValue().getCardNumber();
        LOG.debug("afterDestroy: cardNumber={}", cardNumber);
        dao.remove(cardNumber);
    }

    @Override
    public void afterUpdate(EntryEvent<CardKey, Card> event) {
        String cardNumber = event.getNewValue().getCardNumber();
        String acctId = event.getNewValue().getAccountId();
        LOG.debug("afterUpdate: acctId={}, cardNumber={}", acctId, cardNumber);
        AccountKey acctKey = new AccountKey(acctId);
        dao.put(cardNumber, acctKey);
    }

}
