package dev.tpcoder.localstackdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class LocalstackDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalstackDemoApplication.class, args);
	}

}
