package io.pivotal.bds.gemfire.fraud.server.loader;

import java.util.Collection;
import java.util.HashSet;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.mapping.Mapper;

import io.pivotal.bds.gemfire.fraud.common.data.TransactionHistory;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionHistoryKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;

public class TransactionHistoryXrefCacheLoader
        extends AbstractCassandraXrefCacheLoader<TransactionKey, TransactionHistoryKey, TransactionHistory> {

    private static final String query = "select transaction_history_id from transaction_history where transaction_id=?";
    
    public TransactionHistoryXrefCacheLoader(Mapper<TransactionHistory> mapper) {
        super(mapper);
    }

    @Override
    protected Collection<TransactionHistoryKey> load(TransactionKey key) {
        Collection<TransactionHistoryKey> coll = new HashSet<>();

        String txnId = key.getId();
        LOG.debug("load: txnId={}", txnId);
        ResultSet res = session.execute(query, txnId);

        for (Row row : res) {
            String txnHistId = row.getString("transaction_history_id");
            LOG.debug("load: txnHistId={}, txnId={}", txnHistId, txnId);
            TransactionHistoryKey txnHistKey = new TransactionHistoryKey(txnHistId, txnId);
            coll.add(txnHistKey);
        }

        return coll;
    }

}
