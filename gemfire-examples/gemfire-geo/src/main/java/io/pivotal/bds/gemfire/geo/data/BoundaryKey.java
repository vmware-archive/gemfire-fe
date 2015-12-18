package io.pivotal.bds.gemfire.geo.data;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public class BoundaryKey extends BaseColocationKey<Long, Long> {

    public BoundaryKey() {
    }

    public BoundaryKey(Long id, Long colocationId) {
        super(id, colocationId);
    }

}
