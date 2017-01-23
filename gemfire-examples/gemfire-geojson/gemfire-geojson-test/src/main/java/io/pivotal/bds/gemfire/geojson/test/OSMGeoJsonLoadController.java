package io.pivotal.bds.gemfire.geojson.test;

import java.io.BufferedReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.geode.cache.Region;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.geojson.feature.FeatureJSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.opengis.feature.simple.SimpleFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/osm")
public class OSMGeoJsonLoadController {

    @Autowired
    private Region<String, String> jsonFeatureRegion;

    private static final FeatureJSON json = new FeatureJSON();
    private static Executor exec = Executors.newSingleThreadExecutor();
    private static final Logger LOG = LoggerFactory.getLogger(OSMGeoJsonLoadController.class);

    @RequestMapping(value = "/load", method = RequestMethod.POST)
    public void load(@RequestParam("fileName") String fileName) throws Exception {
        LOG.info("load: loading file {}", fileName);

        exec.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));

                    try {
                        LOG.info("load: parsing, file={}", fileName);
                        JSONObject root = (JSONObject) JSONValue.parse(reader);
                        JSONArray features = (JSONArray) root.get("features");

                        LOG.info("load: creating features, file={}", fileName);
                        int count = 0;
                        Map<String, String> map = new HashMap<>();

                        for (Object feature : features) {
                            JSONObject jo = (JSONObject) feature;

                            // get the osm_id property to use as the feature ID
                            JSONObject props = (JSONObject) jo.get("properties");
                            Number nid = (Number) props.get("osm_id");
                            String id = nid.toString();

                            // convert json to feature
                            SimpleFeature sf = json.readFeature(jo.toString());

                            // use builder to create new feature with osm_id as the ID
                            SimpleFeatureBuilder sfb = new SimpleFeatureBuilder(sf.getFeatureType());
                            sfb.init(sf);
                            SimpleFeature nsf = sfb.buildFeature(id);

                            // convert new feature to string
                            StringWriter sw = new StringWriter();
                            json.writeFeature(nsf, sw);
                            String sfs = sw.toString();
                            
                            map.put(id, sfs);

                            if (++count % 1000 == 0) {
                                // write to region
                                jsonFeatureRegion.putAll(map);
                                map.clear();

                                LOG.info("load: writing, count={}, file={}", count, fileName);
                            }
                        }
                        
                        if (!map.isEmpty()) {
                            jsonFeatureRegion.putAll(map);
                        }

                        LOG.info("load: done, count={}, file={}", count, fileName);
                    } finally {
                        reader.close();
                    }
                } catch (Exception x) {
                    LOG.error("load: x={}", x.toString(), x);
                }
            }
        });
    }
}
