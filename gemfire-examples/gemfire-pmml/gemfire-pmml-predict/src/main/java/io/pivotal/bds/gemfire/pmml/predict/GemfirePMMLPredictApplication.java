package io.pivotal.bds.gemfire.pmml.predict;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@SpringBootApplication
@EnableTask
public class GemfirePMMLPredictApplication {

    public static void main(String[] args) {
        new SpringApplication(GemfirePMMLPredictApplication.class).run(args);
    }
}
