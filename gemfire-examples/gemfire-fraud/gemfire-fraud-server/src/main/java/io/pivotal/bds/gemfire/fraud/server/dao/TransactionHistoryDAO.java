package io.pivotal.bds.gemfire.fraud.server.dao;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionHistory;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionHistoryKey;

public class TransactionHistoryDAO extends DefaultDAO<TransactionHistoryKey, TransactionHistory> {

    public TransactionHistoryDAO(Region<TransactionHistoryKey, TransactionHistory> region) {
        super(region);
    }

}
