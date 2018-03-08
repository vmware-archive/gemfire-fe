package io.pivotal.pde.kube.app;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@Slf4j
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GemfireKubeTestApplication {

    Region<String, String> region;

    public GemfireKubeTestApplication(Region<String, String> region) {
        this.region = region;
    }

    @Bean
    public static ClientCache cache(@Value("${locatorHost:localhost}") String locatorHost, @Value("${locatorPort:10334}") int locatorPort) {
        log.info("cache: locatorHost={}, locatorPort={}", locatorHost, locatorPort);
        ClientCacheFactory ccf = new ClientCacheFactory();
        ccf.addPoolLocator(locatorHost, locatorPort);
        return ccf.create();
    }

    @Bean
    public static Region<String, String> region(ClientCache cache) {
        log.info("region");
        ClientRegionFactory<String, String> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        return crf.create("test");
    }

    @PostMapping(value = "/{key}/{value}", produces = "text/plain")
    public String put(@PathVariable("key") String key, @PathVariable("value") String value) {
        log.info("put: key={}, value={}", key, value);
        return region.put(key, value);
    }

    @GetMapping(value = "/{key}", produces = "text/plain")
    public String get(@PathVariable("key") String key) {
        log.info("get: key={}", key);
        return region.get(key);
    }

    public static void main(String[] args) {
        new SpringApplication(GemfireKubeTestApplication.class).run(args);
    }
}
