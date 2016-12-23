package io.pivotal.bds.gemfire.geojson.test;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.FunctionService;

import io.pivotal.bds.gemfire.geojson.common.AddFeatureRequest;

@RestController
public class LoadController {

    @Autowired
    private Region<Integer, Integer> routingRegion;

    private static Executor exec = Executors.newFixedThreadPool(10);
    private static final Logger LOG = LoggerFactory.getLogger(LoadController.class);

    @RequestMapping(value = "/load/{fileName}", method = RequestMethod.POST)
    public void load(@PathVariable("fileName") String fileName) throws Exception {
        LOG.info("load: loading file {}", fileName);
        BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));

        exec.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    LOG.info("load: parsing, file={}", fileName);
                    JSONObject root = (JSONObject) JSONValue.parse(reader);
                    JSONArray features = (JSONArray) root.get("features");

                    LOG.info("load: creating features, file={}", fileName);
                    Set<AddFeatureRequest> filter = new HashSet<>();
                    int count = 0;
                    int totalCount = 0;

                    for (Object feature : features) {
                        JSONObject jo = (JSONObject) feature;
                        JSONObject props = (JSONObject) jo.get("properties");
                        Number nid = (Number) props.get("osm_id");
                        Integer id = nid.intValue();

                        AddFeatureRequest req = new AddFeatureRequest(id, jo.toJSONString());
                        filter.add(req);

                        ++totalCount;
                        if (++count >= 1000) {
                            LOG.info("load: calling function, file={}, count={}", fileName, totalCount);
                            FunctionService.onRegion(routingRegion).withFilter(filter).execute("AddFeatureFunction").getResult();
                            LOG.info("load: function called, file={}", fileName);

                            filter = new HashSet<>();
                            count = 0;
                        }
                    }

                    LOG.info("load: done, file={}, count={}", fileName, totalCount);
                } catch (Exception x) {
                    LOG.error("load: x={}", x.toString(), x);
                } finally {
                    try {
                        reader.close();
                    } catch (Exception x) {
                        LOG.error("load: x={}", x.toString(), x);
                    }
                }
            }
        });
    }
}
