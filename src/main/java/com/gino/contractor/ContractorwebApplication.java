package com.gino.contractor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * When packaging the project into WAR file
 * first add in pom : <packaging>war</packaging>
 * then here extends SpringBootServletInitialize
 * then add protected SpringApplicationBuilder configure method like below ..
 * 
 * @author gino
 *
 */
@SpringBootApplication
public class ContractorwebApplication extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ContractorwebApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ContractorwebApplication.class, args);
	}

}
