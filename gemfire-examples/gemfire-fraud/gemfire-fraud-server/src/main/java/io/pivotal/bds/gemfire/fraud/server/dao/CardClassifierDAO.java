package io.pivotal.bds.gemfire.fraud.server.dao;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;
import smile.classification.Classifier;

public class CardClassifierDAO extends DefaultDAO<CardKey, Classifier<double[]>> {

    public CardClassifierDAO(Region<CardKey, Classifier<double[]>> region) {
        super(region);
    }

}
