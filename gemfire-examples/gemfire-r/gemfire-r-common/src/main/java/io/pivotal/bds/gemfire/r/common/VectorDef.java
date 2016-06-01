package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

@SuppressWarnings("serial")
public class VectorDef implements DataSerializable {

    private String queryId;
    private Object[] queryArgs;
    private String field;

    public VectorDef() {
    }

    public VectorDef(String queryId, Object[] queryArgs, String field) {
        this.queryId = queryId;
        this.queryArgs = queryArgs;
        this.field = field;
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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        queryId = DataSerializer.readString(input);
        queryArgs = DataSerializer.readObjectArray(input);
        field = DataSerializer.readString(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        DataSerializer.writeString(queryId, output);
        DataSerializer.writeObjectArray(queryArgs, output);
        DataSerializer.writeString(field, output);
    }

    @Override
    public String toString() {
        return "VectorDef [queryId=" + queryId + ", queryArgs=" + Arrays.toString(queryArgs) + ", field=" + field + "]";
    }

}
