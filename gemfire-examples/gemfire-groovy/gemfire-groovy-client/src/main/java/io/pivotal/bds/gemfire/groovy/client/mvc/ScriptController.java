package io.pivotal.bds.gemfire.groovy.client.mvc;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.groovy.common.Constants;

@RestController
public class ScriptController implements Constants {

    @Resource(name = SCRIPT_REGION_BEAN_NAME)
    private Region<String, String> scriptRegion;

    private static final Logger LOG = LoggerFactory.getLogger(ScriptController.class);

    @RequestMapping(value = "/script", consumes = "text/plain", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void uploadScript(@RequestParam("name") String name, @RequestBody String script) {
        LOG.info("uploadScript: name={}, script={}", name, script);
        scriptRegion.put(name, script);
    }
}
