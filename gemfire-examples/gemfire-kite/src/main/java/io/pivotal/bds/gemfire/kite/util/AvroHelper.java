package io.pivotal.bds.gemfire.kite.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;
import org.apache.avro.Schema.Type;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.util.Utf8;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.pdx.PdxInstance;
import com.gemstone.gemfire.pdx.PdxInstanceFactory;

public class AvroHelper {

    private static final Logger LOG = LoggerFactory.getLogger(AvroHelper.class);

    public static PdxInstance convertToPdx(GenericRecord record) {
        Schema schema = record.getSchema();
        String name = schema.getName();
        LOG.debug("convertToPdx: name={}, record={}, schema={}", name, record, schema);

        PdxInstanceFactory pif = CacheFactory.getAnyInstance().createPdxInstanceFactory(name);

        for (Field field : schema.getFields()) {
            String fn = field.name();
            Schema fs = field.schema();
            Type ft = fs.getType();
            Object fo = record.get(fn);
            Class<?> fc = fo.getClass();

            LOG.debug("fn={}, ft={}, fo={}, fc.getName()={}, fc.isArray()={}", fn, ft, fo, fc.getName(), fc.isArray());

            switch (ft) {
                case RECORD: {
                    GenericRecord fr = (GenericRecord) fo;
                    PdxInstance fi = convertToPdx(fr);
                    pif.writeObject(fn, fi);
                    break;
                }
                case ARRAY: {
                    @SuppressWarnings("unchecked")
                    List<GenericRecord> fr = (List<GenericRecord>) fo;
                    List<PdxInstance> l = new ArrayList<>();

                    for (GenericRecord rec : fr) {
                        PdxInstance pi = convertToPdx(rec);
                        l.add(pi);
                    }

                    pif.writeObject(fn, l);
                    break;
                }
                default: {
                    Class<?> c = fo.getClass();

                    if (c == String.class) {
                        pif.writeString(fn, (String) fo);
                    } else if (c == Utf8.class) {
                        Utf8 u = (Utf8) fo;
                        String s = u.toString();
                        pif.writeString(fn, s);
                    } else if (c == int.class || c == Integer.class) {
                        pif.writeInt(fn, (int) fo);
                    } else if (c == long.class || c == Long.class) {
                        pif.writeLong(fn, (long) fo);
                    } else if (c == boolean.class || c == Boolean.class) {
                        pif.writeBoolean(fn, (boolean) fo);
                    } else if (c == double.class || c == Double.class) {
                        pif.writeDouble(fn, (double) fo);
                    } else if (c == Date.class) {
                        pif.writeDate(fn, (Date) fo);
                    } else {
                        pif.writeObject(fn, fo);
                    }
                }
            }
        }

        PdxInstance inst = pif.create();
        LOG.debug("convertToPdx: inst={}, record={}", inst, record);
        return inst;
    }

    public static GenericRecord convertToAvro(PdxInstance inst, Schema schema) {
        LOG.debug("convertToAvro: inst={}, schema={}", inst, schema);

        GenericRecord record = new GenericData.Record(schema);

        for (Field field : schema.getFields()) {
            Schema fs = field.schema();
            String fn = field.name();
            Type ft = fs.getType();

            Object fo = inst.getField(fn);

            switch (ft) {
                case RECORD: {
                    PdxInstance fi = (PdxInstance) fo;
                    GenericRecord fr = convertToAvro(fi, fs);
                    record.put(fn, fr);
                    break;
                }
                case ARRAY: {
                    @SuppressWarnings("unchecked")
                    List<Object> l = (List<Object>) fo;
                    GenericData.Array<GenericRecord> arr = new GenericData.Array<>(0, fs);

                    for (Object o : l) {
                        PdxInstance fi = (PdxInstance) o;
                        GenericRecord fr = convertToAvro(fi, fs.getElementType());
                        arr.add(fr);
                    }

                    record.put(fn, arr);

                    break;
                }
                default: {
                    record.put(fn, fo);
                }
            }
        }

        LOG.debug("convertToAvro: record={}, inst={}, schema={}", record, inst, schema);
        return record;
    }
}
