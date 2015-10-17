package io.pivotal.bds.gemfire.drools.test;

import java.io.FileReader;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.Message.Level;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class HelloWorld {

    public static void main(String[] args) throws Exception {
        String sr = null;
        FileReader fr = new FileReader("src/test/resources/rules/test.drl");

        try {
            char[] ch = new char[10000];
            int l = fr.read(ch);
            sr = new String(ch, 0, l);
        } finally {
            fr.close();
        }

        KieServices ks = KieServices.Factory.get();
        KieRepository kr = ks.getRepository();

        KieFileSystem kfs = ks.newKieFileSystem();
        kfs.write("src/main/resources/io/pivotal/bds/gemfire/drools/test.drl", sr);

        KieBuilder kb = ks.newKieBuilder(kfs);
        kb.buildAll();

        if (kb.getResults().hasMessages(Level.ERROR)) {
            throw new RuntimeException("Build Errors:\n" + kb.getResults().toString());
        }

        KieContainer kContainer = ks.newKieContainer(kr.getDefaultReleaseId());
        StatelessKieSession s = kContainer.newStatelessKieSession();
        s.execute("");
    }
}
