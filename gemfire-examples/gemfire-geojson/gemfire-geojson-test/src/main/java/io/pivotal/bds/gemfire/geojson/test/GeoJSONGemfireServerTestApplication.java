package io.pivotal.bds.gemfire.geojson.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeoJSONGemfireServerTestApplication {

    public static void main(String[] args) throws Exception {
        new SpringApplication(GeoJSONGemfireServerTestApplication.class).run(args);
    }
}
