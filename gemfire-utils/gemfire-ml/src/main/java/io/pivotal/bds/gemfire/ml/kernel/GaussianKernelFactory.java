package io.pivotal.bds.gemfire.ml.kernel;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.MercerKernelFactory;
import smile.math.kernel.GaussianKernel;
import smile.math.kernel.MercerKernel;

public class GaussianKernelFactory implements MercerKernelFactory<double[]> {

    @Override
    public MercerKernel<double[]> createKernel(Map<String, Number> properties) {
        Number sigma = properties.getOrDefault("sigma",1.0);
        return new GaussianKernel(sigma.doubleValue());
    }

}
