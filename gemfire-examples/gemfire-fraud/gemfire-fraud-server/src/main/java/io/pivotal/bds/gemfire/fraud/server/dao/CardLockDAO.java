package io.pivotal.bds.gemfire.fraud.server.dao;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;

public class CardLockDAO extends DefaultDAO<CardKey, ReentrantReadWriteLock> {

    public CardLockDAO(Region<CardKey, ReentrantReadWriteLock> region) {
        super(region);
    }

}
