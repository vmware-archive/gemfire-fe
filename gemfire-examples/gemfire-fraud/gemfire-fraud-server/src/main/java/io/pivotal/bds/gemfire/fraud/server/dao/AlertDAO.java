package io.pivotal.bds.gemfire.fraud.server.dao;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.dao.DefaultDAO;
import io.pivotal.bds.gemfire.fraud.common.data.Alert;
import io.pivotal.bds.gemfire.fraud.common.key.AlertKey;

public class AlertDAO extends DefaultDAO<AlertKey, Alert> {

    public AlertDAO(Region<AlertKey, Alert> region) {
        super(region);
    }

}
