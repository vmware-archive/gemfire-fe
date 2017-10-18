package io.pivotal.bds.gemfire.groovy.client.mvc;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.data.securities.Issuer;
import io.pivotal.bds.gemfire.data.securities.IssuerKey;
import io.pivotal.bds.gemfire.data.securities.Security;
import io.pivotal.bds.gemfire.data.securities.SecurityKey;
import io.pivotal.bds.gemfire.groovy.common.Constants;

@RestController
public class SecurityController implements Constants {

    @Resource(name = ISSUER_REGION_BEAN_NAME)
    private Region<IssuerKey, Issuer> issuerRegion;

    @Resource(name = SECURITY_REGION_BEAN_NAME)
    private Region<SecurityKey, Security> securityRegion;

    private static final Logger LOG = LoggerFactory.getLogger(SecurityController.class);

    @RequestMapping(value = "/issuer", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createIssuer(@RequestParam("id") String id, @RequestParam("name") String name) {
        LOG.info("createIssuer: id={}, name={}", id, name);

        IssuerKey key = new IssuerKey(id);
        Issuer iss = new Issuer(key, name);
        issuerRegion.putIfAbsent(key, iss);
    }

    @RequestMapping(value = "/security", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createSecurity(@RequestParam("id") String id, @RequestParam("description") String desc,
            @RequestParam("issuerId") String issId, @RequestParam("price") double price) {
        LOG.info("createSecurity: id={}, desc={}, issId={}, price={}", id, desc, issId, price);

        IssuerKey ik = new IssuerKey(issId);
        Issuer iss = issuerRegion.get(ik);
        Assert.notNull(iss, "Issuer " + ik.getId() + " not found");

        SecurityKey key = new SecurityKey(id);
        Security sec = new Security(key, desc, ik);

        securityRegion.putIfAbsent(key, sec);
    }
}
