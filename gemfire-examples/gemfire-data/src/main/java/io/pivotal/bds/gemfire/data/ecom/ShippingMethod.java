package io.pivotal.bds.gemfire.data.ecom;

public class ShippingMethod {

    private ShippingMethodKey key;
    private ShippingVendorKey vendorKey;
    private ShippingMethodType type;
    
    public ShippingMethod() {
    }

    public ShippingMethod(ShippingMethodKey key, ShippingVendorKey vendorKey, ShippingMethodType type) {
        this.key = key;
        this.vendorKey = vendorKey;
        this.type = type;
    }

    public ShippingMethodKey getKey() {
        return key;
    }

    public void setKey(ShippingMethodKey key) {
        this.key = key;
    }

    public ShippingVendorKey getVendorKey() {
        return vendorKey;
    }

    public void setVendorKey(ShippingVendorKey vendorKey) {
        this.vendorKey = vendorKey;
    }

    public ShippingMethodType getType() {
        return type;
    }

    public void setType(ShippingMethodType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ShippingMethod [key=" + key + ", vendorKey=" + vendorKey + ", type=" + type + "]";
    }

}
