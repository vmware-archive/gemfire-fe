package io.pivotal.bds.gemfire.fraud.server.dao;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.data.Transaction;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;

public class TransactionDAO extends DefaultDAO<TransactionKey, Transaction> {

    public TransactionDAO(Region<TransactionKey, Transaction> region) {
        super(region);
    }

}
