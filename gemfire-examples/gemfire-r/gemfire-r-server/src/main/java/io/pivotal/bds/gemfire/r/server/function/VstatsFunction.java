package io.pivotal.bds.gemfire.r.server.function;

import java.util.Properties;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.Function;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.cache.execute.FunctionException;
import com.gemstone.gemfire.cache.execute.ResultSender;

import io.pivotal.bds.gemfire.r.common.StatsResponse;
import io.pivotal.bds.gemfire.r.common.Vector;
import io.pivotal.bds.gemfire.r.common.VectorKey;
import io.pivotal.bds.gemfire.r.common.VstatsRequest;
import io.pivotal.bds.gemfire.util.RegionHelper;

@SuppressWarnings("serial")
public class VstatsFunction implements Function, Declarable {

    @Override
    public void execute(FunctionContext ctx) {
        try {
            VstatsRequest req = (VstatsRequest) ctx.getArguments();
            VectorKey vectorKey = req.getVectorKey();

            Region<VectorKey, Vector<Object>> vectorRegion = RegionHelper.getRegion("vector");
            Vector<Object> vector = vectorRegion.get(vectorKey);
            Assert.notNull(vector, "Vector " + vectorKey.getId() + " not found");

            DescriptiveStatistics stats = new DescriptiveStatistics();

            for (Object o : vector.getVector()) {
                if (!Number.class.isInstance(o)) {
                    throw new IllegalArgumentException("Vector " + vectorKey.getId() + " contains non-numerics");
                }

                Number n = (Number) o;
                double d = n.doubleValue();
                stats.addValue(d);
            }

            ResultSender<StatsResponse> sender = ctx.getResultSender();
            StatsResponse resp = new StatsResponse(stats);
            sender.lastResult(resp);
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
        return true;
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
