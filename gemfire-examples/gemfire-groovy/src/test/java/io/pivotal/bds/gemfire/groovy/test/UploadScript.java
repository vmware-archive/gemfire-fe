package io.pivotal.bds.gemfire.groovy.test;

import java.io.File;
import java.io.FileReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;

public class UploadScript {

    private static final Logger LOG = LoggerFactory.getLogger(UploadScript.class);

    public static void main(String[] args) throws Exception {
        LOG.info("creating ClientCacheFactory");
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("localhost", 10334);
        ccf.setPdxSerializer(
                new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.groovy.data.*,io.pivotal.bds.gemfire.data.ecom.*"));

        LOG.info("creating ClientCache");
        ClientCache cc = ccf.create();

        try {
            LOG.info("creating script Region");
            ClientRegionFactory<String, String> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
            Region<String, String> r = crf.create("script");

            LOG.info("uploading scripts");
            uploadFiles(r);
        } finally {
            LOG.info("closing ClientCache");
            cc.close();
        }
    }

    private static void uploadFiles(Region<String, String> r) throws Exception {
        File dir = new File("src/test/resources");
        File[] files = dir.listFiles();

        for (File f : files) {
            uploadFile(f, r);
        }
    }

    private static void uploadFile(File f, Region<String, String> r) throws Exception {
        LOG.info("uploading script {}", f.getName());
        FileReader fr = new FileReader(f);

        try {
            char[] c = new char[100000];
            int len = fr.read(c);
            String s = new String(c, 0, len);

            String k = f.getName();
            r.put(k, s);
        } finally {
            fr.close();
        }
    }
}
