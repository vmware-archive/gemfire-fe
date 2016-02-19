package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;

public class KernelKey implements DataSerializable {

    private String kernelId;

    public KernelKey() {
    }

    public KernelKey(String kernelId) {
        this.kernelId = kernelId;
    }

    public String getKernelId() {
        return kernelId;
    }

    public void setKernelId(String kernelId) {
        this.kernelId = kernelId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((kernelId == null) ? 0 : kernelId.hashCode());
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
        KernelKey other = (KernelKey) obj;
        if (kernelId == null) {
            if (other.kernelId != null)
                return false;
        } else if (!kernelId.equals(other.kernelId))
            return false;
        return true;
    }

    @Override
    public void fromData(DataInput arg0) throws IOException, ClassNotFoundException {
        // TODO Auto-generated method stub

    }

    @Override
    public void toData(DataOutput arg0) throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return "KernelKey [kernelId=" + kernelId + "]";
    }

}
