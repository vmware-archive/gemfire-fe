package io.pivotal.bds.gemfire.drools.server.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.Globals;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.gemstone.gemfire.cache.execute.Function;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.cache.execute.FunctionException;
import com.gemstone.gemfire.cache.execute.RegionFunctionContext;
import com.gemstone.gemfire.cache.execute.ResultSender;

import io.pivotal.bds.gemfire.drools.common.RuleExecutionContext;
import io.pivotal.bds.gemfire.drools.common.RuleExecutionResult;
import io.pivotal.bds.gemfire.drools.server.util.ApplicationContextGlobals;
import io.pivotal.bds.metrics.timer.Timer;

public class StatefulRuleExecutionFunction implements Function, ApplicationContextAware {

    private ApplicationContext context;
    private KieServices services;
    private Timer timer = new Timer(StatefulRuleExecutionFunction.class.getName());

    private static final Logger LOG = LoggerFactory.getLogger(StatefulRuleExecutionFunction.class);

    private static final long serialVersionUID = 1L;

    public StatefulRuleExecutionFunction(KieServices services) {
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

            LOG.debug("execute: args={}, relId={}, filter={}", args, relId, filter);

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

        KieContainer container = services.newKieContainer(relId);
        KieSession session = container.newKieSession();

        try {
            Globals globals = session.getGlobals();
            globals.set("log", LOG);
            globals.setDelegate(new ApplicationContextGlobals(this.context));

            if (filterArg != null) {
                session.insert(filterArg);
            }

            if (args != null) {
                session.insert(args);
            }

            RuleExecutionResult result = new RuleExecutionResult(new ArrayList<>(), new HashMap<>());
            session.insert(result);

            int ruleCount = session.fireAllRules();
            LOG.debug("execute: relId={}, filterArg={}, args={}, ruleCount={}, result={}", relId, filterArg, args, ruleCount,
                    result);

            if (hasMore) {
                sender.sendResult(result);
            } else {
                sender.lastResult(result);
            }
        } finally {
            session.dispose();
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
