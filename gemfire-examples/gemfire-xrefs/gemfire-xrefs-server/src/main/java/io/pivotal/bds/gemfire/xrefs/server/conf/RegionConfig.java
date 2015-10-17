package io.pivotal.bds.gemfire.xrefs.server.conf;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.PartitionAttributes;
import com.gemstone.gemfire.cache.PartitionAttributesFactory;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.RegionFactory;
import com.gemstone.gemfire.cache.RegionShortcut;
import com.gemstone.gemfire.cache.execute.FunctionService;

import io.pivotal.bds.gemfire.keyfw.generator.ColocationKeyGenerator;
import io.pivotal.bds.gemfire.keyfw.generator.ConfiguredIDPrefixCacheLoader;
import io.pivotal.bds.gemfire.keyfw.generator.DefaultColocationKeyGenerator;
import io.pivotal.bds.gemfire.keyfw.generator.DefaultGenerateIDFunction;
import io.pivotal.bds.gemfire.keyfw.generator.IDGenerator;
import io.pivotal.bds.gemfire.keyfw.generator.RegionLongIDGenerator;
import io.pivotal.bds.gemfire.keyfw.resolver.ColocationIDPartitionResolver;
import io.pivotal.bds.gemfire.xrefs.common.Account;
import io.pivotal.bds.gemfire.xrefs.common.AccountHistory;
import io.pivotal.bds.gemfire.xrefs.common.AccountHistoryKey;
import io.pivotal.bds.gemfire.xrefs.common.AccountKey;
import io.pivotal.bds.gemfire.xrefs.common.AccountNotification;
import io.pivotal.bds.gemfire.xrefs.common.AccountNotificationKey;
import io.pivotal.bds.gemfire.xrefs.common.AccountStatus;
import io.pivotal.bds.gemfire.xrefs.common.ChangeRule;
import io.pivotal.bds.gemfire.xrefs.common.ChangeRuleKey;
import io.pivotal.bds.gemfire.xrefs.common.Constants;
import io.pivotal.bds.gemfire.xrefs.common.Issuer;
import io.pivotal.bds.gemfire.xrefs.common.IssuerKey;
import io.pivotal.bds.gemfire.xrefs.common.Security;
import io.pivotal.bds.gemfire.xrefs.common.SecurityKey;
import io.pivotal.bds.gemfire.xrefs.common.SecurityPriceHistory;
import io.pivotal.bds.gemfire.xrefs.common.SecurityPriceHistoryKey;
import io.pivotal.bds.gemfire.xrefs.common.SecurityPriceStatus;
import io.pivotal.bds.gemfire.xrefs.common.Trade;
import io.pivotal.bds.gemfire.xrefs.common.TradeKey;
import io.pivotal.bds.gemfire.xrefs.server.data.PDXConcurrentList;
import io.pivotal.bds.gemfire.xrefs.server.listener.AccountChangeRuleXrefCacheListener;
import io.pivotal.bds.gemfire.xrefs.server.listener.AccountChangeRuleXrefPartitionListener;
import io.pivotal.bds.gemfire.xrefs.server.listener.AccountHistoryXrefCacheListener;
import io.pivotal.bds.gemfire.xrefs.server.listener.AccountHistoryXrefPartitionListener;
import io.pivotal.bds.gemfire.xrefs.server.listener.SecurityChangeRuleXrefCacheListener;
import io.pivotal.bds.gemfire.xrefs.server.listener.SecurityChangeRuleXrefPartitionListener;
import io.pivotal.bds.gemfire.xrefs.server.listener.SecurityPriceHistoryXrefCacheListener;
import io.pivotal.bds.gemfire.xrefs.server.listener.SecurityPriceHistoryXrefPartitionListener;
import io.pivotal.bds.gemfire.xrefs.server.listener.SecurityPriceStatusDeltaCacheListener;
import io.pivotal.bds.gemfire.xrefs.server.listener.SecurityPriceStatusUpdateCacheListener;
import io.pivotal.bds.gemfire.xrefs.server.listener.TradeAccountXrefCacheListener;
import io.pivotal.bds.gemfire.xrefs.server.listener.TradeAccountXrefPartitionListener;
import io.pivotal.bds.gemfire.xrefs.server.listener.TradeHistoryCacheListener;
import io.pivotal.bds.gemfire.xrefs.server.listener.TradeVolumeCacheListener;
import io.pivotal.bds.gemfire.xrefs.server.loader.PDXConcurrentListCacheLoader;

