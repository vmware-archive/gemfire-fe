package io.pivotal.bds.gemfire.geo.test;

import java.io.BufferedReader;
import java.io.FileReader;

import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import io.pivotal.bds.gemfire.geo.Constants;
import io.pivotal.bds.gemfire.geo.data.PointOfInterest;
import io.pivotal.bds.gemfire.geo.data.PointOfInterestKey;

public class ImportPOI implements Constants {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();
        ccf.addPoolLocator("localhost", 10334);
        ccf.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.geo.data.*,io.pivotal.bds.gemfire.key.*"));

        ClientCache cc = ccf.create();

        try {
            Pool pool = cc.getDefaultPool();

            GeometryFactory factory = new GeometryFactory();
            int count = 0;

            FileReader fr = new FileReader("src/test/resources/enwikivoyage-20140905-listings.csv");

            try {
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine(); // header line

                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(";");

                    if (fields.length >= 18) {
                        String name = trim(fields[2]);
                        String slat = trim(fields[16]);
                        String slon = trim(fields[17]);

                        if (name != null && slat != null && slon != null) {
                            try {
                                double lat = Double.parseDouble(slat);
                                double lon = Double.parseDouble(slon);

                                if (checkLatitude(lat) && checkLongitude(lon)) {
                                    Point loc = factory.createPoint(new Coordinate(lon, lat));

                                    PointOfInterestKey pk = new PointOfInterestKey(0L, 0L);
                                    PointOfInterest p = new PointOfInterest(pk, loc, name, name);

                                    try {
                                        FunctionService.onServer(pool).withArgs(p).execute("InitialCreatePOIFunction");

                                        if (++count % 1000 == 0) {
                                            System.out.println("   " + count);
                                        }
                                    } catch (Exception x) {
                                        // ignore
                                    }
                                }
                            } catch (NumberFormatException x) {
                                // ignore
                            }
                        }
                    }
                }

                br.close();
            } finally {
                fr.close();
            }
        } finally {
            cc.close();
        }
    }

    private static boolean checkLatitude(double d) {
        return d >= -90.0 && d <= 90.0;
    }

    private static boolean checkLongitude(double d) {
        return d >= -180.0 && d <= 180.0;
    }

    private static String trim(String s) {
        s = s.trim();

        if (s.length() < 2) {
            return null;
        }

        s = s.substring(1, s.length() - 1).trim();

        if (s.length() == 0) {
            return null;
        }

        return s;
    }
}
