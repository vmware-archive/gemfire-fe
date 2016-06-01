package io.pivotal.bds.gemfire.fraud.server.dao;

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import smile.classification.Classifier;

public class AccountClassifierDAO extends DefaultDAO<AccountKey, Classifier<double[]>> {

    public AccountClassifierDAO(Region<AccountKey, Classifier<double[]>> region) {
        super(region);
    }

}
