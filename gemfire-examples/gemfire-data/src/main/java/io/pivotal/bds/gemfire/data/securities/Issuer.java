package io.pivotal.bds.gemfire.data.securities;

public class Issuer {

    private IssuerKey key;
    private String name;

    public Issuer() {
    }

    public Issuer(IssuerKey key, String name) {
        this.key = key;
        this.name = name;
    }

    public IssuerKey getKey() {
        return key;
    }

    public void setKey(IssuerKey key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Issuer [key=" + key + ", name=" + name + "]";
    }

}
