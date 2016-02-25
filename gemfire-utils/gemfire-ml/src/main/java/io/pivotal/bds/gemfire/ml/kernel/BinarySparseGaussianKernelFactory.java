package io.pivotal.bds.gemfire.ml.kernel;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.MercerKernelFactory;
import smile.math.kernel.BinarySparseGaussianKernel;
import smile.math.kernel.MercerKernel;

public class BinarySparseGaussianKernelFactory implements MercerKernelFactory<int[]> {

    @Override
    public MercerKernel<int[]> createKernel(Map<String, Number> properties) {
        Number sigma = properties.getOrDefault("sigma",1.0);
        return new BinarySparseGaussianKernel(sigma.doubleValue());
    }

}
