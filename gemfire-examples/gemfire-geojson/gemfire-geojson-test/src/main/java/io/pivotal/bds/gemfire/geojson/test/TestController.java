package io.pivotal.bds.gemfire.geojson.test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.geotools.geojson.feature.FeatureJSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.opengis.feature.simple.SimpleFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.LineString;

import io.pivotal.bds.metrics.rater.Rater;
import io.pivotal.bds.metrics.timer.Timer;

@RestController
public class TestController {

    @Autowired
    private Pool pool;

    private final List<Coordinate> coords = new ArrayList<>();
    private boolean running = false;

    private static final Random random = new Random();
    private static final FeatureJSON featureJson = new FeatureJSON();
    private static final Timer timer = new Timer("TestController");
    private static final Rater rater = new Rater("TestController");
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/start/{fileName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public synchronized void start(@PathVariable("fileName") String fileName,
            @RequestParam(name = "threadcount", required = false, defaultValue = "1") int threadCount) throws Exception {
        if (running) {
            throw new IllegalArgumentException("Test is already running");
        }

        coords.clear();

        LOG.info("start: loading file {}", fileName);
        BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));

        LOG.info("start: parsing, file={}", fileName);
        JSONObject root = (JSONObject) JSONValue.parse(reader);
        JSONArray features = (JSONArray) root.get("features");

        for (Object feature : features) {
            System.out.println(feature);
            SimpleFeature sf = (SimpleFeature) featureJson.readFeature(new StringReader(feature.toString()));
            LineString geo = (LineString) sf.getAttribute("geometry");
            Coordinate coord = geo.getCoordinate();
            coords.add(coord);
        }

        LOG.info("start: starting threads, file={}", fileName);
        running = true;
        for (int i = 0; i < threadCount; ++i) {
            new Runner().start();
        }
    }

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public synchronized void stop() {
        LOG.info("stop");
        running = false;
    }

    private class Runner extends Thread {

        @Override
        public void run() {
            try {
                int size = coords.size();

                while (running) {
                    int index = random.nextInt(size);
                    Coordinate coord = coords.get(index);

                    timer.start();
                    FunctionService.onServers(pool).withArgs(coord).execute("FindFeaturesFunction").getResult();
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
