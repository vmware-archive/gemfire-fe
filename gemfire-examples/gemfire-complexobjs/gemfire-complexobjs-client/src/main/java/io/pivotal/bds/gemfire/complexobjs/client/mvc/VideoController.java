package io.pivotal.bds.gemfire.complexobjs.client.mvc;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.complexobjs.client.exception.DuplicateException;
import io.pivotal.bds.gemfire.complexobjs.client.exception.NotFoundException;
import io.pivotal.bds.gemfire.complexobjs.common.Video;

@RestController
@RequestMapping("/video")
public class VideoController {

	@Resource(name = "VideoRegion")
	private Region<String, Video> videoRegion;

	private static final Logger LOG = LoggerFactory.getLogger(VideoController.class);

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "video/avi")
	public byte[] getVideo(@PathVariable("id") String id) {
		LOG.debug("getVideo: id={}", id);
		Video vid = videoRegion.get(id);

		if (vid == null) {
			throw new NotFoundException("Video " + id + " not found");
		}

		return vid.getData();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST, consumes = "video/avi")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void createVideo(@PathVariable("id") String id, @RequestBody byte[] data) {
		LOG.debug("createVideo: id={}", id);
		Video vid = new Video(id, data, "video/avi");

		if (videoRegion.putIfAbsent(id, vid) != null) {
			throw new DuplicateException("Video " + id + " already exists");
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = "video/avi")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateVideo(@PathVariable("id") String id, @RequestBody byte[] data) {
		LOG.debug("updateVideo: id={}", id);
		Video vid = new Video(id, data, "video/avi");

		if (videoRegion.replace(id, vid) == null) {
			throw new NotFoundException("Video " + id + " not found");
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteVideo(@PathVariable("id") String id) {
		LOG.debug("deleteVideo: id={}", id);
		if (videoRegion.remove(id) == null) {
			throw new NotFoundException("Video " + id + " not found");
		}
	}
}
