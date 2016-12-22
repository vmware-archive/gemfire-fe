package io.pivotal.bds.gemfire.geojson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeoJSONGemfireServerApplication {

    public static void main(String[] args) throws Exception {
        new SpringApplication(GeoJSONGemfireServerApplication.class).run(args);
    }
}
