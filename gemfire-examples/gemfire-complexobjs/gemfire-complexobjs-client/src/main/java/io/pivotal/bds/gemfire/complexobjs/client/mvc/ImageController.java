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
import io.pivotal.bds.gemfire.complexobjs.common.Image;

@RestController
@RequestMapping("/image")
public class ImageController {

	@Resource(name = "ImageRegion")
	private Region<String, Image> imageRegion;

	private static final Logger LOG = LoggerFactory.getLogger(ImageController.class);

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "image/jpeg")
	public byte[] getImage(@PathVariable("id") String id) {
		LOG.debug("getImage: id={}", id);
		Image img = imageRegion.get(id);

		if (img == null) {
			throw new NotFoundException("Image " + id + " not found");
		}

		return img.getData();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST, consumes = "image/jpeg")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void createImage(@PathVariable("id") String id, @RequestBody byte[] data) {
		LOG.debug("createImage: id={}", id);
		Image img = new Image(id, data, "image/jpeg");

		if (imageRegion.putIfAbsent(id, img) != null) {
			throw new DuplicateException("Image " + id + " already exists");
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = "image/jpeg")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateImage(@PathVariable("id") String id, @RequestBody byte[] data) {
		LOG.debug("updateImage: id={}", id);
		Image img = new Image(id, data, "image/jpeg");

		if (imageRegion.replace(id, img) == null) {
			throw new NotFoundException("Image " + id + " not found");
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteImage(@PathVariable("id") String id) {
		LOG.debug("deleteImage: id={}", id);
		if (imageRegion.remove(id) == null) {
			throw new NotFoundException("Image " + id + " not found");
		}
	}
}
