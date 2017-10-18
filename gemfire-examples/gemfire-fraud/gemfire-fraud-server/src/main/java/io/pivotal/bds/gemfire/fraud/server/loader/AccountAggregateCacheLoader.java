package io.pivotal.bds.gemfire.fraud.server.loader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.LoaderHelper;

import io.pivotal.bds.gemfire.fraud.common.data.Account;
import io.pivotal.bds.gemfire.fraud.common.data.AccountAggregate;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionAggregate;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountTransactionXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionAggregateDAO;

public class AccountAggregateCacheLoader implements CacheLoader<AccountKey, AccountAggregate> {

    private AccountDAO accountDAO;
    private AccountTransactionXrefDAO accountTransactionDAO;
    private TransactionAggregateDAO transactionAggregateDAO;
    private static final Logger LOG = LoggerFactory.getLogger(AccountAggregateCacheLoader.class);

    public AccountAggregateCacheLoader(AccountDAO accountDAO, AccountTransactionXrefDAO accountTransactionDAO,
            TransactionAggregateDAO transactionAggregateDAO) {
        this.accountDAO = accountDAO;
        this.accountTransactionDAO = accountTransactionDAO;
        this.transactionAggregateDAO = transactionAggregateDAO;
    }

    @Override
    public AccountAggregate load(LoaderHelper<AccountKey, AccountAggregate> helper) throws CacheLoaderException {
        AccountKey accountKey = helper.getKey();
        LOG.debug("load: accountKey={}", accountKey);

        Account account = accountDAO.retrieve(accountKey);
        Collection<TransactionKey> txnKeys = accountTransactionDAO.retrieve(accountKey);
        List<TransactionAggregate> txnAggrs = new ArrayList<>();

        for (TransactionKey txnKey : txnKeys) {
            TransactionAggregate txnAggr = transactionAggregateDAO.retrieve(txnKey);
            txnAggrs.add(txnAggr);
        }

        AccountAggregate aggr = new AccountAggregate();
        aggr.setAccount(account);
        aggr.setTransactions(txnAggrs);

        LOG.debug("load: accountKey={}, aggr={}", accountKey, aggr);
        return aggr;
    }

    @Override
    public void close() {
    }

}
