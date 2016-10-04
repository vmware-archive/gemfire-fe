package io.pivotal.bds.gemfire.zeppelin;

import java.util.Iterator;
import java.util.Properties;

import org.apache.zeppelin.interpreter.Interpreter;
import org.apache.zeppelin.interpreter.InterpreterContext;
import org.apache.zeppelin.interpreter.InterpreterResult;
import org.apache.zeppelin.interpreter.InterpreterResult.Code;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.query.Query;
import com.gemstone.gemfire.cache.query.QueryService;
import com.gemstone.gemfire.cache.query.SelectResults;
import com.gemstone.gemfire.cache.query.Struct;

public class GemfireInterpreter extends Interpreter {

    private ClientCache cache;
    private int progress = 0;

    private static final Logger LOG = LoggerFactory.getLogger(GemfireInterpreter.class);

    public GemfireInterpreter(Properties property) {
        super(property);
    }

    @Override
    public void cancel(InterpreterContext ctx) {
    }

    @Override
    public void close() {
        LOG.info("close");
        cache.close();
    }

    @Override
    public FormType getFormType() {
        return FormType.SIMPLE;
    }

    @Override
    public int getProgress(InterpreterContext ctx) {
        return progress;
    }

    @SuppressWarnings("unchecked")
    @Override
    public InterpreterResult interpret(String st, InterpreterContext ctx) {
        LOG.info("interpret: st={}", st);
        progress = 0;
        try {
            QueryService qa = cache.getQueryService();
            Query query = qa.newQuery(st);
            SelectResults<Struct> sr = (SelectResults<Struct>) query.execute();
            Iterator<Struct> iter = sr.iterator();

            StringBuilder buf = new StringBuilder();

            while (iter.hasNext()) {
                Struct str = iter.next();

                Object[] vals = str.getFieldValues();

                for (int i = 0; i < vals.length; ++i) {
                    if (i > 0) {
                        buf.append(' ');
                    }

                    buf.append(vals[i]);
                }

                if (iter.hasNext()) {
                    buf.append('\n');
                }
            }

            String resp = buf.toString();
            LOG.debug("interpret: st={}, resp={}", st, resp);

            return new InterpreterResult(Code.SUCCESS, resp);
        } catch (Exception x) {
            LOG.error("interpret: x={}", x.toString(), x);
            return new InterpreterResult(Code.ERROR, x.getMessage());
        } finally {
            progress = 100;
        }
    }

    @Override
    public void open() {
        Properties props = getProperty();
        LOG.info("open: props={}", props);
        String locatorHost = props.getProperty("locatorHost", "localhost");
        int locatorPort = Integer.parseInt(props.getProperty("locatorPort", "10334"));

        ClientCacheFactory ccf = new ClientCacheFactory();
        ccf.addPoolLocator(locatorHost, locatorPort);
        cache = ccf.create();
    }

}
