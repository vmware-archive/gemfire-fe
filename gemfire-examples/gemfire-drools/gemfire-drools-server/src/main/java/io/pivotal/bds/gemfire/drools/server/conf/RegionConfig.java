package io.pivotal.bds.gemfire.drools.server.conf;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
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

import io.pivotal.bds.gemfire.data.ecom.Account;
import io.pivotal.bds.gemfire.data.ecom.AccountKey;
import io.pivotal.bds.gemfire.data.ecom.Address;
import io.pivotal.bds.gemfire.data.ecom.AddressKey;
import io.pivotal.bds.gemfire.data.ecom.CatalogItem;
import io.pivotal.bds.gemfire.data.ecom.CatalogItemKey;
import io.pivotal.bds.gemfire.data.ecom.Invoice;
import io.pivotal.bds.gemfire.data.ecom.InvoiceKey;
import io.pivotal.bds.gemfire.data.ecom.Order;
import io.pivotal.bds.gemfire.data.ecom.OrderItem;
import io.pivotal.bds.gemfire.data.ecom.OrderItemKey;
import io.pivotal.bds.gemfire.data.ecom.OrderKey;
import io.pivotal.bds.gemfire.data.ecom.Payment;
import io.pivotal.bds.gemfire.data.ecom.PaymentKey;
import io.pivotal.bds.gemfire.data.ecom.PaymentMethod;
import io.pivotal.bds.gemfire.data.ecom.PaymentMethodKey;
import io.pivotal.bds.gemfire.data.ecom.Shipment;
import io.pivotal.bds.gemfire.data.ecom.ShipmentKey;
import io.pivotal.bds.gemfire.data.ecom.ShippingMethod;
import io.pivotal.bds.gemfire.data.ecom.ShippingMethodKey;
import io.pivotal.bds.gemfire.data.ecom.ShippingVendor;
import io.pivotal.bds.gemfire.data.ecom.ShippingVendorKey;
import io.pivotal.bds.gemfire.drools.common.Constants;
import io.pivotal.bds.gemfire.drools.common.Rule;
import io.pivotal.bds.gemfire.drools.common.RuleKey;
import io.pivotal.bds.gemfire.drools.server.function.StatefulRuleExecutionFunction;
import io.pivotal.bds.gemfire.drools.server.function.StatelessRuleExecutionFunction;
import io.pivotal.bds.gemfire.drools.server.listener.RuleCacheListener;
import io.pivotal.bds.gemfire.drools.server.loader.KieFileSystemCacheLoader;
import io.pivotal.bds.gemfire.keyfw.resolver.ColocationIDPartitionResolver;

@Configuration
public class RegionConfig implements Constants {

    @Resource(name = KIE_FILE_SYSTEM_REGION_BEAN_NAME)
    private Region<ReleaseId, KieFileSystem> fileSystemRegion;

    @Resource(name = RULE_REGION_BEAN_NAME)
    private Region<RuleKey, Rule> ruleRegion;

    @Resource(name = SHIPPING_METHOD_REGION_BEAN_NAME)
    private Region<ShippingMethodKey, ShippingMethod> shippingMethodRegion;

    @Resource(name = SHIPPING_VENDOR_REGION_BEAN_NAME)
    private Region<ShippingVendorKey, ShippingVendor> shippingVendorRegion;

    @Resource(name = ACCOUNT_REGION_BEAN_NAME)
    private Region<AccountKey, Account> accountRegion;

    @Resource(name = ADDRESS_REGION_BEAN_NAME)
    private Region<AddressKey, Address> addressRegion;

    @Resource(name = ORDER_REGION_BEAN_NAME)
    private Region<OrderKey, Order> orderRegion;

    @Resource(name = ORDER_ITEM_REGION_BEAN_NAME)
    private Region<OrderItemKey, OrderItem> orderItemRegion;

    @Resource(name = INVOICE_REGION_BEAN_NAME)
    private Region<InvoiceKey, Invoice> invoiceRegion;

    @Resource(name = PAYMENT_REGION_BEAN_NAME)
    private Region<PaymentKey, Payment> paymentRegion;

    @Resource(name = PAYMENT_METHOD_REGION_BEAN_NAME)
    private Region<PaymentMethodKey, PaymentMethod> paymentMethodRegion;

    @Resource(name = SHIPMENT_REGION_BEAN_NAME)
    private Region<ShipmentKey, Shipment> shipmentRegion;

    @Autowired
    private StatelessRuleExecutionFunction statelessRuleExecutionFunction;

    @Autowired
    private StatefulRuleExecutionFunction statefulRuleExecutionFunction;

    private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

    @Bean(name = KIE_FILE_SYSTEM_REGION_BEAN_NAME)
    public Region<ReleaseId, KieFileSystem> createFileSystemRegion(Cache cache, KieServices svcs) {
        LOG.info("creating {} region", KIE_FILE_SYSTEM_REGION_NAME);
        Assert.notNull(svcs,"KieServices is null");
        RegionFactory<ReleaseId, KieFileSystem> rf = cache.createRegionFactory(RegionShortcut.LOCAL);
        rf.setCacheLoader(new KieFileSystemCacheLoader(svcs));
        return rf.create(KIE_FILE_SYSTEM_REGION_NAME);
    }

