package io.pivotal.bds.gemfire.localregion.loader;

import java.util.Properties;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;

import io.pivotal.bds.gemfire.data.ecom.Account;
import io.pivotal.bds.gemfire.data.ecom.AccountKey;
import io.pivotal.bds.gemfire.localregion.data.AccountAggregate;
import io.pivotal.bds.gemfire.util.DSLockingHashMap;

public class AggregateCacheLoader implements CacheLoader<AccountKey, AccountAggregate>, Declarable {

    @Override
    public AccountAggregate load(LoaderHelper<AccountKey, AccountAggregate> helper) throws CacheLoaderException {
        Account account = (Account) helper.getArgument();
        AccountAggregate aggr = new AccountAggregate(account, new DSLockingHashMap<>());
        return aggr;
    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public void close() {
    }

}
