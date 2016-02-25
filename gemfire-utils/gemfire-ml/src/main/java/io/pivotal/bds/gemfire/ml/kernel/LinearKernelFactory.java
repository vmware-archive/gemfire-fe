package io.pivotal.bds.gemfire.ml.kernel;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.MercerKernelFactory;
import smile.math.kernel.LinearKernel;
import smile.math.kernel.MercerKernel;

public class LinearKernelFactory implements MercerKernelFactory<double[]> {

    @Override
    public MercerKernel<double[]> createKernel(Map<String, Number> properties) {
        return new LinearKernel();
    }

}
