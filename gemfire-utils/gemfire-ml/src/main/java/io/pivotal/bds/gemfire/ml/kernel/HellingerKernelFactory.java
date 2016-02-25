package io.pivotal.bds.gemfire.ml.kernel;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.MercerKernelFactory;
import smile.math.kernel.HellingerKernel;
import smile.math.kernel.MercerKernel;

public class HellingerKernelFactory implements MercerKernelFactory<double[]> {

    @Override
    public MercerKernel<double[]> createKernel(Map<String, Number> properties) {
        return new HellingerKernel();
    }

}
