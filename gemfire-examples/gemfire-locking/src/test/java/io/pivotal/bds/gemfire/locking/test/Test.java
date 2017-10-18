package io.pivotal.bds.gemfire.locking.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.cache.execute.FunctionService;

import io.pivotal.bds.gemfire.locking.LockingFunction;

public class Test {
    
    private static final Logger LOG = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws Exception {
        LOG.info("creating ClientCache");
        ClientCacheFactory ccf = new ClientCacheFactory();
        ccf.addPoolLocator("localhost", 10334);
        ClientCache cc = ccf.create();

        LOG.info("creating Region");
        ClientRegionFactory<String, Integer> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<String, Integer> cr = crf.create("Counter");

        List<Runner> list = new ArrayList<>();

        for (int i = 0; i < 5; ++i) {
            list.add(new Runner(cr, "key-" + i));
        }

        LOG.info("starting threads");
        for (Runner r : list) {
            r.start();
        }

        LOG.info("waiting");
        Thread.sleep(3000L);

        LOG.info("killing threads");
        for (Runner r : list) {
            r.kill();
        }

        LOG.info("done");
    }

    private static class Runner extends Thread {

        private Region<String, Integer> region;
        private String key;
        private Set<String> filter;

        private boolean running = true;

        public Runner(Region<String, Integer> region, String key) {
            super("Runner-" + key);
            setPriority(NORM_PRIORITY - 2);

            this.region = region;
            this.key = key;

            this.filter = new HashSet<>();
            filter.add(key);
        }

        public void kill() {
            running = false;
        }

        @Override
        public void run() {
            try {
                int count = 0;

                while (running) {
                    FunctionService.onRegion(region).withArgs(key).withFilter(filter).execute(LockingFunction.class.getSimpleName())
                            .getResult();

                    if (++count % 1000 == 0) {
                        System.out.println(key + ", " + count);
                    }
                }
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }
}
