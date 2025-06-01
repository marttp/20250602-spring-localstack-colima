package dev.tpcoder.localstackdemo;

import org.springframework.boot.SpringApplication;

public class TestLocalstackDemoApplication {

	public static void main(String[] args) {
		SpringApplication.from(LocalstackDemoApplication::main)
				.with(TestcontainersConfiguration.class)
				.run(args);
	}

}
