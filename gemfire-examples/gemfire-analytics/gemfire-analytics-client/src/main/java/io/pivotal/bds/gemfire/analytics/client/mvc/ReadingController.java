package io.pivotal.bds.gemfire.analytics.client.mvc;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.analytics.common.Sensor;
import io.pivotal.bds.gemfire.analytics.common.SensorKey;
import io.pivotal.bds.gemfire.analytics.common.SensorReading;
import io.pivotal.bds.gemfire.analytics.common.SensorReadingKey;

@RestController
@RequestMapping("/readings")
public class ReadingController {

    @Resource(name = "SensorRegionBean")
    private Region<SensorKey, Sensor> sensorRegion;

    @Resource(name = "SensorReadingRegionBean")
    private Region<SensorReadingKey, SensorReading> sensorReadingRegion;

    private Map<String, Runner> runners = new HashMap<>();

    private static final Random random = new Random();
    private static final long waitTime = 1000L;
    private long nextId = 0L;

    private static final Logger LOG = LoggerFactory.getLogger(ReadingController.class);

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public synchronized void start(@PathVariable("id") String sensorId) {
        LOG.info("start: sensorId={}", sensorId);

        if (runners.containsKey(sensorId)) {
            throw new IllegalArgumentException("Readings for sensor " + sensorId + " already being generated");
        }

        SensorKey sk = new SensorKey(sensorId);
        Sensor sensor = sensorRegion.get(sk);
        Assert.notNull(sensor, "Sensor " + sensorId + " does not exist");

        Runner r = new Runner(sk);
        runners.put(sensorId, r);
        r.start();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public synchronized void stop(@PathVariable("id") String sensorId) {
        LOG.info("stop: sensorId={}", sensorId);
        Runner r = runners.remove(sensorId);
        Assert.notNull(r, "Readings for sensor " + sensorId + " are not being generated");
        r.kill();
    }

    private class Runner extends Thread {

        private SensorKey key;

        private boolean running = true;

        public Runner(SensorKey key) {
            this.key = key;
        }

        public void kill() {
            running = false;
        }

        @Override
        public void run() {
            LOG.info("run: starting, key={}", key);
            try {
                while (running) {
                    double val = random.nextDouble() * 10.0;

                    if (random.nextInt(100) <= 1) {
                        val += 10.0;
                    }

                    LOG.info("run: key={}, val={}", key, val);

                    SensorReadingKey srk = new SensorReadingKey(++nextId);
                    SensorReading sr = new SensorReading(srk, key, new Date(), val);

                    sensorReadingRegion.put(srk, sr);

                    Thread.sleep(waitTime);
                }
            } catch (Exception x) {
                LOG.error(x.toString(), x);
            } finally {
                LOG.info("run: exiting, key={}", key);
            }
        }
    }
}
