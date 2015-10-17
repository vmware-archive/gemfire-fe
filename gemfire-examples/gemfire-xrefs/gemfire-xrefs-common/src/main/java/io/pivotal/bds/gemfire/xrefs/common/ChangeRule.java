package io.pivotal.bds.gemfire.xrefs.common;

public class ChangeRule {

    private ChangeRuleKey key;
    private AccountKey accountKey;
    private SecurityKey securityKey;
    private ChangeAttributeType attributeType;
    private ChangeValueType valueType;
    private double maximum;

    public ChangeRule() {
    }

    public ChangeRule(ChangeRuleKey key, AccountKey accountKey, SecurityKey securityKey, ChangeAttributeType attributeType,
            ChangeValueType valueType, double maximum) {
        this.key = key;
        this.accountKey = accountKey;
        this.securityKey = securityKey;
        this.attributeType = attributeType;
        this.valueType = valueType;
        this.maximum = maximum;
    }

    public ChangeRuleKey getKey() {
        return key;
    }

    public void setKey(ChangeRuleKey key) {
        this.key = key;
    }

    public AccountKey getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(AccountKey accountKey) {
        this.accountKey = accountKey;
    }

    public SecurityKey getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(SecurityKey securityKey) {
        this.securityKey = securityKey;
    }

    public ChangeAttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(ChangeAttributeType attributeType) {
        this.attributeType = attributeType;
    }

    public ChangeValueType getValueType() {
        return valueType;
    }

    public void setValueType(ChangeValueType valueType) {
        this.valueType = valueType;
    }

    public double getMaximum() {
        return maximum;
    }

    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return "ChangeRule [key=" + key + ", accountKey=" + accountKey + ", securityKey=" + securityKey + ", attributeType="
                + attributeType + ", valueType=" + valueType + ", maximum=" + maximum + "]";
    }

}
