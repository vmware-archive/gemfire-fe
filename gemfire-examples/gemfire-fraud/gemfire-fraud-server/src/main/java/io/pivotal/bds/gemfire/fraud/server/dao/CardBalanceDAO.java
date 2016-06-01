package io.pivotal.bds.gemfire.fraud.server.dao;

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.data.CardBalance;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;

public class CardBalanceDAO extends DefaultDAO<CardKey, CardBalance> {

    public CardBalanceDAO(Region<CardKey, CardBalance> region) {
        super(region);
    }

}
