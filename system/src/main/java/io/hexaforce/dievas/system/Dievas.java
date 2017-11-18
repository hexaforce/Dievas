package io.hexaforce.dievas.system;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.hexaforce.dievas.DievasBatchApplication;
import io.hexaforce.dievas.DievasCommonApplication;
import io.hexaforce.dievas.DievasDataApplication;
import io.hexaforce.dievas.DievasServiceApplication;
import io.hexaforce.dievas.DievasWebApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Dievas implements WebMvcConfigurer {

	public static void main(String[] args) {
		new SpringApplicationBuilder().bannerMode(Banner.Mode.CONSOLE)
				.sources(DievasCommonApplication.class, DievasDataApplication.class, DievasServiceApplication.class,
						DievasBatchApplication.class, DievasWebApplication.class, Dievas.class)
				.run(args);
	}
	
}
