package io.pivotal.bds.gemfire.fraud.server.loader;

import java.util.Iterator;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.LoaderHelper;

import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;

public class CardNumberAccountKeyXrefCacheLoader implements CacheLoader<String, AccountKey>, Declarable {

    private Session session;
    private static final String sql = "select account_id from card where card_number=?";
    private static final Logger LOG = LoggerFactory.getLogger(CardNumberAccountKeyXrefCacheLoader.class);

    public CardNumberAccountKeyXrefCacheLoader(Session session) {
        this.session = session;
    }

    @Override
    public AccountKey load(LoaderHelper<String, AccountKey> helper) throws CacheLoaderException {
        String cardNumber = helper.getKey();
        LOG.debug("load: cardNumber={}", cardNumber);

        ResultSet res = session.execute(sql, cardNumber);
        Iterator<Row> iter = res.iterator();

        if (iter.hasNext()) {
            Row row = iter.next();

            if (iter.hasNext()) {
                throw new CacheLoaderException("More than one row found for card number " + cardNumber);
            }

            String acctId = row.getString("account_id");
            LOG.debug("load: cardNumber={}, acctId={}", cardNumber, acctId);
            AccountKey acctKey = new AccountKey(acctId);
            return acctKey;
        }

        LOG.debug("load: account not found for cardNumber={}", cardNumber);
        return null;
    }

    @Override
    public void close() {
    }

    @Override
    public void init(Properties props) {
    }

}
