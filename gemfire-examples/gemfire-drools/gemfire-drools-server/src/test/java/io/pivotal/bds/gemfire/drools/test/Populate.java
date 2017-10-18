package io.pivotal.bds.gemfire.drools.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

import io.pivotal.bds.gemfire.data.ecom.Account;
import io.pivotal.bds.gemfire.data.ecom.AccountKey;
import io.pivotal.bds.gemfire.data.ecom.AccountStatus;
import io.pivotal.bds.gemfire.data.ecom.Address;
import io.pivotal.bds.gemfire.data.ecom.AddressKey;
import io.pivotal.bds.gemfire.data.ecom.CatalogItem;
import io.pivotal.bds.gemfire.data.ecom.CatalogItemKey;
import io.pivotal.bds.gemfire.data.ecom.Dimensions;
import io.pivotal.bds.gemfire.data.ecom.LengthUnit;
import io.pivotal.bds.gemfire.data.ecom.Order;
import io.pivotal.bds.gemfire.data.ecom.OrderItem;
import io.pivotal.bds.gemfire.data.ecom.OrderItemKey;
import io.pivotal.bds.gemfire.data.ecom.OrderKey;
import io.pivotal.bds.gemfire.data.ecom.PaymentMethod;
import io.pivotal.bds.gemfire.data.ecom.PaymentMethodKey;
import io.pivotal.bds.gemfire.data.ecom.PaymentMethodType;
import io.pivotal.bds.gemfire.data.ecom.Price;
import io.pivotal.bds.gemfire.data.ecom.ShippingMethod;
import io.pivotal.bds.gemfire.data.ecom.ShippingMethodKey;
import io.pivotal.bds.gemfire.data.ecom.ShippingMethodType;
import io.pivotal.bds.gemfire.data.ecom.ShippingVendor;
import io.pivotal.bds.gemfire.data.ecom.ShippingVendorKey;
import io.pivotal.bds.gemfire.data.ecom.ShippingVendorType;
import io.pivotal.bds.gemfire.data.ecom.Weight;
import io.pivotal.bds.gemfire.data.ecom.WeightUnit;
import io.pivotal.bds.gemfire.drools.common.Constants;

public class Populate implements Constants {

    private static Region<ShippingVendorKey, ShippingVendor> svr;
    private static Region<ShippingMethodKey, ShippingMethod> smr;
    private static Region<CatalogItemKey, CatalogItem> cir;
    private static Region<AddressKey, Address> addrr;
    private static Region<AccountKey, Account> acctr;
    private static Region<OrderKey, Order> ordr;
    private static Region<OrderItemKey, OrderItem> oir;
    private static Region<PaymentMethodKey, PaymentMethod> paymr;

    private static long nextOrderId = 1L;
    private static long orderItemId = 1L;

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();
        ccf.addPoolLocator("localhost", 10334);
        ccf.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.data.ecom.*"));
        ClientCache cc = ccf.create();

        try {
            svr = createRegion(cc, SHIPPING_VENDOR_REGION_NAME);
            smr = createRegion(cc, SHIPPING_METHOD_REGION_NAME);
            cir = createRegion(cc, CATALOG_ITEM_REGION_NAME);
            addrr = createRegion(cc, ADDRESS_REGION_NAME);
            acctr = createRegion(cc, ACCOUNT_REGION_NAME);
            ordr = createRegion(cc, ORDER_REGION_NAME);
            oir = createRegion(cc, ORDER_ITEM_REGION_NAME);
            paymr = createRegion(cc, PAYMENT_METHOD_REGION_NAME);

            populateShippingMethod();
            populateShippingVendor();
            populateCatalogItem();
            populateAccount();
        } finally {
            cc.close();
        }

    }

    private static void populateOrder(Account acct) throws Exception {
        AccountKey acctKey = acct.getKey();
        long acctId = acctKey.getId();
        AddressKey addrKey = acct.getDefaultBillingAddressKey();

        for (int i = 1; i <= 10; ++i) {
            Set<OrderItemKey> ordItmKeys = new HashSet<>();

            int quan = i;
            double price = 1.25 * i;
            double tot = price * quan;

            OrderItemKey oik = new OrderItemKey(orderItemId++, acctId);
            OrderItem oi = new OrderItem(oik, new CatalogItemKey(1L), quan, price, tot);
            ordItmKeys.add(oik);
            oir.put(oik, oi);

            PaymentMethodKey pmk = acct.getDefaultPaymentMethodKey();

            OrderKey ordKey = new OrderKey(nextOrderId++, acctId);
            System.out.println("ordKey=" + ordKey);
            Order order = new Order(ordKey, acctKey, ordItmKeys, new Date(), addrKey, addrKey, pmk, null, 0.0, 0.0, 0.0);
            ordr.put(ordKey, order);
        }
    }

    private static void populateAccount() throws Exception {
        for (int i = 1; i <= 10; ++i) {
            AccountKey ak = new AccountKey((long) i);

            AddressKey addrk = new AddressKey((long) i, ak.getId());
            Address addr = new Address(addrk, "1234" + i, "Apt " + i, "City-" + i, "AZ", "1234" + i);
            addrr.put(addrk, addr);

            AccountStatus as = i == 1 ? AccountStatus.INACTIVE : AccountStatus.ACTIVE;

            Set<AddressKey> adks = new HashSet<>();
            adks.add(addrk);

            PaymentMethodKey pmk = new PaymentMethodKey(ak.getId(), ak.getId());
            PaymentMethod pm = new PaymentMethod(pmk, addrk, PaymentMethodType.VISA, "1234567890123" + i);
            paymr.put(pmk, pm);

            Set<PaymentMethodKey> pmkeys = new HashSet<>();
            pmkeys.add(pmk);

            Account acct = new Account(ak, "Account-" + i, new Date(), as, addrk, addrk, adks, pmk, pmkeys);
            acctr.put(ak, acct);

            populateOrder(acct);
        }
    }

    private static void populateCatalogItem() throws Exception {
        CatalogItemKey cik = new CatalogItemKey(1L);

        List<Price> prices = new ArrayList<>();
        prices.add(new Price(-1, -1, 12.34));

        Dimensions dims = new Dimensions(1.0, 2.0, 3.0, LengthUnit.FOOT);
        Weight wei = new Weight(1.7, WeightUnit.POUNDS);

        CatalogItem ci = new CatalogItem(cik, "Widget", "A widget", prices, dims, wei);
        cir.put(cik, ci);
    }

    private static void populateShippingMethod() throws Exception {
        ShippingMethodKey smk = new ShippingMethodKey(1L);
        ShippingMethod sm = new ShippingMethod(smk, new ShippingVendorKey(1L), ShippingMethodType.OVERNIGHT);
        smr.put(smk, sm);
    }

    private static void populateShippingVendor() throws Exception {
        ShippingVendorKey svk = new ShippingVendorKey(1L);
        ShippingVendor sv = new ShippingVendor(svk, ShippingVendorType.FEDEX, "Fedex");
        svr.put(svk, sv);
    }

    private static <K, V> Region<K, V> createRegion(ClientCache cc, String name) {
        ClientRegionFactory<K, V> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<K, V> r = crf.create(name);
        return r;
    }
}
