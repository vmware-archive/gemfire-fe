package io.pivotal.bds.gemfire.ml.kernel;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.MercerKernelFactory;
import smile.math.kernel.BinarySparseHyperbolicTangentKernel;
import smile.math.kernel.MercerKernel;

public class BinarySparseHyperbolicTangentKernelFactory implements MercerKernelFactory<int[]> {

    @Override
    public MercerKernel<int[]> createKernel(Map<String, Number> properties) {
        Number scale = properties.getOrDefault("scale", 1.0);
        Number offset = properties.getOrDefault("offset", 1.0);
        return new BinarySparseHyperbolicTangentKernel(scale.doubleValue(), offset.doubleValue());
    }

}
