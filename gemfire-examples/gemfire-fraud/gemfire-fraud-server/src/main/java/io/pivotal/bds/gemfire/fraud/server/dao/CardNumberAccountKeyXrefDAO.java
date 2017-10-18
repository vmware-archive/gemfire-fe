package io.pivotal.bds.gemfire.fraud.server.dao;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;

public class CardNumberAccountKeyXrefDAO extends DefaultDAO<String, AccountKey> {

    public CardNumberAccountKeyXrefDAO(Region<String, AccountKey> region) {
        super(region);
    }

}
