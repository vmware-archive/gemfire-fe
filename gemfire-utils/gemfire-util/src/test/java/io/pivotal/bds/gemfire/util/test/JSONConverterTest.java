package io.pivotal.bds.gemfire.util.test;

import java.io.FileReader;

import org.json.JSONObject;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.pdx.PdxInstance;

import io.pivotal.bds.gemfire.util.JSONConverter;

public class JSONConverterTest {

    public static void main(String[] args) throws Exception {
        String data = null;
        FileReader fr = new FileReader("src/test/resources/test.json");

        try {
            char[] ch = new char[127 * 1024];
            int len = fr.read(ch);
            data = new String(ch, 0, len);
        } finally {
            fr.close();
        }

        JSONObject json = new JSONObject(data);

        CacheFactory cf = new CacheFactory();

        cf.setPdxPersistent(true);
        cf.setPdxReadSerialized(true);

        @SuppressWarnings("unused")
        Cache c = cf.create();

        PdxInstance pi1 = JSONConverter.convertToPdx(data, "TestObject", "io.pivotal.bds.gemfire.test", null);
        System.out.println(pi1);

        PdxInstance pi2 = JSONConverter.convertToPdx(json, "TestObject", "io.pivotal.bds.gemfire.test", null);
        System.out.println(pi2);
    }
}
