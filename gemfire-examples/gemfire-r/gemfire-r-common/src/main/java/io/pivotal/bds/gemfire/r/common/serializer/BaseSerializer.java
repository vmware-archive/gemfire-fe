package io.pivotal.bds.gemfire.r.common.serializer;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializer;

public abstract class BaseSerializer<T> extends DataSerializer {

    protected Class<T> clazz;

    public BaseSerializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Class<?>[] getSupportedClasses() {
        return new Class[] { clazz };
    }

    @Override
    public final Object fromData(DataInput in) throws IOException, ClassNotFoundException {
        try {
            T t = clazz.newInstance();
            _fromData(t, in);
            return t;
        } catch (ClassNotFoundException x) {
            throw x;
        } catch (IOException x) {
            throw x;
        } catch (Exception x) {
            throw new IOException(x.toString());
        }
    }

    @Override
    public final boolean toData(Object obj, DataOutput out) throws IOException {
        if (!clazz.isInstance(obj)) {
            return false;
        }

        try {
            _toData(clazz.cast(obj), out);
        } catch (Exception x) {
            throw new IOException(x.toString(), x);
        }
        return true;
    }

    protected abstract void _fromData(T t, DataInput in) throws Exception;

    protected abstract void _toData(T t, DataOutput out) throws Exception;
}
