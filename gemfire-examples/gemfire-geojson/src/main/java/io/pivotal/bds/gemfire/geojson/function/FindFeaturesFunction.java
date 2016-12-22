package io.pivotal.bds.gemfire.geojson.function;

import java.io.StringWriter;
import java.util.List;

import org.geotools.feature.DefaultFeatureCollection;
import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.execute.Function;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.cache.execute.FunctionException;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import io.pivotal.bds.gemfire.geojson.data.Boundary;
import io.pivotal.bds.metrics.rater.Rater;
import io.pivotal.bds.metrics.timer.Timer;

@SuppressWarnings("serial")
public class FindFeaturesFunction implements Function {

    private Boundary rootBoundary;
    private static final GeometryFactory factory = new GeometryFactory();
    private static final FeatureJSON json = new FeatureJSON();
    private static final Timer timer = new Timer("FindFeaturesFunction");
    private static final Rater rater = new Rater("FindFeaturesFunction");
    private static final Logger LOG = LoggerFactory.getLogger(FindFeaturesFunction.class);

    public FindFeaturesFunction(Boundary rootBoundary) {
        this.rootBoundary = rootBoundary;
    }

    @Override
    public void execute(FunctionContext context) {
        try {
            Coordinate coord = (Coordinate) context.getArguments();
            LOG.debug("execute: coord={}", coord);

            Point pt = factory.createPoint(coord);

            timer.start();
            List<SimpleFeature> fl = rootBoundary.getIntersectingFeatures(pt);
            timer.end();
            rater.increment();

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
