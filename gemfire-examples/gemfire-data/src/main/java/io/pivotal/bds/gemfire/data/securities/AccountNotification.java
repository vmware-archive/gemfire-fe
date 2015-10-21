package io.pivotal.bds.gemfire.data.securities;

public class AccountNotification {

    private AccountNotificationKey key;
    private AccountKey accountKey;
    private ChangeValueType valueType;
    private ChangeAttributeType attributeType;
    private double value;
    private double maximum;

    public AccountNotification() {
    }

    public AccountNotification(AccountNotificationKey key, AccountKey accountKey, ChangeValueType valueType,
            ChangeAttributeType attributeType, double value, double maximum) {
        this.key = key;
        this.accountKey = accountKey;
        this.valueType = valueType;
        this.attributeType = attributeType;
        this.value = value;
        this.maximum = maximum;
    }

    public AccountNotificationKey getKey() {
        return key;
    }

    public void setKey(AccountNotificationKey key) {
        this.key = key;
    }

    public AccountKey getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(AccountKey accountKey) {
        this.accountKey = accountKey;
    }

    public ChangeValueType getValueType() {
        return valueType;
    }

    public void setValueType(ChangeValueType valueType) {
        this.valueType = valueType;
    }

    public ChangeAttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(ChangeAttributeType attributeType) {
        this.attributeType = attributeType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getMaximum() {
        return maximum;
    }

    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return "AccountNotification [key=" + key + ", accountKey=" + accountKey + ", valueType=" + valueType + ", attributeType="
                + attributeType + ", value=" + value + ", maximum=" + maximum + "]";
    }

}
