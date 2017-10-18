package io.pivotal.bds.gemfire.federated;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.cache.client.PoolManager;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.FunctionException;
import org.apache.geode.cache.execute.FunctionService;
import org.apache.geode.cache.execute.ResultCollector;
import org.apache.geode.cache.execute.ResultSender;

public class BridgeFunction implements Function, Declarable {

	private Pool pool;

	private static final Logger LOG = LoggerFactory.getLogger(BridgeFunction.class);

	private static final long serialVersionUID = 1L;

	public BridgeFunction() {
	}

	public BridgeFunction(Pool pool) {
		this.pool = pool;
	}

	@Override
	public void execute(FunctionContext context) {
		try {
			ResultSender<Object> sender = context.getResultSender();
			Object[] args = (Object[]) context.getArguments();

			if (LOG.isDebugEnabled()) {
				LOG.debug("args={}", Arrays.toString(args));
			}

			Object value = execute(args);
			sender.lastResult(value);
		} catch (Exception x) {
			LOG.error(x.toString(), x);
			throw new FunctionException(x.toString(), x);
		}
	}

	@Override
	public String getId() {
		return BridgeFunction.class.getSimpleName();
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
	public void init(Properties props) {
		String poolName = System.getProperty("gemfire.utils.bridge.pool-name", "federatedPool");
		poolName = props.getProperty("poolName", poolName);
		LOG.info("init: poolName={}", poolName);
		pool = PoolManager.find(poolName);
	}

	private Object execute(Object[] args) {
		ResultCollector<?, ?> coll = FunctionService.onServer(pool).withArgs(args)
				.execute(FederationFunction.class.getSimpleName());
		@SuppressWarnings("unchecked")
		List<Object> list = (List<Object>) coll.getResult();
		return list != null && !list.isEmpty() ? list.get(0) : null;
	}
}
