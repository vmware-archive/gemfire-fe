package io.pivotal.bds.gemfire.localregion.loader;

import java.util.Properties;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;

import io.pivotal.bds.gemfire.data.ecom.AccountKey;
import io.pivotal.bds.gemfire.localregion.data.OrderAccumulator;
import io.pivotal.bds.gemfire.localregion.data.OrderTotals;

public class AccumulatorCacheLoader implements CacheLoader<AccountKey, OrderAccumulator>, Declarable {

    @Override
    public OrderAccumulator load(LoaderHelper<AccountKey, OrderAccumulator> helper) throws CacheLoaderException {
        return new OrderAccumulator(new OrderTotals(0, 0.0));
    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public void close() {
    }

}
