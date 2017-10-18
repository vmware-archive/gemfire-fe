package io.pivotal.bds.gemfire.complexobjs.server.loader;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.LoaderHelper;

import io.pivotal.bds.gemfire.complexobjs.common.Image;

public class ImageCacheLoader implements CacheLoader<String, Image>, Declarable {

	private String baseURL = "http://static.panoramio.com/photos/large/{id}";
	private String defaultMimeType = "image/jpeg";
	private final RestTemplate template = new RestTemplate();

	private static final Logger LOG = LoggerFactory.getLogger(ImageCacheLoader.class);

	public ImageCacheLoader() {
	}

	public ImageCacheLoader(String baseURL) {
		if (baseURL != null) {
			this.baseURL = baseURL;
		}
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	@Override
	public Image load(LoaderHelper<String, Image> helper) throws CacheLoaderException {
		String id = helper.getKey();
		LOG.debug("load: id={}", id);

		ResponseEntity<byte[]> resp = template.getForEntity(baseURL, byte[].class, id);

		if (resp.getStatusCode() == HttpStatus.OK) {
			LOG.debug("load: found image, id={}", id);
			return new Image(id, resp.getBody(), defaultMimeType);
		} else if (resp.getStatusCode() == HttpStatus.NOT_FOUND) {
			LOG.debug("load: did not find image, id={}", id);
			return null;
		} else {
			LOG.error("load: id={}, status={}", id, resp.getStatusCode());
			throw new CacheLoaderException(resp.getStatusCode().getReasonPhrase());
		}
	}

	@Override
	public void init(Properties props) {
		baseURL = props.getProperty("baseURL", baseURL);
		LOG.info("init: baseURL={}", baseURL);
	}

	@Override
	public void close() {
	}

}
