package io.pivotal.bds.gemfire.keyfw.generator;

import java.util.Properties;

import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Region;

public class DeclarableGenerateIDFunction extends BaseGenerateIDFunction<Long>implements Declarable {

    private String regionName;
    private IDGenerator<Long> generator;

    private static final long serialVersionUID = 1L;

    @Override
    public void init(Properties props) {
        regionName = System.getProperty("gemfire.keyfw.idgenerator.region-name", "id");
        regionName = props.getProperty("idgenerator.region-name", regionName);
        log.info("using region {}", regionName);

        String id = System.getProperty("gemfire.keyfw.idgenerator.function-id", BaseGenerateIDFunction.class.getSimpleName());
        id = props.getProperty("idgenerator.function-id", id);
        log.info("using id {}", id);
        setId(id);
    }

    @Override
    protected synchronized IDGenerator<Long> getGenerator() {
        if (generator == null) {
            Region<String, Long> region = CacheFactory.getAnyInstance().getRegion(regionName);
            Assert.notNull(region, "Unknown region " + regionName);

            generator = new RegionLongIDGenerator(region);
        }

        return generator;
    }

}
