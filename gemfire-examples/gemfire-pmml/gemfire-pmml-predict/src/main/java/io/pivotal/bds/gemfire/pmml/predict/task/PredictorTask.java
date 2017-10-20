package io.pivotal.bds.gemfire.pmml.predict.task;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.FunctionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import io.pivotal.bds.gemfire.pmml.common.data.EvaluatorParams;
import io.pivotal.bds.gemfire.pmml.common.keys.EvalKey;
import io.pivotal.bds.gemfire.pmml.predict.conf.PredictorProperties;

@Component
@EnableConfigurationProperties(PredictorProperties.class)
public class PredictorTask implements CommandLineRunner {

    private PredictorProperties predictorProperties;
    private Region<EvalKey, EvaluatorParams> paramsRegion;
    
    private static final int batchCount = 100;
    private static final int logCount = batchCount * 10;

    private static final Logger LOG = LoggerFactory.getLogger(PredictorTask.class);

    public PredictorTask(PredictorProperties predictorProperties, Region<EvalKey, EvaluatorParams> paramsRegion) {
        this.predictorProperties = predictorProperties;
        this.paramsRegion = paramsRegion;
    }

    @Override
    public void run(String... args) throws Exception {
        if (predictorProperties.useFunction) {
            useFunction();
        } else {
            useRegion();
        }
    }

    private void useRegion() throws Exception {
        String fileName = predictorProperties.csvFileName;
        Map<EvalKey, EvaluatorParams> paramMap = new HashMap<>();
        int count = 0;
        long start = System.currentTimeMillis();

        try (Scanner scanner = new Scanner(Paths.get(fileName))) {
            scanner.useDelimiter("\n");
            scanner.next(); // header

            while (scanner.hasNext()) {
                String line = scanner.next();

                Map<String, Object> data = getData(line);
                data.remove("Class");

                EvalKey key = new EvalKey(UUID.randomUUID().toString());
                EvaluatorParams params = new EvaluatorParams(key, "test", data);

                paramMap.put(key, params);

                if (paramMap.size() >= batchCount) {
                    paramsRegion.putAll(paramMap);
                    paramMap.clear();
                    
                    count += batchCount;
                    
                    if (count % logCount == 0) {
                        long end = System.currentTimeMillis();
                        long delta = end-start;
                        long avg = delta/count;
                        LOG.info("useRegion: processed {} entries in {} milliseconds, avg {}", count, delta, avg);
                    }
                }
            }
        }

        if (!paramMap.isEmpty()) {
            paramsRegion.putAll(paramMap);
            count += paramMap.size();
        }
        
        long end = System.currentTimeMillis();
        long delta = end-start;
        long avg = delta/count;
        LOG.info("useRegion: processed {} total entries in {} milliseconds, avg {}", count, delta, avg);
    }

    @SuppressWarnings("unchecked")
    private void useFunction() throws Exception {
        String fileName = predictorProperties.csvFileName;
        Map<EvalKey, EvaluatorParams> paramMap = new HashMap<>();
        int count = 0;
        long start = System.currentTimeMillis();

        try (Scanner scanner = new Scanner(Paths.get(fileName))) {
            scanner.useDelimiter("\n");
            scanner.next(); // header

            while (scanner.hasNext()) {
                String line = scanner.next();

                Map<String, Object> data = getData(line);
                data.remove("Class");

                EvalKey key = new EvalKey(UUID.randomUUID().toString());
                EvaluatorParams params = new EvaluatorParams(key, "test", data);

                paramMap.put(key, params);

                if (paramMap.size() >= batchCount) {
                    Set<EvaluatorParams> filter = new HashSet<>();
                    filter.addAll(paramMap.values());

                    FunctionService.onRegion(paramsRegion).withFilter(filter).execute("EvaluatorFunction").getResult();

                    paramMap.clear();
                    count += batchCount;
                    
                    if (count % logCount == 0) {
                        long end = System.currentTimeMillis();
                        long delta = end-start;
                        long avg = delta/count;
                        LOG.info("useFunction: processed {} entries in {} milliseconds, avg {}", count, delta, avg);
                    }
                }
            }
        }
        
        if (!paramMap.isEmpty()) {
            Set<EvaluatorParams> filter = new HashSet<>();
            filter.addAll(paramMap.values());

            FunctionService.onRegion(paramsRegion).withFilter(filter).execute("EvaluatorFunction").getResult();
            count += paramMap.size();
        }
        
        long end = System.currentTimeMillis();
        long delta = end-start;
        long avg = delta/count;
        LOG.info("useFunction: processed {} total entries in {} milliseconds, avg {}", count, delta, avg);
    }

    private Map<String, Object> getData(String line) {
        try (Scanner cols = new Scanner(line)) {
            cols.useDelimiter(",");
            long time = cols.nextLong();
            double v1 = cols.nextDouble();
            double v2 = cols.nextDouble();
            double v3 = cols.nextDouble();
            double v4 = cols.nextDouble();
            double v5 = cols.nextDouble();
            double v6 = cols.nextDouble();
            double v7 = cols.nextDouble();
            double v8 = cols.nextDouble();
            double v9 = cols.nextDouble();
            double v10 = cols.nextDouble();
            double v11 = cols.nextDouble();
            double v12 = cols.nextDouble();
            double v13 = cols.nextDouble();
            double v14 = cols.nextDouble();
            double v15 = cols.nextDouble();
            double v16 = cols.nextDouble();
            double v17 = cols.nextDouble();
            double v18 = cols.nextDouble();
            double v19 = cols.nextDouble();
            double v20 = cols.nextDouble();
            double v21 = cols.nextDouble();
            double v22 = cols.nextDouble();
            double v23 = cols.nextDouble();
            double v24 = cols.nextDouble();
            double v25 = cols.nextDouble();
            double v26 = cols.nextDouble();
            double v27 = cols.nextDouble();
            double v28 = cols.nextDouble();
            double amount = cols.nextDouble();
            String clazz = cols.next();

            Map<String, Object> data = new HashMap<>();

            data.put("Time", time);
            data.put("V1", v1);
            data.put("V2", v2);
            data.put("V3", v3);
            data.put("V4", v4);
            data.put("V5", v5);
            data.put("V6", v6);
            data.put("V7", v7);
            data.put("V8", v8);
            data.put("V9", v9);
            data.put("V10", v10);
            data.put("V11", v11);
            data.put("V12", v12);
            data.put("V13", v13);
            data.put("V14", v14);
            data.put("V15", v15);
            data.put("V16", v16);
            data.put("V17", v17);
            data.put("V18", v18);
            data.put("V19", v19);
            data.put("V20", v20);
            data.put("V21", v21);
            data.put("V22", v22);
            data.put("V23", v23);
            data.put("V24", v24);
            data.put("V25", v25);
            data.put("V26", v26);
            data.put("V27", v27);
            data.put("V28", v28);
            data.put("Amount", amount);
            data.put("Class", clazz);

            return data;
        }
    }

}
