package io.pivotal.bds.gemfire.geo.data;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public class PointOfInterestKey extends BaseColocationKey<Long, Long> {

    public PointOfInterestKey() {
    }

    public PointOfInterestKey(Long id, Long colocationId) {
        super(id, colocationId);
    }

}
