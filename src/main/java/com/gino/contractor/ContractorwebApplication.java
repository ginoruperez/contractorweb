package com.gino.contractor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * When packaging the project into WAR file
 * first add in pom : <packaging>war</packaging>
 * then here extends SpringBootServletInitialize
 * then add protected SpringApplicationBuilder configure method like below ..
 * 
 * @author Gino Ruperez
 *
 */
@SpringBootApplication
public class ContractorwebApplication extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ContractorwebApplication.class);
	}

	/**
	 * This is the main method to start the backend application 
	 * 
	 * @param args is an optional parameter only, by default its none
	 */
	public static void main(String[] args) {
		SpringApplication.run(ContractorwebApplication.class, args);
	}

}
