package io.pivotal.bds.gemfire.analytics.client.mvc;

import java.util.Random;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.analytics.common.Sensor;
import io.pivotal.bds.gemfire.analytics.common.SensorKey;
import io.pivotal.bds.gemfire.analytics.common.SensorType;
import io.pivotal.bds.gemfire.analytics.common.SensorUnit;
import io.pivotal.bds.gemfire.analytics.common.TrainingParameters;
import io.pivotal.bds.gemfire.analytics.common.TrainingParametersKey;

@RestController
@RequestMapping("/train")
public class TrainingController {

    @Resource(name="SensorRegionBean")
    private Region<SensorKey, Sensor> sensorRegion;

    @Resource(name="TrainingParametersRegionBean")
    private Region<TrainingParametersKey, TrainingParameters> trainingRegion;

    private static final Random random = new Random();

    private static int count = 1000;

    private static final Logger LOG = LoggerFactory.getLogger(TrainingController.class);

    @RequestMapping(method = RequestMethod.POST)
    public void train(@RequestParam("id") String sensorId, @RequestParam("type") SensorType type,
            @RequestParam("unit") SensorUnit unit) {

        LOG.info("train: sensorId={}, type={}, unit={}", sensorId, type, unit);

        SensorKey sk = new SensorKey(sensorId);
        Sensor sen = new Sensor(sk, sensorId, type, unit);
        sensorRegion.putIfAbsent(sk, sen);

        double[][] x = new double[count][];
        int[] y = new int[count];

        for (int i = 0; i < count; ++i) {
            boolean b = random.nextInt(100) <= 1;

            y[i] = b ? 1 : 0;

            x[i] = new double[1];
            x[i][0] = b ? 10.0 + random.nextDouble() * 10.0 : random.nextDouble() * 10.0;

            if (b) {
                LOG.error("train: sensorId={}, x={}, y={}", sensorId, x[i][0], y[i]);
            } else {
                LOG.info("train: sensorId={}, x={}, y={}", sensorId, x[i][0], y[i]);
            }
        }

        TrainingParametersKey tpk = new TrainingParametersKey(sensorId);
        TrainingParameters tp = new TrainingParameters(tpk, x, y);
        trainingRegion.put(tpk, tp);
    }
}
