package io.pivotal.bds.gemfire.kafka;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.DatatypeConverter;

import org.apache.kafka.common.serialization.Serializer;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.pdx.PdxInstance;

public abstract class BaseJsonSerializer<T> implements Serializer<T> {

    private static final Set<Class<?>> intrinsics;

    static {
        intrinsics = new HashSet<>();

        intrinsics.add(String.class);
        intrinsics.add(Boolean.class);
        intrinsics.add(Short.class);
        intrinsics.add(Integer.class);
        intrinsics.add(Long.class);
        intrinsics.add(Double.class);
    }

    protected final Logger LOG;

    public BaseJsonSerializer() {
        LOG = LoggerFactory.getLogger(getClass());
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    protected byte[] serialize(Object key, Object value, Operation op) {
        LOG.debug("serialize: op={}, key={}, value={}", op, key, value);

        try {
            JSONObject root = new JSONObject();

            convert(root, "key", key);
            convert(root, "value", value);
            root.put("operation", op.toString());

            String json = root.toString();
            LOG.debug("serialize: op={}, key={}, value={}, json={}", op, key, value, json);

            byte[] b = json.getBytes("UTF-8");
            return b;
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    private void convert(JSONObject parent, String name, Object value) throws Exception {
        LOG.debug("convert: name={}, value={}", name, value);

        if (value == null) {
            return;
        }

        Class<?> c = value.getClass();

        if (intrinsics.contains(c)) {
            LOG.debug("convert: intrinsic: name={}, value={}", name, value);
            parent.put(name, value);
        } else if (c == Date.class) {
            Date d = (Date) value;
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            String date = DatatypeConverter.printDateTime(cal);
            LOG.debug("convert: date: name={}, value={}, date={}", name, value, date);
            parent.put(name, date);
        } else if (PdxInstance.class.isAssignableFrom(c)) {
            PdxInstance inst = (PdxInstance) value;
            JSONObject json = convert(inst);
            LOG.debug("convert: pdx: name={}, value={}, json={}", name, value, json);
            parent.put(name, json);
        } else {
            JSONObject json = convert(value, c);
            LOG.debug("convert: pojo: name={}, value={}, json={}", name, value, json);
            parent.put(name, json);
        }
    }

    private JSONObject convert(Object value, Class<?> c) throws Exception {
        JSONObject obj = new JSONObject();
        convert(obj, value, c);
        return obj;
    }

    private void convert(JSONObject obj, Object value, Class<?> c) throws Exception {
        LOG.debug("convert: value={}, class={}", value, c);

        for (Field f : c.getDeclaredFields()) {
            int mods = f.getModifiers();

            if (!Modifier.isStatic(mods) && !Modifier.isTransient(mods)) {
                String fn = f.getName();
                f.setAccessible(true);
                Object fv = f.get(value);
                LOG.debug("convert: value={}, class={}, fn={}, fv={}", value, c, fn, fv);
                convert(obj, fn, fv);
            }
        }

        Class<?> cp = c.getSuperclass();

        if (cp != null && cp != Object.class) {
            convert(obj, value, cp);
        }
    }

    private JSONObject convert(PdxInstance inst) throws Exception {
        LOG.debug("convert: inst={}", inst);
        JSONObject json = new JSONObject();

        for (String fn : inst.getFieldNames()) {
            Object fv = inst.getField(fn);
            convert(json, fn, fv);
        }

        LOG.debug("convert: inst={}, json={}", inst, json);
        return json;
    }

    @Override
    public void close() {
    }

}
