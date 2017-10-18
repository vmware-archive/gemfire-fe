package io.pivotal.bds.gemfire.fraud.server.dao;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.data.CardAggregate;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;

public class CardAggregateDAO extends DefaultDAO<CardKey, CardAggregate> {

    public CardAggregateDAO(Region<CardKey, CardAggregate> region) {
        super(region);
    }

}
