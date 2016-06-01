package io.pivotal.bds.gemfire.fraud.server.loader;

import java.util.Collection;
import java.util.HashSet;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.mapping.Mapper;

import io.pivotal.bds.gemfire.fraud.common.data.Transaction;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;

public class CardTransactionXrefCacheLoader extends AbstractCassandraXrefCacheLoader<CardKey, TransactionKey, Transaction> {

    private static final String query = "select transaction_id from transaction where card_id=?";
    
    public CardTransactionXrefCacheLoader(Mapper<Transaction> mapper) {
        super(mapper);
    }

    @Override
    protected Collection<TransactionKey> load(CardKey key) {
        Collection<TransactionKey> coll = new HashSet<>();

        String cardId = key.getId();
        String acctId = key.getColocationId();
        LOG.debug("load: cardId={}, acctId={}", cardId, acctId);
        
        ResultSet res = session.execute(query, cardId);

        for (Row row : res) {
            String txnId = row.getString("transaction_id");
            LOG.debug("load: cardId={}, txnId={}", cardId, txnId);
            TransactionKey txnKey = new TransactionKey(txnId, acctId);
            coll.add(txnKey);
        }

        return coll;
    }

}
