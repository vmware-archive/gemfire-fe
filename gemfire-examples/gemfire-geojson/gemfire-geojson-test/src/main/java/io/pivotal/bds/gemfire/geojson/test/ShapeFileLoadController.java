package io.pivotal.bds.gemfire.geojson.test;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.geode.cache.Region;
import org.apache.shiro.util.Assert;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/census/shapefile")
public class ShapeFileLoadController {

    @Autowired
    private Region<String, String> jsonFeatureRegion;

    private static final FeatureJSON json = new FeatureJSON();
    private static Executor exec = Executors.newSingleThreadExecutor();
    private static final Logger LOG = LoggerFactory.getLogger(ShapeFileLoadController.class);

    @RequestMapping(value = "/load", method = RequestMethod.POST)
    public void load(@RequestParam("fileName") String fileName) throws Exception {
        LOG.info("load: loading file {}", fileName);

        exec.execute(new Runnable() {

            @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
            public void run() {
                try {
                    Map params = new HashMap();
                    params.put("url", fileName);

                    DataStore dataStore = DataStoreFinder.getDataStore(params);

                    Assert.notNull(dataStore, "DataStore not found");

                    String[] typeNames = dataStore.getTypeNames();
                    Assert.notNull(typeNames);
                    Assert.isTrue(typeNames.length > 0, "No type names found");
                    
                    for (String typeName: typeNames) {
                        SimpleFeatureSource src = dataStore.getFeatureSource(typeName);
                        SimpleFeatureCollection coll = src.getFeatures();
                        SimpleFeatureIterator iter = coll.features();
                        
                        while (iter.hasNext()) {
                            SimpleFeature feature = iter.next();

                            String geoId = (String) feature.getAttribute("GEOID10");
                            Assert.notNull(geoId,"Missing 'GEOID10' attribute");
                            
                            SimpleFeatureBuilder sfb = new SimpleFeatureBuilder(feature.getFeatureType());
                            sfb.init(feature);

                            SimpleFeature newFeature = sfb.buildFeature(geoId);
                            StringWriter sw = new StringWriter();
                            json.writeFeature(newFeature, sw);
                            
                            String sfs = sw.toString();
                            
                            jsonFeatureRegion.put(geoId, sfs);
                        }
                    }
                } catch (Exception x) {
                    LOG.error("load: x={}", x.toString(), x);
                }
            }
        });
    }
}
