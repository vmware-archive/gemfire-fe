package io.pivotal.bds.gemfire.ml;

import java.util.HashMap;
import java.util.Map;

import io.pivotal.bds.gemfire.ml.kernel.BinarySparseGaussianKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.BinarySparseHyperbolicTangentKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.BinarySparseLaplacianKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.BinarySparseLinearKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.BinarySparsePolynomialKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.BinarySparseThinPlateSplineKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.GaussianKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.HellingerKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.HyperbolicTangentKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.LaplacianKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.LinearKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.PearsonKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.PolynomialKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.SparseGaussianKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.SparseHyperbolicTangentKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.SparseLaplacianKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.SparseLinearKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.SparsePolynomialKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.SparseThinPlateSplineKernelFactory;
import io.pivotal.bds.gemfire.ml.kernel.ThinPlateSplineKernelFactory;

public class MercerKernelFactoryManager {

    private static final Map<KernelType, MercerKernelFactory<?>> factories;

    static {
        factories = new HashMap<>();
        
        factories.put(KernelType.Gaussian, new GaussianKernelFactory());
        factories.put(KernelType.SparseGaussian, new SparseGaussianKernelFactory());
        factories.put(KernelType.BinarySparseGaussian, new BinarySparseGaussianKernelFactory());
        factories.put(KernelType.Laplacian, new LaplacianKernelFactory());
        factories.put(KernelType.SparseLaplacian, new SparseLaplacianKernelFactory());
        factories.put(KernelType.BinarySparseLaplacian, new BinarySparseLaplacianKernelFactory());
        factories.put(KernelType.Linear, new LinearKernelFactory());
        factories.put(KernelType.SparseLinear, new SparseLinearKernelFactory());
        factories.put(KernelType.BinarySparseLinear, new BinarySparseLinearKernelFactory());
        factories.put(KernelType.Pearson, new PearsonKernelFactory());
        factories.put(KernelType.Polynomial, new PolynomialKernelFactory());
        factories.put(KernelType.SparsePolynomial, new SparsePolynomialKernelFactory());
        factories.put(KernelType.BinarySparsePolynomial, new BinarySparsePolynomialKernelFactory());
        factories.put(KernelType.HyperbolicTangent, new HyperbolicTangentKernelFactory());
        factories.put(KernelType.SparseHyperbolicTangent, new SparseHyperbolicTangentKernelFactory());
        factories.put(KernelType.BinarySparseHyperbolicTangent, new BinarySparseHyperbolicTangentKernelFactory());
        factories.put(KernelType.ThinPlateSpline, new ThinPlateSplineKernelFactory());
        factories.put(KernelType.SparseThinPlateSpline, new SparseThinPlateSplineKernelFactory());
        factories.put(KernelType.BinarySparseThinPlateSpline, new BinarySparseThinPlateSplineKernelFactory());
        factories.put(KernelType.Hellinger, new HellingerKernelFactory());
    }

    public static MercerKernelFactory<?> getFactory(KernelType type) {
        MercerKernelFactory<?> factory = factories.get(type);
        
        if (factory == null) {
            throw new IllegalArgumentException("Kernel type " + type.name() + " not found");
        }
        
        return factory;
    }

    private MercerKernelFactoryManager() {
    }

}
