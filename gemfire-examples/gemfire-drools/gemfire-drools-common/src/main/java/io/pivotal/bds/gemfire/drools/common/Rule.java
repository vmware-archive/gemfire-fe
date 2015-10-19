package io.pivotal.bds.gemfire.drools.common;

import com.gemstone.gemfire.pdx.PdxReader;
import com.gemstone.gemfire.pdx.PdxSerializable;
import com.gemstone.gemfire.pdx.PdxWriter;

public class Rule implements PdxSerializable {

    private RuleKey key;
    private String rule;

    public Rule() {
    }

    public Rule(RuleKey key, String rule) {
        this.key = key;
        this.rule = rule;
    }

    public RuleKey getKey() {
        return key;
    }

    public void setKey(RuleKey key) {
        this.key = key;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    @Override
    public String toString() {
        return "Rule [key=" + key + ", rule=" + rule + "]";
    }

    @Override
    public void fromData(PdxReader reader) {
        key = (RuleKey) reader.readObject("key");
        rule = reader.readString("rule");
    }

    @Override
    public void toData(PdxWriter writer) {
        writer.writeObject("key", key);
        writer.writeString("rule", rule);
    }

}
