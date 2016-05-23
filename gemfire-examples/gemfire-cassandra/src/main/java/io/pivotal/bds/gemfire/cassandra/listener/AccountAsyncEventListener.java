package io.pivotal.bds.gemfire.cassandra.listener;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.mapping.Mapper;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEvent;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEventListener;

import io.pivotal.bds.gemfire.cassandra.data.Account;
import io.pivotal.bds.gemfire.cassandra.util.Utils;

public class AccountAsyncEventListener implements AsyncEventListener, Declarable {

    private Mapper<Account> mapper;

    private static final Logger LOG = LoggerFactory.getLogger(AccountAsyncEventListener.class);

    @SuppressWarnings("rawtypes")
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        LOG.info("processEvents: events.size={}", events.size());

        try {
            for (AsyncEvent event : events) {
                LOG.info("processEvents: event={}", event);

                Operation op = event.getOperation();
                Account acct = (Account) event.getDeserializedValue();

                if ((op.isCreate() || op.isUpdate()) && !op.isLoad()) {
                    LOG.info("processEvents: save: acct={}", acct);
                    mapper.save(acct);
                } else if (op.isDestroy() && !op.isEviction() && !op.isExpiration()) {
                    LOG.info("processEvents: delete: acct={}", acct);
                    mapper.delete(acct);
                }
            }
        } catch (Exception x) {
            LOG.error("processEvents: x={}", x.toString(), x);
        }

        return true;
    }

    @Override
    public void init(Properties props) {
        LOG.info("init");
        mapper = Utils.getMapper(Account.class);
    }

    @Override
    public void close() {
    }

}
