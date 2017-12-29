package io.hexaforce.management;

import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableAutoConfiguration
public class Management {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder()
			.sources(Management.class)
			.bannerMode(Banner.Mode.CONSOLE)
			.run(args);
	}
	
}
