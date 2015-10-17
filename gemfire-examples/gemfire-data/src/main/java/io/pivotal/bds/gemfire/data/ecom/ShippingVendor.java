package io.pivotal.bds.gemfire.data.ecom;

public class ShippingVendor {

    private ShippingVendorKey key;
    private ShippingVendorType type;
    private String name;

    public ShippingVendor() {
    }

    public ShippingVendor(ShippingVendorKey key, ShippingVendorType type, String name) {
        this.key = key;
        this.type = type;
        this.name = name;
    }

    public ShippingVendorKey getKey() {
        return key;
    }

    public void setKey(ShippingVendorKey key) {
        this.key = key;
    }

    public ShippingVendorType getType() {
        return type;
    }

    public void setType(ShippingVendorType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ShippingVendor [key=" + key + ", type=" + type + ", name=" + name + "]";
    }

}
