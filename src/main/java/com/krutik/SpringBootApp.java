package com.krutik;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApp implements CommandLineRunner {

	Logger log = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] a) {
		SpringApplication.run(SpringBootApp.class, a);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
