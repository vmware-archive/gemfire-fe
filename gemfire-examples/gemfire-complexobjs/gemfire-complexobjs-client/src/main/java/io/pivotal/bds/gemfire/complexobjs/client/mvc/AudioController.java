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

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.complexobjs.client.exception.DuplicateException;
import io.pivotal.bds.gemfire.complexobjs.client.exception.NotFoundException;
import io.pivotal.bds.gemfire.complexobjs.common.Audio;

@RestController
@RequestMapping("/audio")
public class AudioController {

	@Resource(name = "AudioRegion")
	private Region<String, Audio> audioRegion;

	private static final Logger LOG = LoggerFactory.getLogger(AudioController.class);

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "audio/mpeg3")
	public byte[] getAudio(@PathVariable("id") String id) {
		LOG.debug("getAudio: id={}", id);
		Audio aud = audioRegion.get(id);

		if (aud == null) {
			throw new NotFoundException("Audio " + id + " not found");
		}

		return aud.getData();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST, consumes = "audio/mpeg3")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void createAudio(@PathVariable("id") String id, @RequestBody byte[] data) {
		LOG.debug("createAudio: id={}", id);
		Audio aud = new Audio(id, data, "audio/mpeg3");

		if (audioRegion.putIfAbsent(id, aud) != null) {
			throw new DuplicateException("Audio " + id + " already exists");
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = "audio/mpeg3")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateAudio(@PathVariable("id") String id, @RequestBody byte[] data) {
		LOG.debug("updateAudio: id={}", id);
		Audio aud = new Audio(id, data, "audio/mpeg3");

		if (audioRegion.replace(id, aud) == null) {
			throw new NotFoundException("Audio " + id + " not found");
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAudio(@PathVariable("id") String id) {
		LOG.debug("deleteAudio: id={}", id);
		if (audioRegion.remove(id) == null) {
			throw new NotFoundException("Audio " + id + " not found");
		}
	}
}
