package io.pivotal.bds.gemfire.fraud.server.dao;

import java.util.Collection;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;

public class CardTransactionXrefDAO extends DefaultDAO<CardKey, Collection<TransactionKey>> {

    public CardTransactionXrefDAO(Region<CardKey, Collection<TransactionKey>> region) {
        super(region);
    }

}