    @Bean(name = RULE_REGION_BEAN_NAME)
    public Region<RuleKey, Rule> createRuleRegion(Cache cache, KieServices svcs, KieRepository repo) {
        LOG.info("creating {} region", RULE_REGION_NAME);
        Assert.notNull(svcs,"KieServices is null");
        Assert.notNull(repo,"KieRepository is null");
        RegionFactory<RuleKey, Rule> rf = cache.createRegionFactory(RegionShortcut.REPLICATE);
        rf.addCacheListener(new RuleCacheListener(svcs, repo, fileSystemRegion));
        return rf.create(RULE_REGION_NAME);
    }

    @Bean(name = CATALOG_ITEM_REGION_BEAN_NAME)
    public Region<CatalogItemKey, CatalogItem> createCatalogItemRegion(Cache cache) {
        LOG.info("creating {} region", CATALOG_ITEM_REGION_NAME);
        RegionFactory<CatalogItemKey, CatalogItem> rf = cache.createRegionFactory(RegionShortcut.REPLICATE);
        return rf.create(CATALOG_ITEM_REGION_NAME);
    }

    @Bean(name = SHIPPING_METHOD_REGION_BEAN_NAME)
    public Region<ShippingMethodKey, ShippingMethod> createShippingMethodRegion(Cache cache) {
        LOG.info("creating {} region", SHIPPING_METHOD_REGION_NAME);
        RegionFactory<ShippingMethodKey, ShippingMethod> rf = cache.createRegionFactory(RegionShortcut.REPLICATE);
        return rf.create(SHIPPING_METHOD_REGION_NAME);
    }

    @Bean(name = SHIPPING_VENDOR_REGION_BEAN_NAME)
    public Region<ShippingVendorKey, ShippingVendor> createShippingVendorRegion(Cache cache) {
        LOG.info("creating {} region", SHIPPING_VENDOR_REGION_NAME);
        RegionFactory<ShippingVendorKey, ShippingVendor> rf = cache.createRegionFactory(RegionShortcut.REPLICATE);
        return rf.create(SHIPPING_VENDOR_REGION_NAME);
    }

    @Bean(name = ACCOUNT_REGION_BEAN_NAME)
    public Region<AccountKey, Account> createAccountRegion(Cache cache) {
        LOG.info("creating {} region", ACCOUNT_REGION_NAME);
        RegionFactory<AccountKey, Account> rf = cache.createRegionFactory(RegionShortcut.PARTITION);
        return rf.create(ACCOUNT_REGION_NAME);
    }

    @Bean(name = ADDRESS_REGION_BEAN_NAME)
    @DependsOn(ACCOUNT_REGION_BEAN_NAME)
    public Region<AddressKey, Address> createAddressRegion(Cache cache) {
        LOG.info("creating {} region", ADDRESS_REGION_NAME);
        Assert.notNull(accountRegion,"accountRegion is null");
        RegionFactory<AddressKey, Address> rf = cache.createRegionFactory(RegionShortcut.PARTITION);

        PartitionAttributesFactory<AddressKey, Address> paf = new PartitionAttributesFactory<>();
        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setPartitionResolver(new ColocationIDPartitionResolver<>());
        PartitionAttributes<AddressKey, Address> pattrs = paf.create();

        rf.setPartitionAttributes(pattrs);

        return rf.create(ADDRESS_REGION_NAME);
    }

    @Bean(name = ORDER_REGION_BEAN_NAME)
    @DependsOn(ACCOUNT_REGION_BEAN_NAME)
    public Region<OrderKey, Order> createOrderRegion(Cache cache) {
        LOG.info("creating {} region", ORDER_REGION_NAME);
        Assert.notNull(accountRegion,"accountRegion is null");
        RegionFactory<OrderKey, Order> rf = cache.createRegionFactory(RegionShortcut.PARTITION);

        PartitionAttributesFactory<OrderKey, Order> paf = new PartitionAttributesFactory<>();
        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setPartitionResolver(new ColocationIDPartitionResolver<>());
        PartitionAttributes<OrderKey, Order> pattrs = paf.create();

        rf.setPartitionAttributes(pattrs);

        return rf.create(ORDER_REGION_NAME);
    }

    @Bean(name = ORDER_ITEM_REGION_BEAN_NAME)
    @DependsOn(ACCOUNT_REGION_BEAN_NAME)
    public Region<OrderItemKey, OrderItem> createOrderItemRegion(Cache cache) {
        LOG.info("creating {} region", ORDER_ITEM_REGION_NAME);
        Assert.notNull(accountRegion,"accountRegion is null");
        RegionFactory<OrderItemKey, OrderItem> rf = cache.createRegionFactory(RegionShortcut.PARTITION);

        PartitionAttributesFactory<OrderItemKey, OrderItem> paf = new PartitionAttributesFactory<>();
        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setPartitionResolver(new ColocationIDPartitionResolver<>());
        PartitionAttributes<OrderItemKey, OrderItem> pattrs = paf.create();

        rf.setPartitionAttributes(pattrs);

        return rf.create(ORDER_ITEM_REGION_NAME);
    }

