package io.pivotal.bds.gemfire.drools.common;

import org.drools.compiler.kproject.ReleaseIdImpl;
import org.kie.api.builder.ReleaseId;

import com.gemstone.gemfire.pdx.PdxReader;
import com.gemstone.gemfire.pdx.PdxSerializable;
import com.gemstone.gemfire.pdx.PdxWriter;

public class RuleExecutionContext implements PdxSerializable {

    private ReleaseId releaseId;
    private Object arguments;

    public RuleExecutionContext() {
    }

    public RuleExecutionContext(ReleaseId releaseId, Object arguments) {
        this.releaseId = releaseId;
        this.arguments = arguments;
    }

    public ReleaseId getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(ReleaseId releaseId) {
        this.releaseId = releaseId;
    }

    public Object getArguments() {
        return arguments;
    }

    public void setArguments(Object arguments) {
        this.arguments = arguments;
    }

    @Override
    public void fromData(PdxReader reader) {
        String groupId = reader.readString("groupId");
        String artifactId = reader.readString("artifactId");
        String version = reader.readString("version");

        this.releaseId = new ReleaseIdImpl(groupId, artifactId, version);
        this.arguments = reader.readObject("arguments");
    }

    @Override
    public void toData(PdxWriter writer) {
        writer.writeString("groupId", releaseId.getGroupId());
        writer.writeString("artifactId", releaseId.getArtifactId());
        writer.writeString("version", releaseId.getVersion());
        writer.writeObject("arguments", arguments);
    }

    @Override
    public String toString() {
        return "RuleExecutionContext [releaseId=" + releaseId + ", arguments=" + arguments + "]";
    }
}
