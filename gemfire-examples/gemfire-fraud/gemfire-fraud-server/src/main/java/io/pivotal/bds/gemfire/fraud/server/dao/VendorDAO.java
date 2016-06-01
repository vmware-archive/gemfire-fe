package io.pivotal.bds.gemfire.fraud.server.dao;

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.data.Vendor;
import io.pivotal.bds.gemfire.fraud.common.key.VendorKey;

public class VendorDAO extends DefaultDAO<VendorKey, Vendor> {

    public VendorDAO(Region<VendorKey, Vendor> region) {
        super(region);
    }

}
