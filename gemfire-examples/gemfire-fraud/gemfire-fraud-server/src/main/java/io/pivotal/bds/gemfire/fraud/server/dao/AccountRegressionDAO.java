package io.pivotal.bds.gemfire.fraud.server.dao;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import smile.regression.Regression;

public class AccountRegressionDAO extends DefaultDAO<AccountKey, Regression<double[]>> {

    public AccountRegressionDAO(Region<AccountKey, Regression<double[]>> region) {
        super(region);
    }

}
