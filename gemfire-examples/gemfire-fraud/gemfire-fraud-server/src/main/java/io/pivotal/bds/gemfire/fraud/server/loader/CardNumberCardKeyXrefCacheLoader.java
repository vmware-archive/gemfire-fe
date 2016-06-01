package io.pivotal.bds.gemfire.fraud.server.loader;

import java.util.Iterator;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;

import io.pivotal.bds.gemfire.fraud.common.key.CardKey;

public class CardNumberCardKeyXrefCacheLoader implements CacheLoader<String, CardKey>, Declarable {

    private Session session;
    private static final String sql = "select card_id,account_id from card where card_number=?";
    private static final Logger LOG = LoggerFactory.getLogger(CardNumberCardKeyXrefCacheLoader.class);

    public CardNumberCardKeyXrefCacheLoader(Session session) {
        this.session = session;
    }

    @Override
    public CardKey load(LoaderHelper<String, CardKey> helper) throws CacheLoaderException {
        String cardNumber = helper.getKey();
        LOG.debug("load: cardNumber={}", cardNumber);

        ResultSet res = session.execute(sql, cardNumber);
        Iterator<Row> iter = res.iterator();

        if (iter.hasNext()) {
            Row row = iter.next();

            if (iter.hasNext()) {
                throw new CacheLoaderException("More than one row found for card number " + cardNumber);
            }

            String cardId = row.getString("card_id");
            String acctId = row.getString("account_id");
            LOG.debug("load: cardNumber={}, cardId={}, acctId={}", cardNumber, cardId, acctId);
            CardKey cardKey = new CardKey(cardId, acctId);
            return cardKey;
        }

        LOG.debug("load: card not found for cardNumber={}", cardNumber);
        return null;
    }

    @Override
    public void close() {
    }

    @Override
    public void init(Properties props) {
    }

}
