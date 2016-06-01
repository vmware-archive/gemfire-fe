package io.pivotal.bds.gemfire.fraud.server.dao;

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.data.CardClassifierData;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;

public class CardClassifierDataDAO extends DefaultDAO<CardKey, CardClassifierData> {

    public CardClassifierDataDAO(Region<CardKey, CardClassifierData> region) {
        super(region);
    }

}
