package io.pivotal.bds.gemfire.drools.test;

import java.io.File;
import java.io.FileReader;

import org.drools.compiler.kproject.ReleaseIdImpl;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;

import io.pivotal.bds.gemfire.drools.common.Rule;
import io.pivotal.bds.gemfire.drools.common.RuleKey;

public class UploadRules {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();
        ccf.addPoolLocator("localhost", 10334);
        ClientCache cc = ccf.create();

        try {
            ClientRegionFactory<RuleKey, Rule> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
            Region<RuleKey, Rule> r = crf.create("rule");
            uploadDir("src/test/resources/rules", r);
        } finally {
            cc.close();
        }
    }

    private static void uploadDir(String dir, Region<RuleKey, Rule> r) throws Exception {
        System.out.println("Uploading dir " + dir);

        File f = new File(dir);
        File[] fa = f.listFiles();

        for (File ft : fa) {
            uploadRule(ft, r);
        }
    }

    private static void uploadRule(File f, Region<RuleKey, Rule> r) throws Exception {
        System.out.println("Uploading file " + f.getPath());

        String sr = null;
        FileReader fr = new FileReader(f);

        try {
            char[] ch = new char[10000];
            int l = fr.read(ch);
            sr = new String(ch, 0, l);
        } finally {
            fr.close();
        }

        String name = f.getName();
        int pos = name.indexOf('.');
        name = name.substring(0, pos);

        RuleKey key = new RuleKey(new ReleaseIdImpl("io.pivotal.bds.gemfire.drools", "gemfire-drools", "1.0.0"), name);
        Rule rule = new Rule(key, sr);

        r.put(key, rule);
    }
}
