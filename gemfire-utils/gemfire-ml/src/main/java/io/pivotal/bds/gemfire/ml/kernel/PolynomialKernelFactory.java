package io.pivotal.bds.gemfire.ml.kernel;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.MercerKernelFactory;
import smile.math.kernel.PolynomialKernel;
import smile.math.kernel.MercerKernel;

public class PolynomialKernelFactory implements MercerKernelFactory<double[]> {

    @Override
    public MercerKernel<double[]> createKernel(Map<String, Number> properties) {
        Number degree = properties.getOrDefault("degree", 1);
        Number scale = properties.getOrDefault("scale", 1.0);
        Number offset = properties.getOrDefault("offset", 1.0);
        return new PolynomialKernel(degree.intValue(), scale.doubleValue(), offset.doubleValue());
    }

}
