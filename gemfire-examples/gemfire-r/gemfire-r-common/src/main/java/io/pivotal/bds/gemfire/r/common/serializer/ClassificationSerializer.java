package io.pivotal.bds.gemfire.r.common.serializer;

import java.io.DataInput;
import java.io.DataOutput;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.jpmml.evaluator.Classification;

public abstract class ClassificationSerializer<T extends Classification> extends BaseSerializer<T> {

    public ClassificationSerializer(Class<T> clazz) {
        super(clazz);
    }
    
    private Class<?> findClassificationClass(Class<T> clazz) {
        Class<?> c = clazz;
        
        while (c != null && c != Object.class && c != Classification.class ) {
            c = c.getSuperclass();
        }
        
        return c;
    }

    @Override
    protected void _fromData(T t, DataInput in) throws Exception {
        HashMap<String, Double> map = readHashMap(in);
        Object result = readObject(in);
        
        Class<?> c = findClassificationClass(clazz);

        Field fld = c.getDeclaredField("map");
        fld.setAccessible(true);
        fld.set(t, map);

        fld = c.getDeclaredField("result");
        fld.setAccessible(true);
        fld.set(t, result);
    }

    @Override
    protected void _toData(T t, DataOutput out) throws Exception {
        Class<?> c = findClassificationClass(clazz);

        Field fld = c.getDeclaredField("map");
        fld.setAccessible(true);
        @SuppressWarnings("unchecked")
        Map<String, Double> map = (Map<String, Double>) fld.get(t);
        
        HashMap<String,Double> hm = null;
        
        if (map instanceof HashMap) {
            hm = (HashMap<String, Double>)map;
        } else {
            hm = new HashMap<>(map);
        }
        
        writeHashMap(hm, out);

        fld = c.getDeclaredField("result");
        fld.setAccessible(true);
        Object result = fld.get(t);
        
        writeObject(result, out);
    }

}
