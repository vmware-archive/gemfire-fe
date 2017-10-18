package io.pivotal.bds.gemfire.geo.function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.FunctionException;
import org.apache.geode.cache.execute.RegionFunctionContext;
import org.apache.geode.cache.execute.ResultSender;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;

import io.pivotal.bds.gemfire.geo.data.Boundary;
import io.pivotal.bds.gemfire.geo.data.BoundaryKey;
import io.pivotal.bds.gemfire.geo.data.CreatePOIRequest;
import io.pivotal.bds.gemfire.geo.data.PointOfInterest;
import io.pivotal.bds.gemfire.geo.data.PointOfInterestKey;
import io.pivotal.bds.gemfire.geo.util.GeoUtil;
import io.pivotal.bds.gemfire.geo.util.KeyFrameworkHelper;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class CreatePOIFunction extends BaseLockingFunction {

    private int maxPOICount = 10;

    private static final Logger LOG = LoggerFactory.getLogger(CreatePOIFunction.class);
    private static final long serialVersionUID = 1L;

    @Override
    public synchronized void execute(FunctionContext ctx) {
        try {
            Region<BoundaryKey, Collection<PointOfInterestKey>> boundaryPOIXrefRegion = RegionHelper
                    .getRegion(BOUNDARY_POI_XREF_REGION_NAME);
            Region<PointOfInterestKey, PointOfInterest> poiRegion = RegionHelper.getRegion(POI_REGION_NAME);
            Region<PointOfInterestKey, BoundaryKey> poiBoundaryXrefRegion = RegionHelper.getRegion(POI_BOUNDARY_XREF_REGION_NAME);
            Region<BoundaryKey, Boundary> boundaryRegion = RegionHelper.getRegion(BOUNDARY_REGION_NAME);

            RegionFunctionContext rctx = (RegionFunctionContext) ctx;
            Set<?> filter = rctx.getFilter();
            LOG.debug("execute: filter={}", filter);

            for (Object fo : filter) {
                CreatePOIRequest req = (CreatePOIRequest) fo;
                LOG.debug("execute: req={}", req);

                PointOfInterestKey poik = req.getPointOfInterestKey();
                PointOfInterest poi = req.getPointOfInterest();

                // add poi
                poiRegion.put(poik, poi);

                Point poig = poi.getLocation();

                writeLock.lock();

                try {
                    Boundary bound = GeoUtil.intersects(poig);
                    BoundaryKey bk = bound.getKey();

                    Collection<PointOfInterestKey> poiKeys = boundaryPOIXrefRegion.get(bk);

                    if (poiKeys.size() >= maxPOICount) {
                        LOG.debug("execute: poi count exceeded: req={}", req);
                        Geometry origGeom = bound.getGeometry();

                        // split the geo
                        List<Geometry> splitGeoms = GeoUtil.split(origGeom);
                        List<BoundaryKey> newBoundKeys = new ArrayList<>();

                        // create new sub-boundaries
                        for (Geometry newGeom : splitGeoms) {
                            BoundaryKey newBoundKey = KeyFrameworkHelper.getKeyGenerator().generate(BoundaryKey.class,
                                    bk.getColocationId());
                            Boundary newBound = new Boundary(newBoundKey, newGeom, null);

                            newBoundKeys.add(newBoundKey);
                            boundaryRegion.put(newBoundKey, newBound);
                        }

                        // update orig boundary
                        bound.setChildren(newBoundKeys);
                        boundaryRegion.put(bk, bound);

                        // move pois to new boundaries
                        for (PointOfInterestKey pk : poiKeys) {
                            PointOfInterest poit = poiRegion.get(pk);

                            Point poiGeo = poit.getLocation();

                            // find geo in new sub-boundaries
                            Boundary poiB = GeoUtil.intersects(bound, poiGeo);
                            Assert.notNull(poiB, "Cannot find boundary"); // should never happen
                            BoundaryKey poiBK = poiB.getKey();

                            // new xref for boundary-to-poi
                            Collection<PointOfInterestKey> poikc = boundaryPOIXrefRegion.get(poiBK);
                            poikc.add(pk);
                            boundaryPOIXrefRegion.put(poiBK, poikc);

                            // add xref for poi-to-boundary, replaces existing entry for old boundary
                            poiBoundaryXrefRegion.put(pk, poiBK);
                        }

                        // remove xrefs for orig boundary
                        boundaryPOIXrefRegion.remove(bk);
                    } else {
                        LOG.debug("execute: poi count NOT exceeded: req={}", req);
                        // add poi and update xrefs
                        poiKeys.add(poik);
                        poiBoundaryXrefRegion.put(poik, bk);
                        boundaryPOIXrefRegion.put(bk, poiKeys);
                    }

                } finally {
                    writeLock.unlock();
                }
            }

            ResultSender<Boolean> sender = ctx.getResultSender();
            sender.lastResult(Boolean.TRUE);
        } catch (Exception x) {
            LOG.error("execute: x={}", x.toString(), x);
            throw new FunctionException(x.toString(), x);
        }
    }

    @Override
    public void init(Properties props) {
        super.init(props);

        String maxPOICountString = props.getProperty("maxPOICount", "" + maxPOICount);
        LOG.info("init: maxPOICount={}", maxPOICountString);

        Assert.hasText(maxPOICountString, "Missing property 'maxPOICount'");
        maxPOICount = Integer.parseInt(maxPOICountString);
    }

}
