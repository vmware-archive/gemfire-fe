package io.pivotal.bds.gemfire.data.ecom;

import io.pivotal.bds.gemfire.key.BaseKey;

public class CatalogItemKey extends BaseKey<Long> {

    public CatalogItemKey() {
    }

    public CatalogItemKey(Long id) {
        super(id);
    }

}
