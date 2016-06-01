package io.pivotal.bds.gemfire.fraud.server.dao;

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionAggregate;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;

public class TransactionAggregateDAO extends DefaultDAO<TransactionKey, TransactionAggregate> {

    public TransactionAggregateDAO(Region<TransactionKey, TransactionAggregate> region) {
        super(region);
    }

}
