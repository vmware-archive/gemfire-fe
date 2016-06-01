package io.pivotal.bds.gemfire.fraud.server.dao;

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.data.AccountBalance;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;

public class AccountBalanceDAO extends DefaultDAO<AccountKey, AccountBalance> {

    public AccountBalanceDAO(Region<AccountKey, AccountBalance> region) {
        super(region);
    }

}
