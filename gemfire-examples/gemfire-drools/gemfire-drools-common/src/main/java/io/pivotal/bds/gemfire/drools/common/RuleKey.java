package io.pivotal.bds.gemfire.drools.common;

import org.kie.api.builder.ReleaseId;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class RuleKey implements PdxSerializable {

    private ReleaseId releaseId;
    private String name;

    public RuleKey() {
    }

    public RuleKey(ReleaseId releaseId, String name) {
        this.releaseId = releaseId;
        this.name = name;
    }

    public ReleaseId getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(ReleaseId releaseId) {
        this.releaseId = releaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((releaseId == null) ? 0 : releaseId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RuleKey other = (RuleKey) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (releaseId == null) {
            if (other.releaseId != null)
                return false;
        } else if (!releaseId.equals(other.releaseId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RuleKey [releaseId=" + releaseId + ", name=" + name + "]";
    }

    @Override
    public void fromData(PdxReader reader) {
        releaseId = (ReleaseId) reader.readObject("releaseId");
        name = reader.readString("name");
    }

    @Override
    public void toData(PdxWriter writer) {
        writer.writeObject("releaseId", releaseId);
        writer.writeString("name", name);
    }
}
