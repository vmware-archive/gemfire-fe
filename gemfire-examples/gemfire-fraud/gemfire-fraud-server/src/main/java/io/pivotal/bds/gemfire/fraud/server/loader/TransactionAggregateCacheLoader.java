package io.pivotal.bds.gemfire.fraud.server.loader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.LoaderHelper;

import io.pivotal.bds.gemfire.fraud.common.data.Transaction;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionAggregate;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionHistory;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionHistoryKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionHistoryDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionHistoryXrefDAO;

public class TransactionAggregateCacheLoader implements CacheLoader<TransactionKey, TransactionAggregate> {

    private TransactionHistoryXrefDAO transactionHistoryXrefDAO;
    private TransactionHistoryDAO transactionHistoryDAO;
    private TransactionDAO transactionDAO;

    private static final Logger LOG = LoggerFactory.getLogger(TransactionAggregateCacheLoader.class);

    public TransactionAggregateCacheLoader(TransactionHistoryXrefDAO transactionHistoryXrefDAO,
            TransactionHistoryDAO transactionHistoryDAO, TransactionDAO transactionDAO) {
        this.transactionHistoryXrefDAO = transactionHistoryXrefDAO;
        this.transactionHistoryDAO = transactionHistoryDAO;
        this.transactionDAO = transactionDAO;
    }

    @Override
    public TransactionAggregate load(LoaderHelper<TransactionKey, TransactionAggregate> helper) throws CacheLoaderException {
        TransactionKey txnKey = helper.getKey();
        LOG.debug("load: txnKey={}", txnKey);

        Transaction txn = transactionDAO.retrieve(txnKey);

        Collection<TransactionHistoryKey> txnHistKeys = transactionHistoryXrefDAO.retrieve(txnKey);
        List<TransactionHistory> txnHists = new ArrayList<>();

        for (TransactionHistoryKey txnHistKey : txnHistKeys) {
            TransactionHistory txnHist = transactionHistoryDAO.retrieve(txnHistKey);
            txnHists.add(txnHist);
        }

        TransactionAggregate txnAggr = new TransactionAggregate();
        txnAggr.setTransaction(txn);
        txnAggr.setTransactionHistory(txnHists);

        LOG.debug("load: txnKey={}, txnAggr={}", txnKey, txnAggr);
        return txnAggr;
    }

    @Override
    public void close() {
    }

}
