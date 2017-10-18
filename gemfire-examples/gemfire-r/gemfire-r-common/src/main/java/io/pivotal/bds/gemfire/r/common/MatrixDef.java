package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

import org.apache.geode.DataSerializable;
import org.apache.geode.DataSerializer;

@SuppressWarnings("serial")
public class MatrixDef implements DataSerializable {

    private String queryId;
    private Object[] queryArgs;
    private String[] fields;

    public MatrixDef() {
    }

    public MatrixDef(String queryId, Object[] queryArgs, String[] fields) {
        this.queryId = queryId;
        this.queryArgs = queryArgs;
        this.fields = fields;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public Object[] getQueryArgs() {
        return queryArgs;
    }

    public void setQueryArgs(Object[] queryArgs) {
        this.queryArgs = queryArgs;
    }

    public String[] getFields() {
        return fields;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        queryId = DataSerializer.readString(input);
        queryArgs = DataSerializer.readObjectArray(input);
        fields = DataSerializer.readStringArray(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        DataSerializer.writeString(queryId, output);
        DataSerializer.writeObjectArray(queryArgs, output);
        DataSerializer.writeStringArray(fields, output);
    }

    @Override
    public String toString() {
        return "MatrixDef [queryId=" + queryId + ", queryArgs=" + Arrays.toString(queryArgs) + ", fields=" + Arrays.toString(fields)
                + "]";
    }

}
