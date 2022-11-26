package com.dawm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		log.info("Arrancando appweb...");
		
		SpringApplication.run(WebApplication.class, args);

		log.info("Appweb arrancada.");
	}

}
