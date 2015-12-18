package io.pivotal.bds.gemfire.geo.test;

import org.geotools.geometry.jts.GeometryBuilder;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;

import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

public class CRSTest {

    public static void main(String[] args) throws Exception {
        for (String auth : CRS.getSupportedAuthorities(false)) {
            System.out.println("authority: " + auth);

            for (String code : CRS.getSupportedCodes(auth)) {
                System.out.println("   code: " + code);
            }
        }
        
        System.out.println();

        CoordinateReferenceSystem latLonCRS = DefaultGeographicCRS.WGS84;
        CoordinateReferenceSystem cartCRS = CRS.decode("EPSG:26917");

        MathTransform cartToLatLon = CRS.findMathTransform(cartCRS, latLonCRS);
        MathTransform latLonToCart = CRS.findMathTransform(latLonCRS, cartCRS);

        GeometryBuilder build = new GeometryBuilder();

        Point latLonPt = build.point(-112.241597, 33.722719);
        System.out.println("latLonPt: " + latLonPt);

        Point cartPt = (Point) JTS.transform(latLonPt, latLonToCart);
        System.out.println("cartPt: " + cartPt);

        double x = cartPt.getX();
        double y = cartPt.getY();

        double xl = x - 2500;
        double xr = x + 2500;
        double yl = y - 2500;
        double yu = y + 2500;

        Polygon cartPoly = build.box(xl, yl, xr, yu);
        System.out.println("cartPoly: " + cartPoly);
        
        Polygon latLonPoly = (Polygon) JTS.transform(cartPoly, cartToLatLon);

        System.out.println("latLonPoly: " + latLonPoly);
    }
}
