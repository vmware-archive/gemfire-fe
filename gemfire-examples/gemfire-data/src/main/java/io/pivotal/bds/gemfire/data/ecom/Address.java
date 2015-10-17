package io.pivotal.bds.gemfire.data.ecom;

public class Address {

    private AddressKey key;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String postalCode;

    public Address() {
    }

    public Address(AddressKey key, String line1, String line2, String city, String state, String postalCode) {
        this.key = key;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public AddressKey getKey() {
        return key;
    }

    public void setKey(AddressKey key) {
        this.key = key;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address [key=" + key + ", line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", state=" + state
                + ", postalCode=" + postalCode + "]";
    }

}
