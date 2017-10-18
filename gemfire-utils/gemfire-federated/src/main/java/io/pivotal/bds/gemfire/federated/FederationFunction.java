package io.pivotal.bds.gemfire.federated;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.Operation;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.FunctionException;
import org.apache.geode.cache.execute.ResultSender;

public class FederationFunction implements Function, Declarable {

	private Cache cache;

	private static final Logger LOG = LoggerFactory.getLogger(FederationFunction.class);

	private static final long serialVersionUID = 1L;

	public FederationFunction() {
	}

	public FederationFunction(Cache cache) {
		this.cache = cache;
	}

	@Override
	public void execute(FunctionContext context) {
		try {
			ResultSender<Object> sender = context.getResultSender();
			Object[] args = (Object[]) context.getArguments();

			Operation op = (Operation) args[0];
			String regionName = (String) args[1];
			Object key = args[2];

			LOG.debug("op={}, regionName={}, key={}", op, regionName, key);

			Region<Object, Object> region = cache.getRegion(regionName);

			if (op.isGet()) {
				Object value = region.get(key);
				LOG.debug("op={}, regionName={}, key={}, value={}", op, regionName, key, value);
				sender.lastResult(value);
			} else if (op.isCreate()) {
				Object value = args[3];
				LOG.debug("op={}, regionName={}, key={}, value={}", op, regionName, key, value);
				Object nv = region.putIfAbsent(key, value);
				LOG.debug("op={}, regionName={}, key={}, value={}, nv={}", op, regionName, key, value, nv);
				sender.lastResult(nv);
			} else if (op.isDestroy()) {
				Object value = region.remove(key);
				LOG.debug("op={}, regionName={}, key={}, value={}", op, regionName, key, value);
				sender.lastResult(value);
			} else if (op.isUpdate()) {
				Object value = args[3];
				LOG.debug("op={}, regionName={}, key={}, value={}", op, regionName, key, value);
				Object nv = region.put(key, value);
				LOG.debug("op={}, regionName={}, key={}, value={}, nv={}", op, regionName, key, value, nv);
				sender.lastResult(nv);
			} else {
				throw new IllegalArgumentException("Cannot handle operation " + op);
			}
		} catch (Exception x) {
			LOG.error(x.toString(), x);
			throw new FunctionException(x.toString(), x);
		}
	}

	@Override
	public String getId() {
		return FederationFunction.class.getSimpleName();
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
		cache = CacheFactory.getAnyInstance();
	}

}
