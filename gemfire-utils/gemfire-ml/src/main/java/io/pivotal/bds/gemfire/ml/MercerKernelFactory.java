package io.pivotal.bds.gemfire.ml;

import java.util.Map;

import smile.math.kernel.MercerKernel;

public interface MercerKernelFactory<T> {

    MercerKernel<T> createKernel(Map<String, Number> properties);
}
