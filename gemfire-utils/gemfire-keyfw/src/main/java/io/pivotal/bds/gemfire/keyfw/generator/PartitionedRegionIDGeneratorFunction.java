package io.pivotal.bds.gemfire.keyfw.generator;

import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.Function;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.cache.execute.RegionFunctionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.Set;

public class PartitionedRegionIDGeneratorFunction implements Function, Declarable {

    private String idRegionName;
    private int idCount;
    private Region<String, Long> idRegion;
    private static final Logger LOG = LoggerFactory.getLogger(PartitionedRegionIDGeneratorFunction.class);

    public PartitionedRegionIDGeneratorFunction() {
    }

    public PartitionedRegionIDGeneratorFunction(String idRegionName, int idCount) {
        this.idRegionName = idRegionName;
        this.idCount = idCount;
    }

    public PartitionedRegionIDGeneratorFunction(int idCount, Region<String, Long> idRegion) {
        this.idCount = idCount;
        this.idRegion = idRegion;
    }

    @Override
    public void execute(FunctionContext functionContext) {
        try {
            String domain = null;
            Object arguments = functionContext.getArguments();

            if (arguments != null) {
                if (arguments.getClass().isArray()) {
                    Object[] args = (Object[]) arguments;
                    assert args.length == 1;
                    domain = args[0].toString();
                } else {
                    domain = arguments.toString();
                }
            } else {
                RegionFunctionContext rctx = (RegionFunctionContext) functionContext;
                Set<String> filter = (Set<String>) rctx.getFilter();
                assert filter.size() == 1;
                domain = filter.iterator().next();
            }

            LOG.debug("execute: domain={}", domain);
            Region<String, Long> region = getRegion();

            synchronized (PartitionedRegionIDGeneratorFunction.class) {
                Long firstId = region.computeIfAbsent(domain, t -> -1L) + 1;
                long lastId = firstId + idCount - 1;
                LOG.debug("execute: domain={}, firstId={}, lastId={}", domain, firstId, lastId);
                region.put(domain, lastId);
                functionContext.getResultSender().lastResult(new long[]{firstId, lastId});
            }
        } catch (Exception x) {
            LOG.error("execute: x={}", x.toString(), x);
            throw new IllegalArgumentException(x.toString(), x);
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
    public boolean optimizeForWrite() {
        return true;
    }

    @Override
    public boolean isHA() {
        return true;
    }

    @Override
    public void init(Properties properties) {
        idRegionName = properties.getProperty("idRegionName", "id");
        idCount = Integer.parseInt(properties.getProperty("idCount", "1000"));
        LOG.info("init: idRegionName={}, idCount={}", idRegionName, idCount);
    }

    private Region<String, Long> getRegion() {
        if (idRegion == null) {
            idRegion = CacheFactory.getAnyInstance().getRegion(idRegionName);
        }

        return idRegion;
    }
}
