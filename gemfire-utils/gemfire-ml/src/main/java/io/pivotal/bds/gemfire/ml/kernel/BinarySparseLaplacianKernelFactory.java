package io.pivotal.bds.gemfire.ml.kernel;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.MercerKernelFactory;
import smile.math.kernel.BinarySparseLaplacianKernel;
import smile.math.kernel.MercerKernel;

public class BinarySparseLaplacianKernelFactory implements MercerKernelFactory<int[]> {

    @Override
    public MercerKernel<int[]> createKernel(Map<String, Number> properties) {
        Number sigma = properties.getOrDefault("sigma",1.0);
        return new BinarySparseLaplacianKernel(sigma.doubleValue());
    }

}
