package io.pivotal.bds.gemfire.xrefs.client.conf;

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

import io.pivotal.bds.gemfire.data.securities.Account;
import io.pivotal.bds.gemfire.data.securities.AccountHistory;
import io.pivotal.bds.gemfire.data.securities.AccountHistoryKey;
import io.pivotal.bds.gemfire.data.securities.AccountKey;
import io.pivotal.bds.gemfire.data.securities.AccountStatus;
import io.pivotal.bds.gemfire.data.securities.ChangeRule;
import io.pivotal.bds.gemfire.data.securities.ChangeRuleKey;
import io.pivotal.bds.gemfire.data.securities.Issuer;
import io.pivotal.bds.gemfire.data.securities.IssuerKey;
import io.pivotal.bds.gemfire.data.securities.Security;
import io.pivotal.bds.gemfire.data.securities.SecurityKey;
import io.pivotal.bds.gemfire.data.securities.SecurityPriceStatus;
import io.pivotal.bds.gemfire.data.securities.Trade;
import io.pivotal.bds.gemfire.data.securities.TradeKey;
import io.pivotal.bds.gemfire.keyfw.generator.ColocationKeyGenerator;
import io.pivotal.bds.gemfire.keyfw.generator.DefaultColocationKeyGenerator;
import io.pivotal.bds.gemfire.keyfw.generator.DefaultKeyGenerator;
import io.pivotal.bds.gemfire.keyfw.generator.FunctionIDGenerator;
import io.pivotal.bds.gemfire.keyfw.generator.IDGenerator;
import io.pivotal.bds.gemfire.keyfw.generator.KeyGenerator;
import io.pivotal.bds.gemfire.xrefs.common.Constants;

@Configuration
public class RegionConfig implements Constants {

    @Autowired
    private Pool pool;

    private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

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

    @Bean(name = SECURITY_PRICE_STATUS_REGION_BEAN_NAME)
    public Region<SecurityKey, SecurityPriceStatus> createSecurityPriceStatusRegion(ClientCache cache) {
        LOG.info("creating {}", SECURITY_PRICE_STATUS_REGION_BEAN_NAME);
        ClientRegionFactory<SecurityKey, SecurityPriceStatus> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        crf.setPoolName(pool.getName());
        Region<SecurityKey, SecurityPriceStatus> r = crf.create(SECURITY_PRICE_STATUS_REGION_NAME);
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

    @Bean(name = ACCOUNT_HISTORY_REGION_BEAN_NAME)
    public Region<AccountHistoryKey, AccountHistory> createAccountHistoryRegion(ClientCache cache) {
        LOG.info("creating {}", ACCOUNT_HISTORY_REGION_BEAN_NAME);
        ClientRegionFactory<AccountHistoryKey, AccountHistory> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        crf.setPoolName(pool.getName());
        Region<AccountHistoryKey, AccountHistory> r = crf.create(ACCOUNT_HISTORY_REGION_NAME);
        return r;
    }

    @Bean(name = ACCOUNT_STATUS_REGION_BEAN_NAME)
    public Region<AccountKey, AccountStatus> createAccountStatusRegion(ClientCache cache) {
        LOG.info("creating {}", ACCOUNT_STATUS_REGION_BEAN_NAME);
        ClientRegionFactory<AccountKey, AccountStatus> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        crf.setPoolName(pool.getName());
        Region<AccountKey, AccountStatus> r = crf.create(ACCOUNT_STATUS_REGION_NAME);
        return r;
    }

    @Bean(name = CHANGE_RULE_REGION_BEAN_NAME)
    public Region<ChangeRuleKey, ChangeRule> createChangeRuleRegion(ClientCache cache) {
        LOG.info("creating {}", CHANGE_RULE_REGION_BEAN_NAME);
        ClientRegionFactory<ChangeRuleKey, ChangeRule> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        crf.setPoolName(pool.getName());
        Region<ChangeRuleKey, ChangeRule> r = crf.create(CHANGE_RULE_REGION_NAME);
        return r;
    }

    @Bean(name = TRADE_REGION_BEAN_NAME)
    public Region<TradeKey, Trade> createTradeRegion(ClientCache cache) {
        LOG.info("creating {}", TRADE_REGION_BEAN_NAME);
        ClientRegionFactory<TradeKey, Trade> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        crf.setPoolName(pool.getName());
        Region<TradeKey, Trade> r = crf.create(TRADE_REGION_NAME);
        return r;
    }

    @Bean
    public ColocationKeyGenerator<Long, String> createKeyGenerator() {
        LOG.info("creating KeyGenerator");
        IDGenerator<Long> idgen = new FunctionIDGenerator<>(pool);
        return new DefaultColocationKeyGenerator<>(idgen);
    }
}
