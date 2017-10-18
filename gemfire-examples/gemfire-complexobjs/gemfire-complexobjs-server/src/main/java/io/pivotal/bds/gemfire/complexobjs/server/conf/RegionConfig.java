package io.pivotal.bds.gemfire.complexobjs.server.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionFactory;
import org.apache.geode.cache.RegionShortcut;

import io.pivotal.bds.gemfire.complexobjs.common.Audio;
import io.pivotal.bds.gemfire.complexobjs.common.Image;
import io.pivotal.bds.gemfire.complexobjs.common.Video;
import io.pivotal.bds.gemfire.complexobjs.server.loader.ImageCacheLoader;

@Configuration
public class RegionConfig {

	@Autowired
	private PropertyConfig propertyConfig;

	private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

	@Bean(name = "ImageRegion")
	public Region<String, Image> createImageRegion(Cache cache) {
		LOG.info("creating Image Region");
		RegionFactory<String, Image> crf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT_OVERFLOW);
		crf.setCacheLoader(new ImageCacheLoader(propertyConfig.imageBaseURL));
		Region<String, Image> r = crf.create("Image");
		return r;
	}

	@Bean(name = "AudioRegion")
	public Region<String, Audio> createAudioRegion(Cache cache) {
		LOG.info("creating Audio Region");
		RegionFactory<String, Audio> crf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT_OVERFLOW);
		Region<String, Audio> r = crf.create("Audio");
		return r;
	}

	@Bean(name = "VideoRegion")
	public Region<String, Video> createVideoRegion(Cache cache) {
		LOG.info("creating Video Region");
		RegionFactory<String, Video> crf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT_OVERFLOW);
		Region<String, Video> r = crf.create("Video");
		return r;
	}
}
