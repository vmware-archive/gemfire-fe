package io.pivotal.bds.gemfire.geojson.test;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.util.Assert;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.opengis.feature.simple.SimpleFeature;

import com.vividsolutions.jts.geom.Geometry;

public class ComparisonTest {

    private static SimpleFeatureCollection features;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @BeforeClass
    public static void before() throws Exception {
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

                Geometry geom = (Geometry) sf.getDefaultGeometry();
                Geometry env = geom.getEnvelope();

                geom.intersects(env);

                if (++count % 1000 == 0) {
                    System.out.println(count);
                }
            }
        }
    }
}
