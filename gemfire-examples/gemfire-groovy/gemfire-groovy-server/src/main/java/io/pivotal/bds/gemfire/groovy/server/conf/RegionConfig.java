package io.pivotal.bds.gemfire.groovy.server.conf;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.util.Assert;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.PartitionAttributes;
import org.apache.geode.cache.PartitionAttributesFactory;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionFactory;
import org.apache.geode.cache.RegionShortcut;

import io.pivotal.bds.gemfire.data.securities.Account;
import io.pivotal.bds.gemfire.data.securities.AccountKey;
import io.pivotal.bds.gemfire.data.securities.Issuer;
import io.pivotal.bds.gemfire.data.securities.IssuerKey;
import io.pivotal.bds.gemfire.data.securities.Security;
import io.pivotal.bds.gemfire.data.securities.SecurityKey;
import io.pivotal.bds.gemfire.data.securities.Trade;
import io.pivotal.bds.gemfire.data.securities.TradeKey;
import io.pivotal.bds.gemfire.groovy.common.Constants;
import io.pivotal.bds.gemfire.keyfw.generator.ColocationKeyGenerator;
import io.pivotal.bds.gemfire.keyfw.generator.ConfiguredIDPrefixCacheLoader;
import io.pivotal.bds.gemfire.keyfw.generator.DefaultColocationKeyGenerator;
import io.pivotal.bds.gemfire.keyfw.generator.IDGenerator;
import io.pivotal.bds.gemfire.keyfw.generator.RegionLongIDGenerator;
import io.pivotal.bds.gemfire.keyfw.resolver.ColocationIDPartitionResolver;

@Configuration
public class RegionConfig implements Constants {

    @Resource(name = ACCOUNT_REGION_BEAN_NAME)
    private Region<AccountKey, Account> accountRegion;

    private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

    @Bean
    public IDGenerator<Long> createIdGenerator(Cache cache) {
        LOG.info("creating IDGenerator");
        
        RegionFactory<String, Long> idrf = cache.createRegionFactory(RegionShortcut.LOCAL_PERSISTENT);
        idrf.setCacheLoader(new ConfiguredIDPrefixCacheLoader());
        Region<String, Long> idr = idrf.create(ID_REGION_NAME);
        
        IDGenerator<Long> idgen = new RegionLongIDGenerator(idr);
        return idgen;
    }

    @Bean
    public ColocationKeyGenerator<Long, String> createColocationKeyGenerator(IDGenerator<Long> idGenerator) {
        LOG.info("creating ColocationKeyGenerator");
        return new DefaultColocationKeyGenerator<>(idGenerator);
    }

    @Bean(name = ISSUER_REGION_BEAN_NAME)
    public Region<IssuerKey, Issuer> createIssuerRegion(Cache cache) {
        LOG.info("creating {}", ISSUER_REGION_BEAN_NAME);
        RegionFactory<IssuerKey, Issuer> rf = cache.createRegionFactory(RegionShortcut.REPLICATE_PERSISTENT);
        return rf.create(ISSUER_REGION_NAME);
    }

    @Bean(name = SECURITY_REGION_BEAN_NAME)
    public Region<SecurityKey, Security> createSecurityRegion(Cache cache) {
        LOG.info("creating {}", SECURITY_REGION_BEAN_NAME);
        RegionFactory<SecurityKey, Security> rf = cache.createRegionFactory(RegionShortcut.REPLICATE_PERSISTENT);
        return rf.create(SECURITY_REGION_NAME);
    }

    @Bean(name = ACCOUNT_REGION_BEAN_NAME)
    public Region<AccountKey, Account> createAccountRegion(Cache cache) {
        LOG.info("creating {}", ACCOUNT_REGION_BEAN_NAME);
        RegionFactory<AccountKey, Account> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);
        return rf.create(ACCOUNT_REGION_NAME);
    }

    @Bean(name = TRADE_REGION_BEAN_NAME)
    @DependsOn(ACCOUNT_REGION_BEAN_NAME)
    public Region<TradeKey, Trade> createTradeRegion(Cache cache) {
        LOG.info("creating {}", TRADE_REGION_BEAN_NAME);

        Assert.notNull(accountRegion, ACCOUNT_REGION_BEAN_NAME + " is null");

        RegionFactory<TradeKey, Trade> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT_OVERFLOW);

        PartitionAttributesFactory<TradeKey, Trade> paf = new PartitionAttributesFactory<>();
        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setPartitionResolver(new ColocationIDPartitionResolver<>());
        PartitionAttributes<TradeKey, Trade> pa = paf.create();
        rf.setPartitionAttributes(pa);

        return rf.create(TRADE_REGION_NAME);
    }

}
