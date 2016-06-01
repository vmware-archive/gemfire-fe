package io.pivotal.bds.gemfire.fraud.server.dao;

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.data.Account;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;

public class AccountDAO extends DefaultDAO<AccountKey, Account> {

    public AccountDAO(Region<AccountKey, Account> region) {
        super(region);
    }

}
