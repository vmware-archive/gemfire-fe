package io.pivotal.bds.gemfire.fraud.server.loader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.LoaderHelper;

import io.pivotal.bds.gemfire.fraud.common.data.Card;
import io.pivotal.bds.gemfire.fraud.common.data.CardAggregate;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionAggregate;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;
import io.pivotal.bds.gemfire.fraud.server.dao.CardDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardTransactionXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionAggregateDAO;

public class CardAggregateCacheLoader implements CacheLoader<CardKey, CardAggregate> {

    private CardDAO cardDAO;
    private CardTransactionXrefDAO cardTransactionXrefDAO;
    private TransactionAggregateDAO transactionAggregateDAO;

    private static final Logger LOG = LoggerFactory.getLogger(CardAggregateCacheLoader.class);

    public CardAggregateCacheLoader(CardDAO cardDAO, CardTransactionXrefDAO cardTransactionXrefDAO,
            TransactionAggregateDAO transactionAggregateDAO) {
        this.cardDAO = cardDAO;
        this.cardTransactionXrefDAO = cardTransactionXrefDAO;
        this.transactionAggregateDAO = transactionAggregateDAO;
    }

    @Override
    public CardAggregate load(LoaderHelper<CardKey, CardAggregate> helper) throws CacheLoaderException {
        CardKey cardKey = helper.getKey();
        LOG.debug("load: cardKey={}", cardKey);

        Card card = cardDAO.retrieve(cardKey);
        Collection<TransactionKey> txnKeys = cardTransactionXrefDAO.retrieve(cardKey);
        List<TransactionAggregate> txnAggrs = new ArrayList<>();

        for (TransactionKey txnKey : txnKeys) {
            TransactionAggregate txnAggr = transactionAggregateDAO.retrieve(txnKey);
            txnAggrs.add(txnAggr);
        }

        CardAggregate aggr = new CardAggregate();

        aggr.setCard(card);
        aggr.setTransactions(txnAggrs);

        LOG.debug("load: cardKey={}, aggr={}", cardKey, aggr);
        return aggr;
    }

    @Override
    public void close() {
    }

}
