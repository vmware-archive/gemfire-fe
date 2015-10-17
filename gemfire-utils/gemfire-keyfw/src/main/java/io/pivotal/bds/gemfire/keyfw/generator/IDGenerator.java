package io.pivotal.bds.gemfire.keyfw.generator;

public interface IDGenerator<T> {

	T generate(String domain);
}
