package io.pivotal.bds.gemfire.ml.kernel;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.MercerKernelFactory;
import smile.math.SparseArray;
import smile.math.kernel.MercerKernel;
import smile.math.kernel.SparseLinearKernel;

public class SparseLinearKernelFactory implements MercerKernelFactory<SparseArray> {

    @Override
    public MercerKernel<SparseArray> createKernel(Map<String, Number> properties) {
        return new SparseLinearKernel();
    }

}
