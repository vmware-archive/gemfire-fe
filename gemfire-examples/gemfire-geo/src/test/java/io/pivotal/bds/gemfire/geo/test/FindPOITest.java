package io.pivotal.bds.gemfire.geo.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.geotools.geometry.jts.GeometryBuilder;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
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

            CoordinateReferenceSystem latLonCRS = DefaultGeographicCRS.WGS84;
            CoordinateReferenceSystem cartCRS = CRS.decode("EPSG:26917");

            MathTransform cartToLatLon = CRS.findMathTransform(cartCRS, latLonCRS);
            MathTransform latLonToCart = CRS.findMathTransform(latLonCRS, cartCRS);

            GeometryBuilder build = new GeometryBuilder();

            // Point latLonPt = build.point(-112.241597, 33.722719); /// home
            Point latLonPt = build.point(-112.298415, 33.418814);
            System.out.println("latLonPt: " + latLonPt);

            Point cartPt = (Point) JTS.transform(latLonPt, latLonToCart);
            System.out.println("cartPt: " + cartPt);

            double x = cartPt.getX();
            double y = cartPt.getY();

            double xl = x - 10000;
            double xr = x + 10000;
            double yl = y - 10000;
            double yu = y + 10000;

            Polygon cartPoly = build.box(xl, yl, xr, yu);
            System.out.println("cartPoly: " + cartPoly);

            Polygon latLonPoly = (Polygon) JTS.transform(cartPoly, cartToLatLon);
            System.out.println("latLonPoly: " + latLonPoly);

            Set<FindPOIRequest> filter = new HashSet<>();

            for (int i = 0; i < 10; ++i) {
                List<Boundary> bounds = find(latLonPoly, r);

                for (Boundary nb : bounds) {
                    FindPOIRequest req = new FindPOIRequest(nb.getKey(), latLonPoly);
                    filter.add(req);
                }

                if (filter.size() >= 10) {
                    go(filter, r, rp);
                    filter = new HashSet<>();
                }
            }

            if (!filter.isEmpty()) {
                go(filter, r, rp);
            }
        } finally {
            cc.close();
        }
    }

    private static void go(Set<FindPOIRequest> filter, Region<BoundaryKey, Boundary> r,
            Region<PointOfInterestKey, PointOfInterest> rp) {
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
