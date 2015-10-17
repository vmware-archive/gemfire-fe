package io.pivotal.bds.gemfire.keyfw.generator;

public class DefaultGenerateIDFunction<T> extends BaseGenerateIDFunction<T> {

	private IDGenerator<T> generator;

	private static final long serialVersionUID = 1L;

	public DefaultGenerateIDFunction(IDGenerator<T> generator) {
		this.generator = generator;
	}

	public DefaultGenerateIDFunction(String id, IDGenerator<T> generator) {
		super(id);
		this.generator = generator;
	}

	protected IDGenerator<T> getGenerator() {
		return generator;
	}
}
