package io.pivotal.bds.gemfire.ml.kernel;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.MercerKernelFactory;
import smile.math.kernel.BinarySparseLinearKernel;
import smile.math.kernel.MercerKernel;

public class BinarySparseLinearKernelFactory implements MercerKernelFactory<int[]> {

    @Override
    public MercerKernel<int[]> createKernel(Map<String, Number> properties) {
        return new BinarySparseLinearKernel();
    }

}
