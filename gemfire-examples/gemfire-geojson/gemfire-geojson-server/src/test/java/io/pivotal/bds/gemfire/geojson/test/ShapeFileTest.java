package io.pivotal.bds.gemfire.geojson.test;

import java.io.File;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.pdx.PdxInstance;
import org.apache.geode.pdx.PdxInstanceFactory;
import org.apache.shiro.util.Assert;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.geojson.feature.FeatureJSON;
import org.junit.BeforeClass;
import org.junit.Test;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

public class ShapeFileTest {

    private static ClientCache cache;
    private static Region<String, String> jsonFeatureRegion;
    private static Region<String, PdxInstance> gazetteerRegion;
    private static Map<String, Map<String, Object>> gaz;
    private static SimpleFeatureCollection features;

    private static final FeatureJSON json = new FeatureJSON();

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @BeforeClass
    public static void before() throws Exception {
        System.out.println("before: creating cache and region");

        ClientCacheFactory ccf = new ClientCacheFactory();
        ccf.addPoolLocator("localhost", 10334);
        ccf.setPdxPersistent(false);
        ccf.setPdxReadSerialized(true);

        cache = ccf.create();

        ClientRegionFactory<String, String> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        jsonFeatureRegion = crf.create("jsonFeature");

        ClientRegionFactory<String, PdxInstance> gcrf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        gazetteerRegion = gcrf.create("gazetteer");

        gaz = getGaz();

        // File file = new File("/Users/tdalsing/projects/allstate/docs/census/gz_2010_17_150_00_500k.shp");
        // File file = new File("/Users/tdalsing/projects/allstate/docs/census/tl_2016_17_bg.shp");
        File file = new File("/Users/tdalsing/projects/allstate/docs/census/tl_2016_17_tabblock10.shp");
        Assert.isTrue(file.exists());

        Map params = new HashMap();
        params.put("url", file.toURI().toString());

        DataStore ds = DataStoreFinder.getDataStore(params);
        Assert.notNull(ds);

        String[] tns = ds.getTypeNames();
        Assert.notNull(tns);

        System.out.println(Arrays.toString(ds.getTypeNames()));

        String tn = tns[0];

        SimpleFeatureSource src = ds.getFeatureSource(tn);
        features = src.getFeatures();
    }

    @Test
    public void test() throws Exception {
        int count = 0;

        try (SimpleFeatureIterator iter = features.features()) {

            while (iter.hasNext()) {
                SimpleFeature sf = iter.next();
                SimpleFeatureType sft = sf.getFeatureType();

                String geoId = (String) sf.getAttribute("GEOID10");
                String gazId = geoId.substring(0, 11);

                Map<String, Object> gazProps = gaz.get(gazId);

                SimpleFeatureTypeBuilder sftb = new SimpleFeatureTypeBuilder();

                sftb.init(sft);

                SimpleFeatureType nsft = sftb.buildFeatureType();

                SimpleFeatureBuilder sfb = new SimpleFeatureBuilder(nsft);
                sfb.init(sf);

                SimpleFeature nsf = sfb.buildFeature(geoId);

                StringWriter writer = new StringWriter();
                json.writeFeature(nsf, writer);

                String data = writer.toString();
                jsonFeatureRegion.put(geoId, data);

                if (gazProps != null) {
                    PdxInstance inst = convertGaz(gazProps);
                    gazetteerRegion.put(geoId, inst);
                }

                if (++count % 1000 == 0) {
                    System.out.println("written " + count + " features");
                }
            }
        }
    }

    private static PdxInstance convertGaz(Map<String, Object> map) throws Exception {
        PdxInstanceFactory fact = cache.createPdxInstanceFactory("Gazetteer");

        for (Map.Entry<String, Object> e : map.entrySet()) {
            fact.writeObject(e.getKey(), e.getValue());
        }

        return fact.create();
    }

    private static Map<String, Map<String, Object>> getGaz() throws Exception {
        Map<String, Map<String, Object>> ret = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get("/Users/tdalsing/projects/allstate/docs/census/Gaz_tracts_national.txt"));

        boolean first = true;
        for (String line : lines) {
            if (first) {
                first = false;
            } else {
                String[] fields = line.split("\\s+");

                String geoid = fields[1];

                Map<String, Object> map = new HashMap<>();

                map.put("USPS", fields[0]);
                map.put("GEOID", geoid);
                map.put("POP10", new Integer(fields[2]));
                map.put("HU10", new Integer(fields[3]));
                map.put("ALAND", new Long(fields[4]));
                map.put("AWATER", new Long(fields[5]));
                map.put("ALAND_SQMI", new Double(fields[6]));
                map.put("AWATER_SQMI", new Double(fields[7]));
                map.put("INTPTLAT", new Double(fields[8]));
                map.put("INTPTLONG", new Double(fields[9]));

                if (ret.putIfAbsent(geoid, map) != null) {
                    throw new IllegalArgumentException("Duplicate geoid " + geoid);
                }
            }
        }

        return ret;
    }
}
