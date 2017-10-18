package io.pivotal.bds.gemfire.drools.server.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.Globals;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.FunctionException;
import org.apache.geode.cache.execute.RegionFunctionContext;
import org.apache.geode.cache.execute.ResultSender;

import io.pivotal.bds.gemfire.drools.common.RuleExecutionContext;
import io.pivotal.bds.gemfire.drools.common.RuleExecutionResult;
import io.pivotal.bds.gemfire.drools.server.util.ApplicationContextGlobals;
import io.pivotal.bds.metrics.rater.Rater;
import io.pivotal.bds.metrics.timer.Timer;

public class StatelessRuleExecutionFunction implements Function, ApplicationContextAware {

    private ApplicationContext context;
    private KieServices services;
    private Timer timer = new Timer(StatelessRuleExecutionFunction.class.getSimpleName() + "-Timer");
    private Rater rater = new Rater(StatelessRuleExecutionFunction.class.getSimpleName() + "-Rater");

    private static final Logger LOG = LoggerFactory.getLogger(StatelessRuleExecutionFunction.class);

    private static final long serialVersionUID = 1L;

    public StatelessRuleExecutionFunction(KieServices services) {
        this.services = services;
    }

    @Override
    public void execute(FunctionContext context) {
        try {
            ResultSender<RuleExecutionResult> sender = context.getResultSender();
            RuleExecutionContext rec = (RuleExecutionContext) context.getArguments();

            ReleaseId relId = rec.getReleaseId();
            Object args = rec.getArguments();
            Set<?> filter = null;

            if (context instanceof RegionFunctionContext) {
                RegionFunctionContext rctx = (RegionFunctionContext) context;
                filter = rctx.getFilter();
            }

            LOG.debug("execute: relId={}, args={}, filter={}", relId, args, filter);

            timer.start();
            if (filter == null) {
                execute(relId, null, args, sender, false);
            } else {
                Iterator<?> iter = filter.iterator();

                while (iter.hasNext()) {
                    Object filterArg = iter.next();
                    execute(relId, filterArg, args, sender, iter.hasNext());
                }
            }
            timer.end();
            rater.increment();
        } catch (FunctionException x) {
            LOG.error("execute: x={}", x.toString(), x);
            throw x;
        } catch (Exception x) {
            LOG.error("execute: x={}", x.toString(), x);
            throw new FunctionException(x.toString(), x);
        }
    }

    private void execute(ReleaseId relId, Object filterArg, Object args, ResultSender<RuleExecutionResult> sender, boolean hasMore)
            throws Exception {
        LOG.debug("execute: relId={}, filterArg={}, args={}", relId, filterArg, args);

        Set<Object> data = new HashSet<>();

        if (filterArg != null) {
            data.add(filterArg);
        }

        if (args != null) {
            data.add(args);
        }

        RuleExecutionResult result = new RuleExecutionResult(new ArrayList<>(), new HashMap<>());
        data.add(result);

        KieContainer container = services.newKieContainer(relId);
        StatelessKieSession session = container.newStatelessKieSession();

        Globals globals = session.getGlobals();
        globals.set("log", LOG);
        globals.setDelegate(new ApplicationContextGlobals(this.context));

        session.execute(data);

        LOG.debug("execute: relId={}, filterArg={}, args={}, result={}", relId, filterArg, args, result);
        if (hasMore) {
            sender.sendResult(result);
        } else {
            sender.lastResult(result);
        }
    }

    @Override
    public String getId() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean hasResult() {
        return true;
    }

    @Override
    public boolean isHA() {
        return true;
    }

    @Override
    public boolean optimizeForWrite() {
        return true;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        LOG.info("setApplicationContext");
        this.context = context;
    }

}
