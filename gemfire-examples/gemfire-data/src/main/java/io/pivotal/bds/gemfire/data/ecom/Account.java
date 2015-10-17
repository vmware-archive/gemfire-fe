package io.pivotal.bds.gemfire.data.ecom;

import java.util.Date;
import java.util.Set;

public class Account {

    private AccountKey key;
    private String name;
    private Date createdOn;
    private AccountStatus status;
    private AddressKey defaultBillingAddressKey;
    private AddressKey defaultShippingAddressKey;
    private Set<AddressKey> addressKeys;
    private PaymentMethodKey defaultPaymentMethodKey;
    private Set<PaymentMethodKey> paymentMethodKeys;

    public Account() {
    }

    public Account(AccountKey key, String name, Date createdOn, AccountStatus status, AddressKey defaultBillingAddressKey,
            AddressKey defaultShippingAddressKey, Set<AddressKey> addressKeys, PaymentMethodKey defaultPaymentMethodKey,
            Set<PaymentMethodKey> paymentMethodKeys) {
        this.key = key;
        this.name = name;
        this.createdOn = createdOn;
        this.status = status;
        this.defaultBillingAddressKey = defaultBillingAddressKey;
        this.defaultShippingAddressKey = defaultShippingAddressKey;
        this.addressKeys = addressKeys;
        this.defaultPaymentMethodKey = defaultPaymentMethodKey;
        this.paymentMethodKeys = paymentMethodKeys;
    }

    public AccountKey getKey() {
        return key;
    }

    public void setKey(AccountKey key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public AddressKey getDefaultBillingAddressKey() {
        return defaultBillingAddressKey;
    }

    public void setDefaultBillingAddressKey(AddressKey defaultBillingAddressKey) {
        this.defaultBillingAddressKey = defaultBillingAddressKey;
    }

    public AddressKey getDefaultShippingAddressKey() {
        return defaultShippingAddressKey;
    }

    public void setDefaultShippingAddressKey(AddressKey defaultShippingAddressKey) {
        this.defaultShippingAddressKey = defaultShippingAddressKey;
    }

    public Set<AddressKey> getAddressKeys() {
        return addressKeys;
    }

    public void setAddressKeys(Set<AddressKey> addressKeys) {
        this.addressKeys = addressKeys;
    }

    public PaymentMethodKey getDefaultPaymentMethodKey() {
        return defaultPaymentMethodKey;
    }

    public void setDefaultPaymentMethodKey(PaymentMethodKey defaultPaymentMethodKey) {
        this.defaultPaymentMethodKey = defaultPaymentMethodKey;
    }

    public Set<PaymentMethodKey> getPaymentMethodKeys() {
        return paymentMethodKeys;
    }

    public void setPaymentMethodKeys(Set<PaymentMethodKey> paymentMethodKeys) {
        this.paymentMethodKeys = paymentMethodKeys;
    }

    @Override
    public String toString() {
        return "Account [key=" + key + ", name=" + name + ", createdOn=" + createdOn + ", status=" + status
                + ", defaultBillingAddressKey=" + defaultBillingAddressKey + ", defaultShippingAddressKey="
                + defaultShippingAddressKey + ", addressKeys=" + addressKeys + ", defaultPaymentMethodKey="
                + defaultPaymentMethodKey + ", paymentMethodKeys=" + paymentMethodKeys + "]";
    }

}
