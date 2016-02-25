package io.pivotal.bds.gemfire.ml.kernel;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.MercerKernelFactory;
import smile.math.SparseArray;
import smile.math.kernel.MercerKernel;
import smile.math.kernel.SparseHyperbolicTangentKernel;

public class SparseHyperbolicTangentKernelFactory implements MercerKernelFactory<SparseArray> {

    @Override
    public MercerKernel<SparseArray> createKernel(Map<String, Number> properties) {
        Number scale = properties.getOrDefault("scale", 1.0);
        Number offset = properties.getOrDefault("offset", 1.0);
        return new SparseHyperbolicTangentKernel(scale.doubleValue(), offset.doubleValue());
    }

}
