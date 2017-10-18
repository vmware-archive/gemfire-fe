package io.pivotal.bds.gemfire.pmml.train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@SpringBootApplication
@EnableTask
public class GemfirePMMLTrainApplication {

    public static void main(String[] args) {
        new SpringApplication(GemfirePMMLTrainApplication.class).run(args);
    }
}
