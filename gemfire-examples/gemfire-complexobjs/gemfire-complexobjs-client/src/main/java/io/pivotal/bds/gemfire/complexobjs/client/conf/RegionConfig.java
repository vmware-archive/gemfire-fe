package io.pivotal.bds.gemfire.complexobjs.client.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.cache.client.Pool;

import io.pivotal.bds.gemfire.complexobjs.common.Audio;
import io.pivotal.bds.gemfire.complexobjs.common.Image;
import io.pivotal.bds.gemfire.complexobjs.common.Video;

@Configuration
public class RegionConfig {

	@Autowired
	private Pool pool;

	private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

	@Bean(name = "ImageRegion")
	public Region<String, Image> createImageRegion(ClientCache cache) {
		LOG.info("creating Image Region");
		ClientRegionFactory<String, Image> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
		crf.setPoolName(pool.getName());
		Region<String, Image> r = crf.create("Image");
		return r;
	}

	@Bean(name = "AudioRegion")
	public Region<String, Audio> createAudioRegion(ClientCache cache) {
		LOG.info("creating Audio Region");
		ClientRegionFactory<String, Audio> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
		crf.setPoolName(pool.getName());
		Region<String, Audio> r = crf.create("Audio");
		return r;
	}

	@Bean(name = "VideoRegion")
	public Region<String, Video> createVideoRegion(ClientCache cache) {
		LOG.info("creating Video Region");
		ClientRegionFactory<String, Video> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
		crf.setPoolName(pool.getName());
		Region<String, Video> r = crf.create("Video");
		return r;
	}
}
