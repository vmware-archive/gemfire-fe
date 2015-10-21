package io.pivotal.bds.gemfire.groovy.client.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.cache.execute.FunctionService;

import io.pivotal.bds.gemfire.groovy.common.Constants;
import io.pivotal.bds.gemfire.groovy.data.ScriptExecutionContext;
import io.pivotal.bds.metrics.rater.Rater;
import io.pivotal.bds.metrics.timer.Timer;

@Component
public class TradeHandler implements Constants {

    @Autowired
    private Pool pool;

    private Timer timer = new Timer("TradeHandler-Timer");
    private Rater rater = new Rater("TradeHandler-Rater");

    private static final Logger LOG = LoggerFactory.getLogger(TradeHandler.class);

    public void handle(String trade) {
        LOG.debug("handle: trade={}", trade);

        timer.start();

        ScriptExecutionContext ctx = new ScriptExecutionContext("io/pivotal/bds/gemfire/groovy/trade.groovy", trade);
        FunctionService.onServer(pool).withArgs(ctx).execute(FUNCTION_ID).getResult();

        timer.end();
        rater.increment();
    }
}
