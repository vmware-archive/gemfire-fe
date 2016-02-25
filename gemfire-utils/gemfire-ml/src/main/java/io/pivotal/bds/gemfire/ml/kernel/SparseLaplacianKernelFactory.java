package io.pivotal.bds.gemfire.ml.kernel;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.MercerKernelFactory;
import smile.math.SparseArray;
import smile.math.kernel.MercerKernel;
import smile.math.kernel.SparseLaplacianKernel;

public class SparseLaplacianKernelFactory implements MercerKernelFactory<SparseArray> {

    @Override
    public MercerKernel<SparseArray> createKernel(Map<String, Number> properties) {
        Number sigma = properties.getOrDefault("sigma",1.0);
        return new SparseLaplacianKernel(sigma.doubleValue());
    }

}