@Configuration
public class RegionConfig implements Constants {

    @Resource(name = ACCOUNT_TRADE_XREF_REGION_BEAN_NAME)
    private Region<AccountKey, PDXConcurrentList<TradeKey>> accountTradeXrefRegion;

    @Resource(name = ACCOUNT_HISTORY_XREF_REGION_BEAN_NAME)
    private Region<AccountKey, PDXConcurrentList<AccountHistoryKey>> accountHistoryXrefRegion;

    @Resource(name = ACCOUNT_CHANGE_RULE_XREF_REGION_BEAN_NAME)
    private Region<AccountKey, PDXConcurrentList<ChangeRuleKey>> accountChangeRuleXrefRegion;

    @Resource(name = SECURITY_CHANGE_RULE_XREF_REGION_BEAN_NAME)
    private Region<SecurityKey, PDXConcurrentList<ChangeRuleKey>> securityChangeRuleXrefRegion;

    @Resource(name = SECURITY_PRICE_HISTORY_XREF_REGION_BEAN_NAME)
    private Region<SecurityKey, PDXConcurrentList<SecurityPriceHistoryKey>> securityPriceHistoryXrefRegion;

    @Resource(name = SECURITY_REGION_BEAN_NAME)
    private Region<SecurityKey, Security> securityRegion;

    @Resource(name = ACCOUNT_REGION_BEAN_NAME)
    private Region<AccountKey, Account> accountRegion;

    @Resource(name = TRADE_REGION_BEAN_NAME)
    private Region<TradeKey, Trade> tradeRegion;

    @Resource(name = SECURITY_PRICE_STATUS_REGION_BEAN_NAME)
    private Region<SecurityKey, SecurityPriceStatus> priceStatusRegion;

    @Resource(name = ACCOUNT_STATUS_REGION_BEAN_NAME)
    private Region<AccountKey, AccountStatus> accountStatusRegion;

    @Resource(name = ACCOUNT_NOTIFICATION_REGION_BEAN_NAME)
    private Region<AccountNotificationKey, AccountNotification> accountNotificationRegion;

    @Resource(name = SECURITY_PRICE_HISTORY_REGION_BEAN_NAME)
    private Region<SecurityPriceHistoryKey, SecurityPriceHistory> priceHistoryRegion;

    @Resource(name = ACCOUNT_HISTORY_REGION_BEAN_NAME)
    private Region<AccountHistoryKey, AccountHistory> accountHistoryRegion;

    @Resource(name = CHANGE_RULE_REGION_BEAN_NAME)
    private Region<ChangeRuleKey, ChangeRule> changeRuleRegion;

    @Autowired
    private IDGenerator<Long> idGenerator;

