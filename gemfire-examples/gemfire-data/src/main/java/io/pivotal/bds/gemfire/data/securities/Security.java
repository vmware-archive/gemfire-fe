package io.pivotal.bds.gemfire.data.securities;

public class Security {

    private SecurityKey key;
    private String description;
    private IssuerKey issuerKey;

    public Security() {
    }

    public Security(SecurityKey key, String description, IssuerKey issuerKey) {
        this.key = key;
        this.description = description;
        this.issuerKey = issuerKey;
    }

    public SecurityKey getKey() {
        return key;
    }

    public void setKey(SecurityKey key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IssuerKey getIssuerKey() {
        return issuerKey;
    }

    public void setIssuerKey(IssuerKey issuerKey) {
        this.issuerKey = issuerKey;
    }

    @Override
    public String toString() {
        return "Security [key=" + key + ", description=" + description + ", issuerKey=" + issuerKey + "]";
    }

}
