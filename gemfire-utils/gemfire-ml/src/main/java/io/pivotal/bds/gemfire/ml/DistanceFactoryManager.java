package io.pivotal.bds.gemfire.ml;

import java.util.HashMap;
import java.util.Map;

import io.pivotal.bds.gemfire.ml.distance.ChebyshevDistanceFactory;
import io.pivotal.bds.gemfire.ml.distance.CorrelationDistanceFactory;
import io.pivotal.bds.gemfire.ml.distance.DynamicTimeWarpingDistanceFactory;
import io.pivotal.bds.gemfire.ml.distance.EditDistanceFactory;
import io.pivotal.bds.gemfire.ml.distance.EuclideanDistanceFactory;
import io.pivotal.bds.gemfire.ml.distance.JaccardDistanceFactory;
import io.pivotal.bds.gemfire.ml.distance.LeeDistanceFactory;
import io.pivotal.bds.gemfire.ml.distance.MahalanobisDistanceFactory;
import io.pivotal.bds.gemfire.ml.distance.ManhattanDistanceFactory;
import io.pivotal.bds.gemfire.ml.distance.MinkowskiDistanceFactory;
import io.pivotal.bds.gemfire.ml.distance.SparseChebyshevDistanceFactory;
import io.pivotal.bds.gemfire.ml.distance.SparseEuclideanDistanceFactory;
import io.pivotal.bds.gemfire.ml.distance.SparseManhattanDistanceFactory;
import io.pivotal.bds.gemfire.ml.distance.SparseMinkowskiDistanceFactory;

public class DistanceFactoryManager {

    private static final Map<DistanceType, DistanceFactory<?>> factories;

    static {
        factories = new HashMap<>();

        factories.put(DistanceType.ChebyshevDistance, new ChebyshevDistanceFactory());
        factories.put(DistanceType.CorrelationDistance, new CorrelationDistanceFactory());
        factories.put(DistanceType.DynamicTimeWarping, new DynamicTimeWarpingDistanceFactory<>());
        factories.put(DistanceType.EditDistance, new EditDistanceFactory());
        factories.put(DistanceType.EuclideanDistance, new EuclideanDistanceFactory());
        factories.put(DistanceType.JaccardDistance, new JaccardDistanceFactory<>());
        factories.put(DistanceType.LeeDistance, new LeeDistanceFactory());
        factories.put(DistanceType.MahalanobisDistance, new MahalanobisDistanceFactory());
        factories.put(DistanceType.ManhattanDistance, new ManhattanDistanceFactory());
        factories.put(DistanceType.MinkowskiDistance, new MinkowskiDistanceFactory());
        factories.put(DistanceType.SparseChebyshevDistance, new SparseChebyshevDistanceFactory());
        factories.put(DistanceType.SparseEuclideanDistance, new SparseEuclideanDistanceFactory());
        factories.put(DistanceType.SparseManhattanDistance, new SparseManhattanDistanceFactory());
        factories.put(DistanceType.SparseMinkowskiDistance, new SparseMinkowskiDistanceFactory());
    }

    public static DistanceFactory<?> getFactory(DistanceType type) {
        DistanceFactory<?> factory = factories.get(type);

        if (factory == null) {
            throw new IllegalArgumentException("Distance factory not found for type " + type.name());
        }

        return factory;
    }

    private DistanceFactoryManager() {

    }
}
