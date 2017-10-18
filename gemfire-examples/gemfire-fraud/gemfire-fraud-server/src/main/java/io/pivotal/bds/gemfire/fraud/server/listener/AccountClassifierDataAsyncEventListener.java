package io.pivotal.bds.gemfire.fraud.server.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.asyncqueue.AsyncEvent;
import org.apache.geode.cache.asyncqueue.AsyncEventListener;

import io.pivotal.bds.gemfire.fraud.common.data.AccountClassifierData;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountClassifierDAO;
import smile.classification.RandomForest;

public class AccountClassifierDataAsyncEventListener implements AsyncEventListener {

    private AccountClassifierDAO accountClassifierDAO;
    private int numberOfTrees;

    private static final Logger LOG = LoggerFactory.getLogger(AccountClassifierDataAsyncEventListener.class);

    public AccountClassifierDataAsyncEventListener(AccountClassifierDAO accountClassifierDAO, int numberOfTrees) {
        this.accountClassifierDAO = accountClassifierDAO;
        this.numberOfTrees = numberOfTrees;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        LOG.debug("processEvents: events.size={}", events.size());

        try {
            for (AsyncEvent event : events) {
                AccountKey key = (AccountKey) event.getKey();
                AccountClassifierData data = (AccountClassifierData) event.getDeserializedValue();
                LOG.debug("processEvents: key={}, data={}", key, data);

                int[] y = data.getY();
                double[][] x = data.getX();

                RandomForest rf = new RandomForest(x, y, numberOfTrees);
                accountClassifierDAO.put(key, rf);
            }

            return true;
        } catch (Exception x) {
            LOG.error("processEvents: x={}", x.toString(), x);
        }

        return false;
    }

    @Override
    public void close() {
    }

}
