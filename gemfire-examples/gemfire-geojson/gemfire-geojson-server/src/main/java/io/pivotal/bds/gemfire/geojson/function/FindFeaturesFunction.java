package io.pivotal.bds.gemfire.geojson.function;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import org.geotools.feature.DefaultFeatureCollection;
import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.Timer.Context;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.FunctionException;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;

import io.pivotal.bds.gemfire.geojson.data.Boundary;

@SuppressWarnings("serial")
public class FindFeaturesFunction implements Function {

    private Boundary rootBoundary;
    private static final GeometryFactory factory = new GeometryFactory();
    private static final FeatureJSON json = new FeatureJSON();
    private final Timer timer;
    private final Meter meter;
    private static final Logger LOG = LoggerFactory.getLogger(FindFeaturesFunction.class);

    public FindFeaturesFunction(Boundary rootBoundary, MetricRegistry registry) {
        this.rootBoundary = rootBoundary;
        this.timer = registry.timer("FindFeaturesFunction-Timer");
        this.meter = registry.meter("FindFeaturesFunction-Meter");
    }

    @Override
    public void execute(FunctionContext context) {
        try {
            Coordinate[] coords = (Coordinate[]) context.getArguments();
            LOG.debug("execute: coords={}", Arrays.toString(coords));

            Geometry geom = null;
            if (coords.length == 1) {
                geom = factory.createPoint(coords[0]);
            } else {
                geom = factory.createPolygon(coords);
            }

            List<SimpleFeature> fl = null;

            Context ctx = timer.time();
            try {
                fl = rootBoundary.getIntersectingFeatures(geom);
            } finally {
                ctx.stop();
            }

            meter.mark();

            if (fl.isEmpty()) {
                context.getResultSender().lastResult("{}");
            } else {
                DefaultFeatureCollection coll = new DefaultFeatureCollection();
                coll.addAll(fl);

                StringWriter sw = new StringWriter();
                json.writeFeatureCollection(coll, sw);

                String resp = sw.toString();
                context.getResultSender().lastResult(resp);
            }
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
        return false;
    }

}
