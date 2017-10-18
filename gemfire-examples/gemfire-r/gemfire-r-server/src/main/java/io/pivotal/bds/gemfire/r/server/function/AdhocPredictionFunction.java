package io.pivotal.bds.gemfire.r.server.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.FunctionException;
import org.apache.geode.cache.execute.ResultSender;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.r.common.ModelKey;
import io.pivotal.bds.gemfire.r.common.Vector;
import io.pivotal.bds.gemfire.r.common.VectorKey;
import io.pivotal.bds.gemfire.r.common.AdhocPrediction;
import io.pivotal.bds.gemfire.r.common.AdhocPredictionRequest;
import io.pivotal.bds.gemfire.r.common.AdhocPredictionResponse;
import io.pivotal.bds.gemfire.r.server.util.Utils;
import io.pivotal.bds.gemfire.util.RegionHelper;

@SuppressWarnings("serial")
public class AdhocPredictionFunction implements Function, Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(AdhocPredictionFunction.class);

    @Override
    public void execute(FunctionContext ctx) {
        try {
            ResultSender<AdhocPredictionResponse> sender = ctx.getResultSender();
            AdhocPredictionRequest req = (AdhocPredictionRequest) ctx.getArguments();
            LOG.debug("execute: req={}", req);

            Region<ModelKey, Model<?, ?, double[], Number>> modelRegion = RegionHelper.getRegion("model");

            ModelKey modelKey = req.getModelKey();
            Model<?, ?, double[], Number> model = modelRegion.get(modelKey);
            Assert.notNull(model, "Model " + modelKey.getId() + " not found");

            List<AdhocPrediction> predicts = new ArrayList<>();
            double[] x = null;

            Object arg = req.getArgument();

            if (Number.class.isInstance(arg)) {
                Number n = Number.class.cast(arg);
                x = new double[]{ n.doubleValue() };
            } else if (String.class == arg.getClass()) {
                Region<VectorKey, Vector<Object>> vectorRegion = RegionHelper.getRegion("vector");
                String vectorId = String.class.cast(arg);
                VectorKey key = new VectorKey(vectorId);
                Vector<Object> v = vectorRegion.get(key);
                Assert.notNull(v, "Vector " + vectorId + " not found");
                
                x = Utils.convertObjectVectorToDoubleArray(v);
            } else {
                throw new IllegalArgumentException("Expected a vectorId or number, got " + arg.getClass().getName());
            }

            Number p = model.predict(x);
            LOG.debug("execute: x={}, p={}", Arrays.toString(x), p);

            AdhocPrediction pred = new AdhocPrediction(x, p);
            predicts.add(pred);
            
            AdhocPredictionResponse resp = new AdhocPredictionResponse(predicts);
            LOG.debug("execute: resp={}", resp);

            sender.lastResult(resp);
        } catch (Exception x) {
            throw new FunctionException(x.toString(), x);
        }
    }

    @Override
    public String getId() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean hasResult() {
        return true;
    }

    @Override
    public boolean isHA() {
        return false;
    }

    @Override
    public boolean optimizeForWrite() {
        return false;
    }

    @Override
    public void init(Properties props) {
    }

}
