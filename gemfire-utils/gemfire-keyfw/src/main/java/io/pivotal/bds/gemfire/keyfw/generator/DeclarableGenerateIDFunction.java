package io.pivotal.bds.gemfire.keyfw.generator;

import java.util.Properties;

import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Region;

public class DeclarableGenerateIDFunction extends BaseGenerateIDFunction<Long> implements Declarable {

	private IDGenerator<Long> generator;

	private static final long serialVersionUID = 1L;

	@Override
	public void init(Properties props) {
		String regionName = System.getProperty("gemfire.keyfw.idgenerator.region-name", "ID");
		regionName = props.getProperty("idgenerator.region-name", regionName);
		log.info("using region {}" + regionName);
		
		Region<String, Long> region = CacheFactory.getAnyInstance().getRegion(regionName);
		Assert.notNull(region, "Unknown region " + regionName);
		
		generator = new RegionLongIDGenerator(region);
		
		String id = System.getProperty("gemfire.keyfw.idgenerator.function-id", getClass().getSimpleName());
		id = props.getProperty("idgenerator.function-id", id);
		log.info("using id {}" + id);
		setId(id);
	}

	@Override
	protected IDGenerator<Long> getGenerator() {
		return generator;
	}

}
