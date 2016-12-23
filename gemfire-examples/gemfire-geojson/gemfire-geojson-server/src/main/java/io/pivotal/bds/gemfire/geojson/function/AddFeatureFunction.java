package io.pivotal.bds.gemfire.geojson.function;

import java.io.StringReader;
import java.util.Set;

import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.execute.Function;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.cache.execute.FunctionException;
import com.gemstone.gemfire.cache.execute.RegionFunctionContext;

import io.pivotal.bds.gemfire.geojson.common.AddFeatureRequest;
import io.pivotal.bds.gemfire.geojson.data.Boundary;
import io.pivotal.bds.metrics.rater.Rater;
import io.pivotal.bds.metrics.timer.Timer;

@SuppressWarnings("serial")
public class AddFeatureFunction implements Function {

    private Boundary rootBoundary;

    private static final FeatureJSON json = new FeatureJSON();
    private static final Timer timer = new Timer("AddFeatureFunction");
    private static final Rater rater = new Rater("AddFeatureFunction");
    private static final Logger LOG = LoggerFactory.getLogger(AddFeatureFunction.class);

    public AddFeatureFunction(Boundary rootBoundary) {
        this.rootBoundary = rootBoundary;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void execute(FunctionContext context) {
        try {
            RegionFunctionContext rctx = (RegionFunctionContext) context;
            Set<AddFeatureRequest> filter = (Set<AddFeatureRequest>) rctx.getFilter();

            for (AddFeatureRequest req : filter) {
                LOG.debug("execute: req={}", req);
                String raw = req.getData();

                // create feature
                StringReader reader = new StringReader(raw);
                SimpleFeature feature = json.readFeature(reader);
                LOG.debug("execute: feature={}, req={}", feature, req);

                // add to boundary
                timer.start();
                rootBoundary.addFeature(feature);
                timer.end();
                rater.increment();
            }

            context.getResultSender().lastResult(Boolean.TRUE);
        } catch (Exception x) {
            LOG.error("execute: x={}", x.toString(), x);
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
        return true;
    }

    @Override
    public boolean optimizeForWrite() {
        return true;
    }

}
