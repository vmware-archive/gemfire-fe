package io.pivotal.bds.gemfire.geo.function;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.Function;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.cache.execute.FunctionException;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.cache.execute.ResultSender;
import com.vividsolutions.jts.geom.Point;

import io.pivotal.bds.gemfire.geo.Constants;
import io.pivotal.bds.gemfire.geo.data.Boundary;
import io.pivotal.bds.gemfire.geo.data.BoundaryKey;
import io.pivotal.bds.gemfire.geo.data.CreatePOIRequest;
import io.pivotal.bds.gemfire.geo.data.PointOfInterest;
import io.pivotal.bds.gemfire.geo.data.PointOfInterestKey;
import io.pivotal.bds.gemfire.geo.util.GeoUtil;
import io.pivotal.bds.gemfire.geo.util.KeyFrameworkHelper;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class InitialCreatePOIFunction implements Function, Declarable, Constants {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(InitialCreatePOIFunction.class);

    @Override
    public void execute(FunctionContext ctx) {
        try {
            ResultSender<Boolean> sender = ctx.getResultSender();
            Region<BoundaryKey, Boundary> boundaryRegion = RegionHelper.getRegion(BOUNDARY_REGION_NAME);

            PointOfInterest poi = (PointOfInterest) ctx.getArguments();
            LOG.debug("execute: initial poi={}", poi);

            Point loc = poi.getLocation();

            Boundary bound = GeoUtil.intersects(loc);
            BoundaryKey boundKey = bound.getKey();

            PointOfInterestKey poiKey = KeyFrameworkHelper.getKeyGenerator().generate(PointOfInterestKey.class,
                    boundKey.getColocationId());
            poi.setKey(poiKey);
            LOG.debug("execute: final poi={}", poi);

            CreatePOIRequest req = new CreatePOIRequest(poiKey, poi);

            Set<CreatePOIRequest> filter = new HashSet<>();
            filter.add(req);

            FunctionService.onRegion(boundaryRegion).withFilter(filter).execute("CreatePOIFunction");
            sender.lastResult(Boolean.TRUE);
        } catch (Exception x) {
            LOG.error("execute: x={}", x.toString(), x);
            throw new FunctionException(x.toString(), x);
        }
    }

    @Override
    public String getId() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean hasResult() {
        return true;
    }

    @Override
    public boolean isHA() {
        return true;
    }

    @Override
    public boolean optimizeForWrite() {
        return true;
    }

    @Override
    public void init(Properties props) {
    }

}
