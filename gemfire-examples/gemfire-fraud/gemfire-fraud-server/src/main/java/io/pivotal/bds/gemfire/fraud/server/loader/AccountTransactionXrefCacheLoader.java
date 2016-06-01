package io.pivotal.bds.gemfire.fraud.server.loader;

import java.util.Collection;
import java.util.HashSet;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.mapping.Mapper;

import io.pivotal.bds.gemfire.fraud.common.data.Transaction;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;

public class AccountTransactionXrefCacheLoader extends AbstractCassandraXrefCacheLoader<AccountKey, TransactionKey, Transaction> {

    private static final String query = "select transaction_id from transaction where account_id=?";

    public AccountTransactionXrefCacheLoader(Mapper<Transaction> mapper) {
        super(mapper);
    }

    @Override
    protected Collection<TransactionKey> load(AccountKey key) {
        Collection<TransactionKey> coll = new HashSet<>();

        String acctId = key.getId();
        LOG.debug("load: acctId={}", acctId);
        ResultSet res = session.execute(query, acctId);

        for (Row row : res) {
            String txnId = row.getString("transaction_id");
            LOG.debug("load: acctId={}, txnId={}", acctId, txnId);
            TransactionKey txnKey = new TransactionKey(txnId, acctId);
            coll.add(txnKey);
        }

        return coll;
    }

}
