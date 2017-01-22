package io.pivotal.bds.gemfire.geojson.function;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
import org.apache.geode.cache.execute.ResultSender;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;

import io.pivotal.bds.gemfire.geojson.comp.ComparisonType;
import io.pivotal.bds.gemfire.geojson.data.Boundary;
import io.pivotal.bds.gemfire.geojson.data.FindFeaturesRequest;

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
            FindFeaturesRequest req = (FindFeaturesRequest) context.getArguments();
            
            Coordinate[] coords = req.getCoordinates();
            String typeName = req.getTypeName();
            ComparisonType compType = req.getComparisonType();
            LOG.debug("execute: typeName={}, compType={}, coords={}", typeName, compType, Arrays.toString(coords));

            Geometry geom = null;
            if (coords.length == 1) {
                geom = factory.createPoint(coords[0]);
            } else {
                geom = factory.createPolygon(coords);
            }

            List<SimpleFeature> fl = null;

            Context ctx = timer.time();
            try {
                fl = rootBoundary.findFeatures(geom, compType, typeName);
            } finally {
                ctx.stop();
            }

            meter.mark();

            ResultSender<String> sender = context.getResultSender();

            if (fl.isEmpty()) {
                sender.lastResult("");
            } else {
                Iterator<SimpleFeature> iter = fl.iterator();

                while (iter.hasNext()) {
                    SimpleFeature sf = iter.next();
                    StringWriter sw = new StringWriter();
                    json.writeFeature(sf, sw);
                    String resp = sw.toString();

                    if (iter.hasNext()) {
                        sender.sendResult(resp);
                    } else {
                        sender.lastResult(resp);
                    }
                }
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
