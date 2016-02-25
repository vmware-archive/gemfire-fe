package io.pivotal.bds.gemfire.ml.kernel;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.MercerKernelFactory;
import smile.math.kernel.SparsePolynomialKernel;
import smile.math.SparseArray;
import smile.math.kernel.MercerKernel;

public class SparsePolynomialKernelFactory implements MercerKernelFactory<SparseArray> {

    @Override
    public MercerKernel<SparseArray> createKernel(Map<String, Number> properties) {
        Number degree = properties.getOrDefault("degree", 1);
        Number scale = properties.getOrDefault("scale", 1.0);
        Number offset = properties.getOrDefault("offset", 1.0);
        return new SparsePolynomialKernel(degree.intValue(), scale.doubleValue(), offset.doubleValue());
    }

}
