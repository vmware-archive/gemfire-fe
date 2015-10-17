package io.pivotal.bds.gemfire.xrefs.common;

public class Account {

    private AccountKey key;
    private String name;

    public Account() {
    }

    public Account(AccountKey key, String name) {
        this.key = key;
        this.name = name;
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

    @Override
    public String toString() {
        return "Account [key=" + key + ", name=" + name + "]";
    }

}
