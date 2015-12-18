package io.pivotal.bds.gemfire.keyfw.generator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.cache.execute.ResultCollector;

public class OnRegionFunctionIDGenerator<T> implements IDGenerator<T> {

    private Region<String, T> region;

    public OnRegionFunctionIDGenerator(Region<String, T> region) {
        this.region = region;
    }

    @Override
    public T generate(String domain) {
        Set<String> filter = new HashSet<>();
        filter.add(domain);

        ResultCollector<?, ?> coll = FunctionService.onRegion(region).withFilter(filter)
                .execute(BaseGenerateIDFunction.class.getSimpleName());
        
        @SuppressWarnings("unchecked")
        List<T> list = (List<T>) coll.getResult();
        return list.get(0);
    }

}
