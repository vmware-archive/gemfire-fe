package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

@SuppressWarnings("serial")
public class FFTResponse implements DataSerializable {

    private FFTRequest request;
    private Object result;

    public FFTResponse() {
    }

    public FFTResponse(FFTRequest request, Object result) {
        this.request = request;
        this.result = result;
    }

    public FFTRequest getRequest() {
        return request;
    }

    public void setRequest(FFTRequest request) {
        this.request = request;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        request = new FFTRequest();
        request.fromData(in);
        result = DataSerializer.readObject(in);
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        request.toData(out);
        DataSerializer.writeObject(result, out);
    }

    @Override
    public String toString() {
        return "FFTResponse [request=" + request + ", result=" + result + "]";
    }

}
