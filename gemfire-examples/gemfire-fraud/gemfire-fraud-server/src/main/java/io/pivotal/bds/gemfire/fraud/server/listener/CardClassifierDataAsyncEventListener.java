package io.pivotal.bds.gemfire.fraud.server.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.asyncqueue.AsyncEvent;
import org.apache.geode.cache.asyncqueue.AsyncEventListener;

import io.pivotal.bds.gemfire.fraud.common.data.CardClassifierData;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;
import io.pivotal.bds.gemfire.fraud.server.dao.CardClassifierDAO;
import smile.classification.RandomForest;

public class CardClassifierDataAsyncEventListener implements AsyncEventListener {

    private CardClassifierDAO cardClassifierDAO;
    private int numberOfTrees;

    private static final Logger LOG = LoggerFactory.getLogger(CardClassifierDataAsyncEventListener.class);

    public CardClassifierDataAsyncEventListener(CardClassifierDAO cardClassifierDAO, int numberOfTrees) {
        this.cardClassifierDAO = cardClassifierDAO;
        this.numberOfTrees = numberOfTrees;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        LOG.debug("processEvents: events.size={}", events.size());

        try {
            for (AsyncEvent event : events) {
                CardKey key = (CardKey) event.getKey();
                CardClassifierData data = (CardClassifierData) event.getDeserializedValue();
                LOG.debug("processEvents: key={}, data={}", key, data);

                int[] y = data.getY();
                double[][] x = data.getX();

                RandomForest rf = new RandomForest(x, y, numberOfTrees);
                cardClassifierDAO.put(key, rf);
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