    @Autowired
    private ColocationKeyGenerator<Long, String> keyGenerator;

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
    public ColocationKeyGenerator<Long, String> createKeyGenerator(Cache cache) {
        LOG.info("creating KeyGenerator");
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
        RegionFactory<SecurityKey, Security> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);
        return rf.create(SECURITY_REGION_NAME);
    }

    @Bean(name = ACCOUNT_REGION_BEAN_NAME)
    public Region<AccountKey, Account> createAccountRegion(Cache cache) {
        LOG.info("creating {}", ACCOUNT_REGION_BEAN_NAME);
        RegionFactory<AccountKey, Account> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);
        return rf.create(ACCOUNT_REGION_NAME);
    }

    @Bean(name = ACCOUNT_STATUS_REGION_BEAN_NAME)
    @DependsOn(ACCOUNT_REGION_BEAN_NAME)
    public Region<AccountKey, AccountStatus> createAccountStatusRegion(Cache cache) {
        RegionFactory<AccountKey, AccountStatus> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);

        PartitionAttributesFactory<AccountKey, AccountStatus> paf = new PartitionAttributesFactory<>();
        paf.setColocatedWith(accountRegion.getFullPath());
        PartitionAttributes<AccountKey, AccountStatus> pa = paf.create();
        rf.setPartitionAttributes(pa);

        return rf.create(ACCOUNT_STATUS_REGION_NAME);
    }

    @Bean(name = ACCOUNT_NOTIFICATION_REGION_BEAN_NAME)
    @DependsOn(ACCOUNT_REGION_BEAN_NAME)
    public Region<AccountNotificationKey, AccountNotification> createAccountNotificationRegion(Cache cache) {
        RegionFactory<AccountNotificationKey, AccountNotification> rf = cache
                .createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);

        PartitionAttributesFactory<AccountNotificationKey, AccountNotification> paf = new PartitionAttributesFactory<>();
        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setPartitionResolver(new ColocationIDPartitionResolver<>());
        PartitionAttributes<AccountNotificationKey, AccountNotification> pa = paf.create();
        rf.setPartitionAttributes(pa);

        return rf.create(ACCOUNT_NOTIFICATION_REGION_NAME);
    }

    @Bean(name = SECURITY_PRICE_HISTORY_REGION_BEAN_NAME)
    @DependsOn({ SECURITY_REGION_BEAN_NAME, SECURITY_PRICE_HISTORY_XREF_REGION_BEAN_NAME })
    public Region<SecurityPriceHistoryKey, SecurityPriceHistory> createSecurityPriceHistoryRegion(Cache cache) {
        LOG.info("creating {}", SECURITY_PRICE_HISTORY_REGION_BEAN_NAME);

        Assert.notNull(securityRegion, SECURITY_REGION_BEAN_NAME + " is null");
        Assert.notNull(securityPriceHistoryXrefRegion, SECURITY_PRICE_HISTORY_XREF_REGION_BEAN_NAME + " is null");

        RegionFactory<SecurityPriceHistoryKey, SecurityPriceHistory> rf = cache
                .createRegionFactory(RegionShortcut.PARTITION_PERSISTENT_OVERFLOW);

        PartitionAttributesFactory<SecurityPriceHistoryKey, SecurityPriceHistory> paf = new PartitionAttributesFactory<>();

        paf.setColocatedWith(securityRegion.getFullPath());
        paf.setPartitionResolver(new ColocationIDPartitionResolver<>());
        paf.addPartitionListener(new SecurityPriceHistoryXrefPartitionListener(securityPriceHistoryXrefRegion));

        PartitionAttributes<SecurityPriceHistoryKey, SecurityPriceHistory> pa = paf.create();
        rf.setPartitionAttributes(pa);

        return rf.create(SECURITY_PRICE_HISTORY_REGION_NAME);
    }

    @Bean(name = SECURITY_PRICE_STATUS_REGION_BEAN_NAME)
    @DependsOn(SECURITY_REGION_BEAN_NAME)
    public Region<SecurityKey, SecurityPriceStatus> createSecurityPriceStatusRegion(Cache cache) {
        LOG.info("creating {}", SECURITY_PRICE_STATUS_REGION_BEAN_NAME);
        Assert.notNull(securityRegion, SECURITY_REGION_BEAN_NAME + " is null");

        RegionFactory<SecurityKey, SecurityPriceStatus> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT);

        PartitionAttributesFactory<SecurityKey, SecurityPriceStatus> paf = new PartitionAttributesFactory<>();
        paf.setColocatedWith(securityRegion.getFullPath());
        PartitionAttributes<SecurityKey, SecurityPriceStatus> pa = paf.create();
        rf.setPartitionAttributes(pa);

        return rf.create(SECURITY_PRICE_STATUS_REGION_NAME);
    }

    @Bean(name = ACCOUNT_HISTORY_REGION_BEAN_NAME)
    @DependsOn({ ACCOUNT_REGION_BEAN_NAME, ACCOUNT_HISTORY_XREF_REGION_BEAN_NAME })
    public Region<AccountHistoryKey, AccountHistory> createAccountHistoryRegion(Cache cache) {
        LOG.info("creating {}", ACCOUNT_HISTORY_REGION_BEAN_NAME);

        Assert.notNull(accountRegion, ACCOUNT_REGION_BEAN_NAME + " is null");
        Assert.notNull(accountHistoryXrefRegion, ACCOUNT_HISTORY_XREF_REGION_BEAN_NAME + " is null");

        RegionFactory<AccountHistoryKey, AccountHistory> rf = cache
                .createRegionFactory(RegionShortcut.PARTITION_PERSISTENT_OVERFLOW);

        PartitionAttributesFactory<AccountHistoryKey, AccountHistory> paf = new PartitionAttributesFactory<>();
        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setPartitionResolver(new ColocationIDPartitionResolver<>());
        paf.addPartitionListener(new AccountHistoryXrefPartitionListener(accountHistoryXrefRegion));
        PartitionAttributes<AccountHistoryKey, AccountHistory> pa = paf.create();
        rf.setPartitionAttributes(pa);

        return rf.create(ACCOUNT_HISTORY_REGION_NAME);
    }

    @Bean(name = CHANGE_RULE_REGION_BEAN_NAME)
    @DependsOn({ ACCOUNT_REGION_BEAN_NAME, ACCOUNT_CHANGE_RULE_XREF_REGION_BEAN_NAME })
    public Region<ChangeRuleKey, ChangeRule> createChangeRuleRegion(Cache cache) {
        LOG.info("creating {}", CHANGE_RULE_REGION_BEAN_NAME);

        Assert.notNull(accountRegion, ACCOUNT_REGION_BEAN_NAME + " is null");
        Assert.notNull(accountChangeRuleXrefRegion, ACCOUNT_CHANGE_RULE_XREF_REGION_BEAN_NAME + " is null");
        Assert.notNull(securityChangeRuleXrefRegion, SECURITY_CHANGE_RULE_XREF_REGION_BEAN_NAME + " is null");

        RegionFactory<ChangeRuleKey, ChangeRule> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT_OVERFLOW);

        PartitionAttributesFactory<ChangeRuleKey, ChangeRule> paf = new PartitionAttributesFactory<>();

        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setPartitionResolver(new ColocationIDPartitionResolver<>());
        paf.addPartitionListener(new AccountChangeRuleXrefPartitionListener(accountChangeRuleXrefRegion));
        paf.addPartitionListener(new SecurityChangeRuleXrefPartitionListener(securityChangeRuleXrefRegion));

        PartitionAttributes<ChangeRuleKey, ChangeRule> pa = paf.create();
        rf.setPartitionAttributes(pa);

        return rf.create(CHANGE_RULE_REGION_NAME);
    }

    @Bean(name = TRADE_REGION_BEAN_NAME)
    @DependsOn({ ACCOUNT_REGION_BEAN_NAME, ACCOUNT_TRADE_XREF_REGION_BEAN_NAME })
    public Region<TradeKey, Trade> createTradeRegion(Cache cache) {
        LOG.info("creating {}", TRADE_REGION_BEAN_NAME);

        Assert.notNull(accountRegion, ACCOUNT_REGION_BEAN_NAME + " is null");
        Assert.notNull(accountTradeXrefRegion, ACCOUNT_TRADE_XREF_REGION_BEAN_NAME + " is null");

        RegionFactory<TradeKey, Trade> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT_OVERFLOW);

        PartitionAttributesFactory<TradeKey, Trade> paf = new PartitionAttributesFactory<>();
        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setPartitionResolver(new ColocationIDPartitionResolver<>());
        paf.addPartitionListener(new TradeAccountXrefPartitionListener(accountTradeXrefRegion));
        PartitionAttributes<TradeKey, Trade> pa = paf.create();
        rf.setPartitionAttributes(pa);

        return rf.create(TRADE_REGION_NAME);
    }

    @Bean(name = SECURITY_PRICE_HISTORY_XREF_REGION_BEAN_NAME)
    public Region<SecurityKey, PDXConcurrentList<SecurityPriceHistoryKey>> createSecurityPriceHistoryXrefRegion(Cache cache) {
        LOG.info("creating {}", SECURITY_PRICE_HISTORY_XREF_REGION_BEAN_NAME);
        RegionFactory<SecurityKey, PDXConcurrentList<SecurityPriceHistoryKey>> rf = cache.createRegionFactory(RegionShortcut.LOCAL);
        rf.setCacheLoader(new PDXConcurrentListCacheLoader<>());
        return rf.create(SECURITY_PRICE_HISTORY_XREF_REGION_NAME);
    }

    @Bean(name = SECURITY_CHANGE_RULE_XREF_REGION_BEAN_NAME)
    public Region<SecurityKey, PDXConcurrentList<ChangeRuleKey>> createSecurityChangeRuleXrefRegion(Cache cache) {
        LOG.info("creating {}", SECURITY_CHANGE_RULE_XREF_REGION_BEAN_NAME);
        RegionFactory<SecurityKey, PDXConcurrentList<ChangeRuleKey>> rf = cache.createRegionFactory(RegionShortcut.LOCAL);
        rf.setCacheLoader(new PDXConcurrentListCacheLoader<>());
        return rf.create(SECURITY_CHANGE_RULE_XREF_REGION_NAME);
    }

    @Bean(name = ACCOUNT_HISTORY_XREF_REGION_BEAN_NAME)
    public Region<AccountKey, PDXConcurrentList<AccountHistoryKey>> createAccountHistoryXrefRegion(Cache cache) {
        LOG.info("creating {}", ACCOUNT_HISTORY_XREF_REGION_BEAN_NAME);
        RegionFactory<AccountKey, PDXConcurrentList<AccountHistoryKey>> rf = cache.createRegionFactory(RegionShortcut.LOCAL);
        rf.setCacheLoader(new PDXConcurrentListCacheLoader<>());
        return rf.create(ACCOUNT_HISTORY_XREF_REGION_NAME);
    }

    @Bean(name = ACCOUNT_TRADE_XREF_REGION_BEAN_NAME)
    public Region<AccountKey, PDXConcurrentList<TradeKey>> createAccountTradeXrefRegion(Cache cache) {
        LOG.info("creating {}", ACCOUNT_TRADE_XREF_REGION_BEAN_NAME);
        RegionFactory<AccountKey, PDXConcurrentList<TradeKey>> rf = cache.createRegionFactory(RegionShortcut.LOCAL);
        rf.setCacheLoader(new PDXConcurrentListCacheLoader<>());
        return rf.create(ACCOUNT_TRADE_XREF_REGION_NAME);
    }

    @Bean(name = ACCOUNT_CHANGE_RULE_XREF_REGION_BEAN_NAME)
    public Region<AccountKey, PDXConcurrentList<ChangeRuleKey>> createAccountChangeRuleXrefRegion(Cache cache) {
        LOG.info("creating {}", ACCOUNT_CHANGE_RULE_XREF_REGION_BEAN_NAME);
        RegionFactory<AccountKey, PDXConcurrentList<ChangeRuleKey>> rf = cache.createRegionFactory(RegionShortcut.LOCAL);
        rf.setCacheLoader(new PDXConcurrentListCacheLoader<>());
        return rf.create(ACCOUNT_CHANGE_RULE_XREF_REGION_NAME);
    }

    @PostConstruct
    public void post() {
        LOG.info("Attaching CacheListeners");

        Assert.notNull(securityPriceHistoryXrefRegion, "securityPriceHistoryXrefRegion is null");
        Assert.notNull(securityChangeRuleXrefRegion, "securityChangeRuleXrefRegion is null");
        Assert.notNull(priceStatusRegion, "priceStatusRegion is null");
        Assert.notNull(accountHistoryXrefRegion, "accountHistoryXrefRegion is null");
        Assert.notNull(accountTradeXrefRegion, "accountTradeXrefRegion is null");
        Assert.notNull(accountHistoryRegion, "accountHistoryRegion is null");
        Assert.notNull(accountStatusRegion, "accountStatusRegion is null");
        Assert.notNull(priceHistoryRegion, "priceHistoryRegion is null");
        Assert.notNull(accountChangeRuleXrefRegion, "accountChangeRuleXrefRegion is null");
        Assert.notNull(keyGenerator, "keyGenerator is null");

        priceHistoryRegion.getAttributesMutator()
                .addCacheListener(new SecurityPriceHistoryXrefCacheListener(securityPriceHistoryXrefRegion));
        priceHistoryRegion.getAttributesMutator().addCacheListener(new SecurityPriceStatusUpdateCacheListener(priceStatusRegion));

        accountHistoryRegion.getAttributesMutator().addCacheListener(new AccountHistoryXrefCacheListener(accountHistoryXrefRegion));

        changeRuleRegion.getAttributesMutator()
                .addCacheListener(new AccountChangeRuleXrefCacheListener(accountChangeRuleXrefRegion));
        changeRuleRegion.getAttributesMutator()
                .addCacheListener(new SecurityChangeRuleXrefCacheListener(securityChangeRuleXrefRegion));

        tradeRegion.getAttributesMutator().addCacheListener(new TradeAccountXrefCacheListener(accountTradeXrefRegion));
        tradeRegion.getAttributesMutator().addCacheListener(
                new TradeHistoryCacheListener(accountHistoryRegion, accountStatusRegion, priceHistoryRegion, keyGenerator));
        tradeRegion.getAttributesMutator().addCacheListener(new TradeVolumeCacheListener(securityChangeRuleXrefRegion,
                changeRuleRegion, accountNotificationRegion, keyGenerator));

        priceStatusRegion.getAttributesMutator().addCacheListener(new SecurityPriceStatusDeltaCacheListener(
                securityChangeRuleXrefRegion, changeRuleRegion, accountNotificationRegion, keyGenerator));

        FunctionService.registerFunction(new DefaultGenerateIDFunction<>("BaseGenerateIDFunction", idGenerator));
    }
}
