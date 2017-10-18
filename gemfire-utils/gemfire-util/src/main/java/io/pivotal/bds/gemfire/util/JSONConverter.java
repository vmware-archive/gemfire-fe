package io.pivotal.bds.gemfire.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import org.apache.geode.cache.CacheFactory;
import org.apache.geode.pdx.PdxInstance;
import org.apache.geode.pdx.PdxInstanceFactory;

public class JSONConverter {

    private static ThreadLocal<String> pkgHolder = new ThreadLocal<>();
    private static ThreadLocal<Map<String, String>> nameMappingsHolder = new ThreadLocal<>();

    private static final Map<Class<?>, AbstractWriter> writers;

    static {
        writers = new HashMap<>();

        writers.put(String.class, new StringWriter());
        writers.put(Integer.class, new IntegerWriter());
        writers.put(int.class, new PrimitiveIntWriter());
        writers.put(Long.class, new LongWriter());
        writers.put(long.class, new PrimitiveLongWriter());
        writers.put(Double.class, new DoubleWriter());
        writers.put(double.class, new PrimitiveDoubleWriter());
        writers.put(Boolean.class, new BooleanWriter());
        writers.put(boolean.class, new PrimitiveBooleanWriter());
        writers.put(JSONObject.class, new JSONObjectWriter());
        writers.put(JSONObject.NULL.getClass(), new NullWriter());
        writers.put(JSONArray.class, new JSONArrayWriter());
    }

    public static PdxInstance convertToPdx(String json, String name, String pkg, Map<String, String> nameMappings) {
        return convertToPdx(new JSONObject(json), name, pkg, nameMappings);
    }

    public static PdxInstance convertToPdx(JSONObject json, String name, String pkg, Map<String, String> nameMappings) {
        pkgHolder.set(pkg);

        if (nameMappings == null) {
            nameMappingsHolder.remove();
        } else {
            nameMappingsHolder.set(nameMappings);
        }

        String fullName = pkg + "." + name;
        PdxInstanceFactory pif = CacheFactory.getAnyInstance().createPdxInstanceFactory(fullName);

        for (String key : json.keySet()) {
            Object value = json.get(key);
            write(key, value, pif);
        }

        return pif.create();
    }

    private static void write(String key, Object value, PdxInstanceFactory pif) {
        if (value != null) {
            Class<?> c = value.getClass();
            AbstractWriter writer = writers.get(c);

            if (writer == null) {
                throw new IllegalArgumentException("Cannot handle type: " + c.getName());
            }

            writer.write(key, value, pif);
        }
    }

    private static abstract class AbstractWriter {
        public abstract void write(String key, Object value, PdxInstanceFactory pif);
    }

    private static class NullWriter extends AbstractWriter {

        @Override
        public void write(String key, Object value, PdxInstanceFactory pif) {
        }
    }

    private static class StringWriter extends AbstractWriter {

        @Override
        public void write(String key, Object value, PdxInstanceFactory pif) {
            pif.writeString(key, value.toString());
        }
    }

    private static class IntegerWriter extends AbstractWriter {

        @Override
        public void write(String key, Object value, PdxInstanceFactory pif) {
            Integer i = (Integer) value;
            pif.writeInt(key, i);
        }
    }

    private static class PrimitiveIntWriter extends AbstractWriter {

        @Override
        public void write(String key, Object value, PdxInstanceFactory pif) {
            int i = (int) value;
            pif.writeInt(key, i);
        }
    }

    private static class LongWriter extends AbstractWriter {

        @Override
        public void write(String key, Object value, PdxInstanceFactory pif) {
            Long l = (Long) value;
            pif.writeLong(key, l);
        }
    }

    private static class PrimitiveLongWriter extends AbstractWriter {

        @Override
        public void write(String key, Object value, PdxInstanceFactory pif) {
            long l = (long) value;
            pif.writeLong(key, l);
        }
    }

    private static class DoubleWriter extends AbstractWriter {

        @Override
        public void write(String key, Object value, PdxInstanceFactory pif) {
            Double d = (Double) value;
            pif.writeDouble(key, d);
        }
    }

    private static class PrimitiveDoubleWriter extends AbstractWriter {

        @Override
        public void write(String key, Object value, PdxInstanceFactory pif) {
            double d = (double) value;
            pif.writeDouble(key, d);
        }
    }

    private static class BooleanWriter extends AbstractWriter {

        @Override
        public void write(String key, Object value, PdxInstanceFactory pif) {
            Boolean d = (Boolean) value;
            pif.writeBoolean(key, d);
        }
    }

    private static class PrimitiveBooleanWriter extends AbstractWriter {

        @Override
        public void write(String key, Object value, PdxInstanceFactory pif) {
            boolean d = (boolean) value;
            pif.writeBoolean(key, d);
        }
    }

    private static class JSONObjectWriter extends AbstractWriter {

        @Override
        public void write(String key, Object value, PdxInstanceFactory pif) {
            JSONObject json = (JSONObject) value;
            String name = convertAttrNameToClassName(key);
            PdxInstance inst = convertToPdx(json, name, pkgHolder.get(), nameMappingsHolder.get());
            pif.writeObject(key, inst);
        }
    }

    private static class JSONArrayWriter extends AbstractWriter {

        @Override
        public void write(String key, Object value, PdxInstanceFactory pif) {
            JSONArray array = (JSONArray) value;
            String name = convertAttrNameToClassName(key);

            List<Object> list = new ArrayList<>();

            for (int i = 0; i < array.length(); ++i) {
                Object av = array.get(i);
                if (av != null) {
                    Class<?> c = av.getClass();

                    if (c == JSONObject.class) {
                        JSONObject jobj = (JSONObject) av;
                        PdxInstance pi = convertToPdx(jobj, name, pkgHolder.get(), nameMappingsHolder.get());
                        list.add(pi);
                    } else {
                        list.add(av);
                    }
                }
            }

            pif.writeObject(key, list);
        }
    }

    private static String convertAttrNameToClassName(String attr) {
        Map<String, String> mappings = nameMappingsHolder.get();

        if (mappings != null) {
            String nm = mappings.get(attr);
            if (nm != null) {
                return nm;
            }
        }

        StringBuilder buf = new StringBuilder();
        char[] ch = attr.toCharArray();
        boolean nextCharIsUpper = true;

        for (int i = 0; i < ch.length; ++i) {
            char c = ch[i];

            if ((i == 0 && Character.isAlphabetic(c)) || i > 0) {
                switch (c) {
                    case '-':
                    case '_':
                        nextCharIsUpper = true;
                        break;
                    default: {
                        if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                            if (nextCharIsUpper) {
                                c = Character.toUpperCase(c);
                                nextCharIsUpper = false;
                            }

                            buf.append(c);
                        }
                        break;
                    }
                }
            }
        }

        return buf.toString();
    }
}
