package io.pivotal.bds.gemfire.fraud.server.dao;

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.data.AccountAggregate;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;

public class AccountAggregateDAO extends DefaultDAO<AccountKey, AccountAggregate> {

    public AccountAggregateDAO(Region<AccountKey, AccountAggregate> region) {
        super(region);
    }

}
