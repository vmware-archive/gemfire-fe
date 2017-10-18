package io.pivotal.bds.gemfire.fraud.server.dao;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.key.VendorKey;
import smile.classification.Classifier;

public class VendorClassifierDAO extends DefaultDAO<VendorKey, Classifier<double[]>> {

    public VendorClassifierDAO(Region<VendorKey, Classifier<double[]>> region) {
        super(region);
    }

}
