package io.pivotal.bds.gemfire.geojson.test;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.pdx.PdxInstance;
import org.apache.geode.pdx.PdxInstanceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/here/nav/link")
public class NavLinkLoadController {

    private ClientCache cache;
    private Region<String, PdxInstance> navLinkRegion;
    private boolean running = false;

    private static Executor exec = Executors.newSingleThreadExecutor();
    private static final Logger LOG = LoggerFactory.getLogger(NavLinkLoadController.class);

    @Autowired
    public NavLinkLoadController(ClientCache cache, Region<String, PdxInstance> navLinkRegion) {
        this.cache = cache;
        this.navLinkRegion = navLinkRegion;
    }

    @RequestMapping(value = "/load", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public synchronized void load(String fileName) throws Exception {
        if (running) {
            LOG.warn("load: NavLink load already running: fileName={}", fileName);
        }

        running = true;

        exec.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
                        int count = 0;
                        String line = null;

                        while ((line = reader.readLine()) != null) {
                            String[] cols = line.split("\t");
                            Assert.isTrue(cols.length == 36);

                            String id = cols[0];
                            int fromSpeedLimit = Integer.parseInt(cols[25]);
                            int toSpeedLimit = Integer.parseInt(cols[26]);

                            PdxInstanceFactory pif = cache.createPdxInstanceFactory("NavLink");

                            pif.writeInt("fromSpeedLimit", fromSpeedLimit);
                            pif.writeInt("toSpeedLimit", toSpeedLimit);

                            PdxInstance inst = pif.create();

                            navLinkRegion.put(id, inst);

                            if (++count % 1000 == 0) {
                                LOG.info("loaded {} records");
                            }
                        }
                    }
                } catch (Exception x) {
                    LOG.error("load: x={}", x.toString(), x);
                } finally {
                    running = false;
                }
            }
        });
    }
}
