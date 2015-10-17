package io.pivotal.bds.gemfire.data.ecom;

public class PaymentMethod {

    private PaymentMethodKey key;
    private AddressKey billingAddressKey;
    private PaymentMethodType type;
    private String accountNumber;

    public PaymentMethod() {
    }

    public PaymentMethod(PaymentMethodKey key, AddressKey billingAddressKey, PaymentMethodType type, String accountNumber) {
        this.key = key;
        this.billingAddressKey = billingAddressKey;
        this.type = type;
        this.accountNumber = accountNumber;
    }

    public PaymentMethodKey getKey() {
        return key;
    }

    public void setKey(PaymentMethodKey key) {
        this.key = key;
    }

    public AddressKey getBillingAddressKey() {
        return billingAddressKey;
    }

    public void setBillingAddressKey(AddressKey billingAddressKey) {
        this.billingAddressKey = billingAddressKey;
    }

    public PaymentMethodType getType() {
        return type;
    }

    public void setType(PaymentMethodType type) {
        this.type = type;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "PaymentMethod [key=" + key + ", billingAddressKey=" + billingAddressKey + ", type=" + type + ", accountNumber="
                + accountNumber + "]";
    }

}
