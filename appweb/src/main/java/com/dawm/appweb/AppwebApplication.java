package com.dawm.appweb;

import javax.websocket.Decoder.Text;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class AppwebApplication {

	@Value("${app.nombre}")
	private static String name;

	public static void main(String[] args) {
		log.info("Arrancando appweb...");
		SpringApplication.run(AppwebApplication.class, args);
		log.info("Appweb arrancada {}", name);
	}

}
