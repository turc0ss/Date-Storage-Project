package com.tmattila.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/***
 * 
 * @author tapsa
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.tmattila"})
@EnableMongoRepositories({"com.tmattila"})
public class App extends SpringBootServletInitializer {

	/**
	 * 
	 * The main class to launch the app. Most important class.
	 * @param args
	 * 
	 */
	public static void main(final String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Override
	protected final SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}
}