    @Bean(name = INVOICE_REGION_BEAN_NAME)
    @DependsOn(ACCOUNT_REGION_BEAN_NAME)
    public Region<InvoiceKey, Invoice> createInvoiceRegion(Cache cache) {
        LOG.info("creating {} region", INVOICE_REGION_NAME);
        Assert.notNull(accountRegion,"accountRegion is null");
        RegionFactory<InvoiceKey, Invoice> rf = cache.createRegionFactory(RegionShortcut.PARTITION);

        PartitionAttributesFactory<InvoiceKey, Invoice> paf = new PartitionAttributesFactory<>();
        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setPartitionResolver(new ColocationIDPartitionResolver<>());
        PartitionAttributes<InvoiceKey, Invoice> pattrs = paf.create();

        rf.setPartitionAttributes(pattrs);

        return rf.create(INVOICE_REGION_NAME);
    }

    @Bean(name = PAYMENT_REGION_BEAN_NAME)
    @DependsOn(ACCOUNT_REGION_BEAN_NAME)
    public Region<PaymentKey, Payment> createPaymentRegion(Cache cache) {
        LOG.info("creating {} region", PAYMENT_REGION_NAME);
        Assert.notNull(accountRegion,"accountRegion is null");
        RegionFactory<PaymentKey, Payment> rf = cache.createRegionFactory(RegionShortcut.PARTITION);

        PartitionAttributesFactory<PaymentKey, Payment> paf = new PartitionAttributesFactory<>();
        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setPartitionResolver(new ColocationIDPartitionResolver<>());
        PartitionAttributes<PaymentKey, Payment> pattrs = paf.create();

        rf.setPartitionAttributes(pattrs);

        return rf.create(PAYMENT_REGION_NAME);
    }

    @Bean(name = PAYMENT_METHOD_REGION_BEAN_NAME)
    @DependsOn(ACCOUNT_REGION_BEAN_NAME)
    public Region<PaymentMethodKey, PaymentMethod> createPaymentMethodRegion(Cache cache) {
        LOG.info("creating {} region", PAYMENT_METHOD_REGION_NAME);
        Assert.notNull(accountRegion,"accountRegion is null");
        RegionFactory<PaymentMethodKey, PaymentMethod> rf = cache.createRegionFactory(RegionShortcut.PARTITION);

        PartitionAttributesFactory<PaymentMethodKey, PaymentMethod> paf = new PartitionAttributesFactory<>();
        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setPartitionResolver(new ColocationIDPartitionResolver<>());
        PartitionAttributes<PaymentMethodKey, PaymentMethod> pattrs = paf.create();

        rf.setPartitionAttributes(pattrs);

        return rf.create(PAYMENT_METHOD_REGION_NAME);
    }

    @Bean(name = SHIPMENT_REGION_BEAN_NAME)
    @DependsOn(ACCOUNT_REGION_BEAN_NAME)
    public Region<ShipmentKey, Shipment> createShipmentRegion(Cache cache) {
        LOG.info("creating {} region", SHIPMENT_REGION_NAME);
        Assert.notNull(accountRegion,"accountRegion is null");
        RegionFactory<ShipmentKey, Shipment> rf = cache.createRegionFactory(RegionShortcut.PARTITION);

        PartitionAttributesFactory<ShipmentKey, Shipment> paf = new PartitionAttributesFactory<>();
        paf.setColocatedWith(accountRegion.getFullPath());
        paf.setPartitionResolver(new ColocationIDPartitionResolver<>());
        PartitionAttributes<ShipmentKey, Shipment> pattrs = paf.create();

        rf.setPartitionAttributes(pattrs);

        return rf.create(SHIPMENT_REGION_NAME);
    }

    @Bean
    public StatelessRuleExecutionFunction createStatelessRuleExecutionFunction(Cache cache, KieServices svcs) {
        LOG.info("creating StatelessRuleExecutionFunction");
        Assert.notNull(svcs,"KieServices is null");
        StatelessRuleExecutionFunction f = new StatelessRuleExecutionFunction(svcs);
        return f;
    }

    @Bean
    public StatefulRuleExecutionFunction createStatefulRuleExecutionFunction(Cache cache, KieServices svcs) {
        LOG.info("creating StatefulRuleExecutionFunction");
        Assert.notNull(svcs,"KieServices is null");
        StatefulRuleExecutionFunction f = new StatefulRuleExecutionFunction(svcs);
        return f;
    }

    @PostConstruct
    public void postConstruct() {
        LOG.info("registering functions");
        Assert.notNull(statelessRuleExecutionFunction,"statelessRuleExecutionFunction is null");
        Assert.notNull(statefulRuleExecutionFunction,"statefulRuleExecutionFunction is null");
        FunctionService.registerFunction(statelessRuleExecutionFunction);
        FunctionService.registerFunction(statefulRuleExecutionFunction);
    }
}
