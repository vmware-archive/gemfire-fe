package io.pivotal.bds.gemfire.keyfw.generator;

import java.util.List;

import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.cache.execute.ResultCollector;

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
