package io.pivotal.bds.gemfire.groovy.client.conf;

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

import io.pivotal.bds.gemfire.data.ecom.Account;
import io.pivotal.bds.gemfire.data.ecom.AccountKey;
import io.pivotal.bds.gemfire.data.securities.Issuer;
import io.pivotal.bds.gemfire.data.securities.IssuerKey;
import io.pivotal.bds.gemfire.data.securities.Security;
import io.pivotal.bds.gemfire.data.securities.SecurityKey;
import io.pivotal.bds.gemfire.groovy.common.Constants;

@Configuration
public class RegionConfig implements Constants {

    @Autowired
    private Pool pool;

    private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

    @Bean(name = SCRIPT_REGION_BEAN_NAME)
    public Region<String, String> createScriptRegion(ClientCache cache) {
        LOG.info("creating {}", SCRIPT_REGION_BEAN_NAME);
        ClientRegionFactory<String, String> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        crf.setPoolName(pool.getName());
        Region<String, String> r = crf.create(SCRIPT_REGION_NAME);
        return r;
    }

    @Bean(name = ISSUER_REGION_BEAN_NAME)
    public Region<IssuerKey, Issuer> createIssuerRegion(ClientCache cache) {
        LOG.info("creating {}", ISSUER_REGION_BEAN_NAME);
        ClientRegionFactory<IssuerKey, Issuer> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        crf.setPoolName(pool.getName());
        Region<IssuerKey, Issuer> r = crf.create(ISSUER_REGION_NAME);
        return r;
    }

    @Bean(name = SECURITY_REGION_BEAN_NAME)
    public Region<SecurityKey, Security> createSecurityRegion(ClientCache cache) {
        LOG.info("creating {}", SECURITY_REGION_BEAN_NAME);
        ClientRegionFactory<SecurityKey, Security> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        crf.setPoolName(pool.getName());
        Region<SecurityKey, Security> r = crf.create(SECURITY_REGION_NAME);
        return r;
    }

    @Bean(name = ACCOUNT_REGION_BEAN_NAME)
    public Region<AccountKey, Account> createAccountRegion(ClientCache cache) {
        LOG.info("creating {}", ACCOUNT_REGION_BEAN_NAME);
        ClientRegionFactory<AccountKey, Account> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        crf.setPoolName(pool.getName());
        Region<AccountKey, Account> r = crf.create(ACCOUNT_REGION_NAME);
        return r;
    }
}
