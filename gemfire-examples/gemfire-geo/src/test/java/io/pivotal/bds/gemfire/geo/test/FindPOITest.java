package io.pivotal.bds.gemfire.geo.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;

import io.pivotal.bds.gemfire.geo.Constants;
import io.pivotal.bds.gemfire.geo.data.Boundary;
import io.pivotal.bds.gemfire.geo.data.BoundaryKey;
import io.pivotal.bds.gemfire.geo.data.FindPOIRequest;
import io.pivotal.bds.gemfire.geo.data.FindPOIResponse;
import io.pivotal.bds.gemfire.geo.data.PointOfInterest;
import io.pivotal.bds.gemfire.geo.data.PointOfInterestKey;

public class FindPOITest implements Constants {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();
        ccf.addPoolLocator("localhost", 10334);
        ccf.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.geo.data.*,io.pivotal.bds.gemfire.key.*"));

        ClientCache cc = ccf.create();

        try {
            ClientRegionFactory<BoundaryKey, Boundary> crf = cc.createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY);
            Region<BoundaryKey, Boundary> r = crf.create(ROOT_BOUNDARY_REGION_NAME);

            ClientRegionFactory<PointOfInterestKey, PointOfInterest> crfp = cc
                    .createClientRegionFactory(ClientRegionShortcut.PROXY);
            Region<PointOfInterestKey, PointOfInterest> rp = crfp.create(POI_REGION_NAME);

            GeometryFactory factory = new GeometryFactory();
            Random random = new Random();

            Set<FindPOIRequest> filter = new HashSet<>();

            for (int i = 0; i < 10; ++i) {
                double lx = -5.0 + (10.0 * random.nextDouble());
                double rx = lx + (5.0 * random.nextDouble());

                double by = -5.0 + (10.0 * random.nextDouble());
                double ty = by + (5.0 * random.nextDouble());

                Coordinate[] coords = new Coordinate[5];

                coords[0] = new Coordinate(lx, by);
                coords[1] = new Coordinate(lx, ty);
                coords[2] = new Coordinate(rx, ty);
                coords[3] = new Coordinate(rx, by);
                coords[4] = new Coordinate(lx, by);

                Polygon poly = factory.createPolygon(coords);
                List<Boundary> bounds = find(poly, r);

                for (Boundary nb : bounds) {
                    FindPOIRequest req = new FindPOIRequest(nb.getKey(), poly);
                    filter.add(req);
                }

                if (filter.size() >= 10) {
                    long start = System.currentTimeMillis();

                    Object res = FunctionService.onRegion(r).withFilter(filter).execute("FindPOIFunction").getResult();

                    long end = System.currentTimeMillis();
                    long delta = end - start;
                    System.out.println("delta = " + delta + ", res = " + res);

                    filter = new HashSet<>();
                }
            }

            if (!filter.isEmpty()) {
                long start = System.currentTimeMillis();

                @SuppressWarnings("unchecked")
                List<FindPOIResponse> res = (List<FindPOIResponse>) FunctionService.onRegion(r).withFilter(filter)
                        .execute("FindPOIFunction").getResult();

                long end = System.currentTimeMillis();
                long delta = end - start;
                System.out.println("delta = " + delta);

                for (FindPOIResponse resp : res) {
                    for (List<PointOfInterestKey> pks : resp.getResponse().values()) {
                        for (PointOfInterestKey poik : pks) {
                            PointOfInterest poi = rp.get(poik);
                            System.out.println("   " + poi);
                        }
                    }
                }
            }
        } finally {
            cc.close();
        }
    }

    private static List<Boundary> find(Polygon poly, Region<BoundaryKey, Boundary> r) {
        List<Boundary> list = new ArrayList<>();

        for (long id = 0; id < 100; ++id) {
            BoundaryKey bk = new BoundaryKey(id, id);
            Boundary b = r.get(bk);
            Geometry geo = b.getGeometry();

            if (geo.intersects(poly)) {
                list.add(b);
            }
        }

        return list;
    }
}
