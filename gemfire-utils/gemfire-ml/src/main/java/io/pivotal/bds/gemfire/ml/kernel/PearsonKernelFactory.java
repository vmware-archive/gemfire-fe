package io.pivotal.bds.gemfire.ml.kernel;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.MercerKernelFactory;
import smile.math.kernel.PearsonKernel;
import smile.math.kernel.MercerKernel;

public class PearsonKernelFactory implements MercerKernelFactory<double[]> {

    @Override
    public MercerKernel<double[]> createKernel(Map<String, Number> properties) {
        Number omega = properties.getOrDefault("omega", 1.0);
        Number sigma = properties.getOrDefault("sigma", 1.0);
        return new PearsonKernel(omega.doubleValue(), sigma.doubleValue());
    }

}
