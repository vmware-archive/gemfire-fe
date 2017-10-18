package io.pivotal.bds.gemfire.pmml.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GemfirePMMLServerApplication {

	public static void main(String[] args) throws Exception {
		new SpringApplication(GemfirePMMLServerApplication.class).run(args);
	}
}
