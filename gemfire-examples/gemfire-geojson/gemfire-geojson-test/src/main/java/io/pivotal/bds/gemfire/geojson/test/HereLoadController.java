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
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.geojson.feature.FeatureJSON;
import org.junit.Assert;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTReader;

@RestController
@RequestMapping("/here/wkt")
public class HereLoadController {

    @Autowired
    private Region<String, String> jsonFeatureRegion;

    private static final FeatureJSON json = new FeatureJSON();
    private static final WKTReader wktReader = new WKTReader();
    private static final Executor exec = Executors.newSingleThreadExecutor();
    private static final Logger LOG = LoggerFactory.getLogger(HereLoadController.class);

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
                        
                        SimpleFeatureTypeBuilder sftb = new SimpleFeatureTypeBuilder();
                        sftb.add("geometry", Geometry.class);
                        sftb.setName("Link");
                        SimpleFeatureType sft = sftb.buildFeatureType();
                        
                        String line = null;
                        
                        LOG.info("load: creating features, file={}", fileName);
                        int count = 0;
                        Map<String, String> map = new HashMap<>();

                        while ((line = reader.readLine()) != null) {
                            String[] cols = line.split("\t");
                            Assert.assertEquals(line, 2, cols.length);

                            String id = cols[0].trim();
                            String wkt = cols[1].trim();
                            Geometry geo = wktReader.read(wkt);
                            
                            SimpleFeatureBuilder sfb = new SimpleFeatureBuilder(sft);
                            sfb.add(geo);
                            
                            SimpleFeature sf = sfb.buildFeature(id);

                            StringWriter sw = new StringWriter();
                            json.writeFeature(sf, sw);
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
