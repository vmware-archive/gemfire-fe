package io.pivotal.bds.gemfire.fraud.common.key;

import io.pivotal.bds.gemfire.keyfw.BaseDSKey;

@SuppressWarnings("serial")
public class VendorKey extends BaseDSKey<String> {

    public VendorKey() {
    }

    public VendorKey(String id) {
        super(id);
    }

}
