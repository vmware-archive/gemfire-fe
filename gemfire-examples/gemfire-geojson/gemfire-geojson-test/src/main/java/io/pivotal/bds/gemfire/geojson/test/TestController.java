package io.pivotal.bds.gemfire.geojson.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.geode.cache.client.Pool;
import org.apache.geode.cache.execute.FunctionService;
import org.apache.shiro.util.Assert;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.geojson.feature.FeatureJSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.opengis.feature.simple.SimpleFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vividsolutions.jts.geom.Geometry;

import io.pivotal.bds.gemfire.geojson.comp.ComparisonType;
import io.pivotal.bds.gemfire.geojson.data.FindFeaturesRequest;
import io.pivotal.bds.metrics.rater.Rater;
import io.pivotal.bds.metrics.timer.Timer;

@RestController
public class TestController {

    @Autowired
    private Pool pool;

    private final List<Geometry> geometries = new ArrayList<>();
    private boolean running = false;

    private static final Random random = new Random();
    private static final FeatureJSON featureJson = new FeatureJSON();
    private static final Timer timer = new Timer("TestController");
    private static final Rater rater = new Rater("TestController");
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/geojson/start", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public synchronized void startGeoJson(@RequestParam(name = "fileName") String fileName,
            @RequestParam(name = "threadcount", required = false, defaultValue = "1") int threadCount) throws Exception {

        LOG.info("startGeoJson: fileName={}, threadCount={}", fileName, threadCount);

        if (running) {
            throw new IllegalArgumentException("Test is already running");
        }

        running = true;

        new GeoJsonStarter(fileName, threadCount).start();
    }

    @RequestMapping(value = "/shapefile/start", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public synchronized void startShapefile(@RequestParam(name = "fileName") String fileName,
            @RequestParam(name = "threadcount", required = false, defaultValue = "1") int threadCount) throws Exception {

        LOG.info("startShapefile: fileName={}, threadCount={}", fileName, threadCount);

        if (running) {
            throw new IllegalArgumentException("Test is already running");
        }

        running = true;

        new ShapeFileStarter(fileName, threadCount).start();
    }

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public synchronized void stop() {
        LOG.info("stop");
        running = false;
    }

    private class GeoJsonStarter extends Thread {

        private String fileName;
        private int threadCount;

        public GeoJsonStarter(String fileName, int threadCount) {
            this.fileName = fileName;
            this.threadCount = threadCount;
        }

        @Override
        public void run() {
            try {
                geometries.clear();

                LOG.info("start: loading file {}", fileName);
                BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));

                LOG.info("start: parsing, file={}", fileName);
                JSONObject root = (JSONObject) JSONValue.parse(reader);
                JSONArray features = (JSONArray) root.get("features");

                for (Object feature : features) {
                    SimpleFeature sf = (SimpleFeature) featureJson.readFeature(new StringReader(feature.toString()));
                    Geometry geo = (Geometry) sf.getAttribute("geometry");
                    geometries.add(geo.getEnvelope()); // use envelope for intersects test
                }

                LOG.info("start: starting threads, file={}", fileName);
                for (int i = 0; i < threadCount; ++i) {
                    new Runner().start();
                }
            } catch (Exception x) {
                LOG.error("GeoJsonStarter: x={}", x.toString(), x);
                running = false;
            }
        }
    }

    private class ShapeFileStarter extends Thread {

        private String fileName;
        private int threadCount;

        public ShapeFileStarter(String fileName, int threadCount) {
            this.fileName = fileName;
            this.threadCount = threadCount;
        }

        @SuppressWarnings({ "rawtypes", "unchecked" })
        @Override
        public void run() {
            try {
                geometries.clear();

                LOG.info("start: loading file {}", fileName);
                Map params = new HashMap();
                params.put("url", new File(fileName).toURI().toString());

                DataStore dataStore = DataStoreFinder.getDataStore(params);

                Assert.notNull(dataStore, "DataStore not found");

                String[] typeNames = dataStore.getTypeNames();
                Assert.notNull(typeNames);
                Assert.isTrue(typeNames.length > 0, "No type names found");

                for (String typeName : typeNames) {
                    LOG.info("load: found type {} in file {}", typeName, fileName);

                    SimpleFeatureSource src = dataStore.getFeatureSource(typeName);
                    SimpleFeatureCollection coll = src.getFeatures();
                    SimpleFeatureIterator iter = coll.features();

                    while (iter.hasNext()) {
                        SimpleFeature feature = iter.next();
                        Geometry geo = (Geometry) feature.getDefaultGeometry();
                        geometries.add(geo.getEnvelope()); // use envelope for intersects test
                    }
                }

                LOG.info("start: starting threads, file={}, threadCount={}", fileName, threadCount);
                for (int i = 0; i < threadCount; ++i) {
                    new Runner().start();
                }
            } catch (Exception x) {
                LOG.error("ShapeFileStarter: x={}", x.toString(), x);
                running = false;
            }
        }
    }

    private class Runner extends Thread {

        @Override
        public void run() {
            try {
                int size = geometries.size();

                while (running) {
                    int index = random.nextInt(size);
                    Geometry geo = geometries.get(index);
                    FindFeaturesRequest req = new FindFeaturesRequest(geo, null, ComparisonType.intersects);

                    timer.start();
                    FunctionService.onServers(pool).withArgs(req).execute("FindFeaturesFunction").getResult();
                    timer.end();
                    rater.increment();
                }
            } catch (Exception x) {
                LOG.error("Runner.run: x={}", x.toString(), x);
            } finally {
                running = false;
            }
        }
    }
}
