package com.elcom.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.elcom.library.**")
public class LibraryApplication {

	public static void main(String[] args) {

		SpringApplication.run(LibraryApplication.class, args);
		Logger logger = LoggerFactory.getLogger(LibraryApplication.class);
		logger.error("Error");
		logger.warn("Warn");
		logger.info("Info");
	}


}
