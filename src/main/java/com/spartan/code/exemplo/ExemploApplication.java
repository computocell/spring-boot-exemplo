package com.spartan.code.exemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.spartan.code.exemplo.domain.Contact;

@EnableJpaAuditing
@SpringBootApplication
public class ExemploApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExemploApplication.class, args);

	}
}
