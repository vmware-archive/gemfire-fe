package io.pivotal.bds.gemfire.fraud.server.dao;

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;

public class CardNumberCardKeyXrefDAO extends DefaultDAO<String, CardKey> {

    public CardNumberCardKeyXrefDAO(Region<String, CardKey> region) {
        super(region);
    }

}
