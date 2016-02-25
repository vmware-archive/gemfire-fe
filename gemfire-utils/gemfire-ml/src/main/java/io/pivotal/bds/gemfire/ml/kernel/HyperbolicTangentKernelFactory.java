package io.pivotal.bds.gemfire.ml.kernel;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.MercerKernelFactory;
import smile.math.kernel.HyperbolicTangentKernel;
import smile.math.kernel.MercerKernel;

public class HyperbolicTangentKernelFactory implements MercerKernelFactory<double[]> {

    @Override
    public MercerKernel<double[]> createKernel(Map<String, Number> properties) {
        Number scale = properties.getOrDefault("scale", 1.0);
        Number offset = properties.getOrDefault("offset", 1.0);
        return new HyperbolicTangentKernel(scale.doubleValue(), offset.doubleValue());
    }

}
