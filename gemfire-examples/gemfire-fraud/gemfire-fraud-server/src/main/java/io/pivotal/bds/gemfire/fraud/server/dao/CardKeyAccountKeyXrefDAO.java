package io.pivotal.bds.gemfire.fraud.server.dao;

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;

public class CardKeyAccountKeyXrefDAO extends DefaultDAO<CardKey, AccountKey> {

    public CardKeyAccountKeyXrefDAO(Region<CardKey, AccountKey> region) {
        super(region);
    }

}
