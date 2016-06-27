package io.pivotal.bds.gemfire.kafka;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.DatatypeConverter;

import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.pdx.PdxInstance;

public abstract class BaseCSVSerializer<T> implements Serializer<T> {

    private static final Set<Class<?>> intrinsics;

    static {
        intrinsics = new HashSet<>();

        intrinsics.add(Boolean.class);
        intrinsics.add(Short.class);
        intrinsics.add(Integer.class);
        intrinsics.add(Long.class);
        intrinsics.add(Double.class);
    }

    protected final Logger LOG;

    public BaseCSVSerializer() {
        LOG = LoggerFactory.getLogger(getClass());
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    protected byte[] serialize(Object key, Object value, Operation op) {
        LOG.debug("serialize: op={}, key={}, value={}", op, key, value);

        try {
            List<String> list = new ArrayList<>();

            list.add("\"" + op.toString() + "\"");

            if (PdxInstance.class.isInstance(value)) {
                PdxInstance inst = (PdxInstance) value;
                convertPdx(list, inst);
            } else {
                convertObject(list, value);
            }

            StringBuilder buf = new StringBuilder();

            for (int i = 0; i < list.size(); ++i) {
                String s = list.get(i);

                if (i > 0) {
                    buf.append(',');
                }

                if (s != null) {
                    buf.append(s);
                }
            }

            String csv = buf.toString();
            LOG.debug("serialize: op={}, key={}, value={}, csv={}", op, key, value, csv);

            byte[] b = csv.getBytes("UTF-8");
            return b;
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    private void convertObject(List<String> list, Object obj) throws Exception {
        Class<?> c = obj.getClass();
        convert(list, obj, c);
    }

    private void convertPdx(List<String> list, PdxInstance inst) throws Exception {
        for (String s : inst.getFieldNames()) {
            Object o = inst.getField(s);
            convertField(list, o);
        }
    }

    private void convertField(List<String> list, Object value) throws Exception {
        LOG.debug("convertField: value={}", value);

        if (value == null) {
            list.add(null);
            return;
        }

        Class<?> c = value.getClass();

        if (c == String.class) {
            String s = (String) value;
            LOG.debug("convertField: string: value={}, s={}", value, s);
            list.add("\"" + s + "\"");
        } else if (c == Date.class) {
            Date d = (Date) value;
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            String s = DatatypeConverter.printDateTime(cal);
            LOG.debug("convertField: date: value={}, s={}", value, s);
            list.add("\"" + s + "\"");
        } else if (intrinsics.contains(c)) {
            String s = value.toString();
            LOG.debug("convertField: intrinsic: value={}, s={}", value, s);
            list.add(s);
        } else {
            throw new IllegalArgumentException("Cannot handle value type: " + c.getName());
        }
    }

    private void convert(List<String> list, Object value, Class<?> c) throws Exception {
        LOG.debug("convert: value={}, class={}", value, c);

        for (Field f : c.getDeclaredFields()) {
            int mods = f.getModifiers();

            if (!Modifier.isStatic(mods) && !Modifier.isTransient(mods)) {
                String fn = f.getName();
                f.setAccessible(true);
                Object fv = f.get(value);
                LOG.debug("convert: value={}, class={}, fn={}, fv={}", value, c, fn, fv);
                convertField(list, fv);
            }
        }

        Class<?> cp = c.getSuperclass();

        if (cp != null && cp != Object.class) {
            convert(list, value, cp);
        }
    }

    @Override
    public void close() {
    }

}
