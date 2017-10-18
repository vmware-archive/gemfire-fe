package io.pivotal.bds.gemfire.fraud.server.dao;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionStatus;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;

public class TransactionStatusDAO extends DefaultDAO<TransactionKey, TransactionStatus> {

    public TransactionStatusDAO(Region<TransactionKey, TransactionStatus> region) {
        super(region);
    }

}
