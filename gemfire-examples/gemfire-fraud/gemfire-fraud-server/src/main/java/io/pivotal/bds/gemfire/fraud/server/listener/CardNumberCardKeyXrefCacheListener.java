package io.pivotal.bds.gemfire.fraud.server.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.fraud.common.data.Card;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;
import io.pivotal.bds.gemfire.fraud.server.dao.CardNumberCardKeyXrefDAO;

public class CardNumberCardKeyXrefCacheListener extends CacheListenerAdapter<CardKey, Card> {

    private CardNumberCardKeyXrefDAO dao;
    private static final Logger LOG = LoggerFactory.getLogger(CardNumberCardKeyXrefCacheListener.class);

    public CardNumberCardKeyXrefCacheListener(CardNumberCardKeyXrefDAO dao) {
        this.dao = dao;
    }

    @Override
    public void afterCreate(EntryEvent<CardKey, Card> event) {
        CardKey key = event.getKey();
        String cardNumber = event.getNewValue().getCardNumber();
        LOG.debug("afterCreate: cardNumber={}, key={}", cardNumber, key);
        dao.put(cardNumber, key);
    }

    @Override
    public void afterDestroy(EntryEvent<CardKey, Card> event) {
        String cardNumber = event.getOldValue().getCardNumber();
        LOG.debug("afterDestroy: cardNumber={}", cardNumber);
        dao.remove(cardNumber);
    }

    @Override
    public void afterUpdate(EntryEvent<CardKey, Card> event) {
        CardKey key = event.getKey();
        String oldCardNumber = event.getOldValue().getCardNumber();
        String newCardNumber = event.getNewValue().getCardNumber();
        LOG.debug("afterUpdate: oldCardNumber={}, newCardNumber={}, key={}", oldCardNumber, newCardNumber, key);

        if (!oldCardNumber.equals(newCardNumber)) {
            dao.remove(oldCardNumber);
            dao.put(newCardNumber, key);
        }
    }

}
