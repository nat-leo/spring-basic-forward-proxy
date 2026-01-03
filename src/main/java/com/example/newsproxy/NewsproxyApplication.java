package com.example.newsproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewsProxyApplication {
	/**
	 * SpringApplication.run(): a static helper method that starts the app
	 *   - NewsProxyApplication.class is the primary source/config for the app - 
	 * the class with @SpringBootApplication
	 *   - args are command line args that you can add to your app like java -jar app.jar --server.port=8080
	 */
	public static void main(String[] args) {
		SpringApplication.run(NewsProxyApplication.class, args);
		/* run() does soome crazy stuff

		1. Creates ApplicationContext - an IoC container to mamnage the app's Beans
		2. Registers Config - makes NewsProxyApplication.class the source of the bean definitions
		3. Triggers Auto-Config - @EnableAutoConfig comes with @SpringBootApplication. It runs everything
		I need depending on what's in build.gradle.
		4. Triggers Component Scan - @ComponentScan scans the current packages and subpackages to be registered
		as beans (like any @Componnt, @Service, @Repository, etc.)
		5. Load the Beans - All the beans get loaded and wired (they all act as singletons and the wiring is a 
		dependency injection.)
		6. Run! - Looks for beans that implement CommandLineRuner or ApplicationRunner interfaces and runs that.
		(hint - devs can execute specific logic here immediately on startup.)
		 */
	}
}
