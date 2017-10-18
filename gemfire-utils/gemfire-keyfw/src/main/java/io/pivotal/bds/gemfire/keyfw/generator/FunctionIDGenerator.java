package io.pivotal.bds.gemfire.keyfw.generator;

import java.util.List;

import org.apache.geode.cache.client.Pool;
import org.apache.geode.cache.execute.FunctionService;
import org.apache.geode.cache.execute.ResultCollector;

public class FunctionIDGenerator<T> implements IDGenerator<T> {

	private Pool pool;

	public FunctionIDGenerator(Pool pool) {
		this.pool = pool;
	}

	@Override
	public T generate(String domain) {
		ResultCollector<?, ?> coll = FunctionService.onServer(pool).withArgs(domain)
				.execute(BaseGenerateIDFunction.class.getSimpleName());
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) coll.getResult();
		return list.get(0);
	}

}
