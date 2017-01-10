package io.pivotal.bds.gemfire.geojson.writer;

import java.io.IOException;
import java.io.StringReader;

import org.apache.geode.cache.CacheWriterException;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.util.CacheWriterAdapter;
import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.Timer.Context;

import io.pivotal.bds.gemfire.geojson.data.Boundary;

public class GeoJsonCacheWriter extends CacheWriterAdapter<Integer, String> {

    private Boundary rootBoundary;

    private final Timer timer;
    private final Meter meter;
    private static final FeatureJSON json = new FeatureJSON();
    private static final Logger LOG = LoggerFactory.getLogger(GeoJsonCacheWriter.class);

    public GeoJsonCacheWriter(Boundary rootBoundary, MetricRegistry registry) {
        this.rootBoundary = rootBoundary;

        this.timer = registry.timer("GeoJsonCacheWriter-Timer");
        this.meter = registry.meter("GeoJsonCacheWriter-Meter");
    }

    @Override
    public void beforeCreate(EntryEvent<Integer, String> event) throws CacheWriterException {
        try {
            Context ctx = timer.time();

            Integer id = event.getKey();
            String raw = event.getNewValue();
            LOG.debug("beforeCreate: id={}, raw={}", id, raw);

            StringReader reader = new StringReader(raw);
            SimpleFeature feature = json.readFeature(reader);

            rootBoundary.addFeature(feature);

            ctx.stop();
            meter.mark();
        } catch (IOException x) {
            throw new CacheWriterException(x.toString(), x);
        }
    }

    @Override
    public void beforeDestroy(EntryEvent<Integer, String> event) throws CacheWriterException {
        Integer id = event.getKey();
        LOG.debug("beforeDestroy: id={}", id);
        rootBoundary.removeFeature(id);
        meter.mark();
    }

    @Override
    public void beforeUpdate(EntryEvent<Integer, String> event) throws CacheWriterException {
        try {
            Context ctx = timer.time();

            Integer id = event.getKey();
            String raw = event.getNewValue();
            LOG.debug("beforeUpdate: id={}, raw={}", id, raw);

            StringReader reader = new StringReader(raw);
            SimpleFeature feature = json.readFeature(reader);

            rootBoundary.removeFeature(id);
            rootBoundary.addFeature(feature);

            ctx.stop();
            meter.mark();
        } catch (IOException x) {
            throw new CacheWriterException(x.toString(), x);
        }
    }

}
