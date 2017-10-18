package io.pivotal.bds.gemfire.fraud.server.dao;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.data.Card;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;

public class CardDAO extends DefaultDAO<CardKey, Card> {

    public CardDAO(Region<CardKey, Card> region) {
        super(region);
    }

}
