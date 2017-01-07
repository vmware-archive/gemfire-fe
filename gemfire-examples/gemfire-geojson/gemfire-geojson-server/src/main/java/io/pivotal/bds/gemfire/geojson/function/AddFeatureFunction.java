package io.pivotal.bds.gemfire.geojson.function;

import java.io.StringReader;
import java.util.Set;

import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.FunctionException;
import org.apache.geode.cache.execute.RegionFunctionContext;
import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.Timer.Context;

import io.pivotal.bds.gemfire.geojson.data.AddFeatureRequest;
import io.pivotal.bds.gemfire.geojson.data.Boundary;

@SuppressWarnings("serial")
public class AddFeatureFunction implements Function {

    private Boundary rootBoundary;

    private static final FeatureJSON json = new FeatureJSON();
    private final Timer timer;
    private final Meter meter;
    private static final Logger LOG = LoggerFactory.getLogger(AddFeatureFunction.class);

    public AddFeatureFunction(Boundary rootBoundary, MetricRegistry registry) {
        this.rootBoundary = rootBoundary;
        
        this.timer = registry.timer("AddFeatureFunction-Timer");
        this.meter = registry.meter("AddFeatureFunction-Meter");
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
                Context ctx = timer.time();
                try {
                    rootBoundary.addFeature(feature);
                } finally {
                    ctx.stop();
                }
                
                meter.mark();
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
