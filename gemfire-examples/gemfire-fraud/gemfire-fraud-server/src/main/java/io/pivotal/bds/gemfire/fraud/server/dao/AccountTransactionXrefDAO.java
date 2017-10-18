package io.pivotal.bds.gemfire.fraud.server.dao;

import java.util.Collection;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;

public class AccountTransactionXrefDAO extends DefaultDAO<AccountKey, Collection<TransactionKey>> {

    public AccountTransactionXrefDAO(Region<AccountKey, Collection<TransactionKey>> region) {
        super(region);
    }

}
