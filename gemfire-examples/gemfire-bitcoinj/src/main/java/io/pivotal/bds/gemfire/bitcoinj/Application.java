package io.pivotal.bds.gemfire.bitcoinj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		new SpringApplication(Application.class).run(args);
	}
}
