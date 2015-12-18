package io.pivotal.bds.gemfire.geo.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.Function;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.cache.execute.FunctionException;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;

import io.pivotal.bds.gemfire.geo.Constants;
import io.pivotal.bds.gemfire.geo.data.Boundary;
import io.pivotal.bds.gemfire.geo.data.BoundaryKey;
import io.pivotal.bds.gemfire.geo.util.GeoUtil;
import io.pivotal.bds.gemfire.geo.util.KeyFrameworkHelper;
import io.pivotal.bds.gemfire.util.RegionHelper;

@SuppressWarnings("serial")
public class PopulateBoundaryFunction implements Function, Declarable, Constants {

    private static final GeometryFactory factory = new GeometryFactory();

    @Override
    public void execute(FunctionContext ctx) {
        try {
            Region<BoundaryKey, Boundary> rootBoundaryRegion = RegionHelper.getRegion(ROOT_BOUNDARY_REGION_NAME);
            Region<BoundaryKey, Boundary> boundaryRegion = RegionHelper.getRegion(BOUNDARY_REGION_NAME);

            Coordinate[] rootCoords = new Coordinate[5];

            rootCoords[0] = new Coordinate(-180.0, -90.0);
            rootCoords[1] = new Coordinate(-180.0, +90.0);
            rootCoords[2] = new Coordinate(+180.0, +90.0);
            rootCoords[3] = new Coordinate(+180.0, -90.0);
            rootCoords[4] = new Coordinate(-180.0, -90.0);

            Polygon rootPoly = factory.createPolygon(rootCoords);

            List<Geometry> rootList = GeoUtil.split(rootPoly);

            for (int i = 0; i < rootList.size(); ++i) {
                Geometry rootGeo = rootList.get(i);
                long id = (long) i;

                List<Geometry> list = GeoUtil.split(rootGeo);
                List<BoundaryKey> children = new ArrayList<>();

                for (int j = 0; j < list.size(); ++j) {
                    Geometry geo = list.get(j);
                    BoundaryKey bk = KeyFrameworkHelper.getKeyGenerator().generate(BoundaryKey.class, id);
                    Boundary b = new Boundary(bk, geo, null);
                    children.add(bk);
                    boundaryRegion.put(bk, b);
                }

                BoundaryKey rootBoundaryKey = new BoundaryKey(id, id);
                Boundary rootBoundary = new Boundary(rootBoundaryKey, rootGeo, children);
                rootBoundaryRegion.put(rootBoundaryKey, rootBoundary);
            }
        } catch (Exception x) {
            throw new FunctionException(x.toString(), x);
        }
    }

    @Override
    public String getId() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean hasResult() {
        return false;
    }

    @Override
    public boolean isHA() {
        return false;
    }

    @Override
    public boolean optimizeForWrite() {
        return false;
    }

    @Override
    public void init(Properties props) {
    }

}
