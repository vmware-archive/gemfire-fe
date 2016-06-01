package io.pivotal.bds.gemfire.fraud.server.dao;

import java.util.Collection;

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionHistoryKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;

public class TransactionHistoryXrefDAO extends DefaultDAO<TransactionKey, Collection<TransactionHistoryKey>> {

    public TransactionHistoryXrefDAO(Region<TransactionKey, Collection<TransactionHistoryKey>> region) {
        super(region);
    }

}
