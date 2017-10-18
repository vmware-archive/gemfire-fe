package io.pivotal.bds.gemfire.fraud.server.dao;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.data.AccountClassifierData;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;

public class AccountClassifierDataDAO extends DefaultDAO<AccountKey, AccountClassifierData> {

    public AccountClassifierDataDAO(Region<AccountKey, AccountClassifierData> region) {
        super(region);
    }

}
