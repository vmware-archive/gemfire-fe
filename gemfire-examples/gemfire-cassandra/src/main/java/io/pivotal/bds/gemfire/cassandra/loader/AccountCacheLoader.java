package io.pivotal.bds.gemfire.cassandra.loader;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.mapping.Mapper;
import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.LoaderHelper;

import io.pivotal.bds.gemfire.cassandra.data.Account;
import io.pivotal.bds.gemfire.cassandra.key.AccountKey;
import io.pivotal.bds.gemfire.cassandra.util.Utils;

public class AccountCacheLoader implements CacheLoader<AccountKey, Account>, Declarable {

    private Mapper<Account> mapper;
    private static final Logger LOG = LoggerFactory.getLogger(AccountCacheLoader.class);

    @Override
    public Account load(LoaderHelper<AccountKey, Account> helper) throws CacheLoaderException {
        AccountKey key = helper.getKey();
        String id = key.getId();
        LOG.info("load: key={}", key);
        Account acct = mapper.get(id);
        LOG.info("load: key={}, acct={}", key, acct);
        return acct;
    }

    @Override
    public void init(Properties props) {
        LOG.info("init");
        mapper = Utils.getMapper(Account.class);
    }

    @Override
    public void close() {
    }

}
