package com.murilovieira.testesicred;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class TestesicredApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestesicredApplication.class, args);
	}

}
