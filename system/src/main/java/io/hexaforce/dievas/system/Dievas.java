package io.hexaforce.dievas.system;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.hexaforce.dievas.batch.DievasBatchApplication;
import io.hexaforce.dievas.commons.DievasCommonApplication;
import io.hexaforce.dievas.database.DievasDataApplication;
import io.hexaforce.dievas.web.DievasWebApplication;
import io.hexaforce.service.DievasServiceApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Dievas implements WebMvcConfigurer {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
			.sources(DievasCommonApplication.class)
			.sources(DievasDataApplication.class)
			.sources(DievasBatchApplication.class)
			.sources(DievasServiceApplication.class)
			.sources(DievasWebApplication.class)
			.sources(Dievas.class)
			.bannerMode(Banner.Mode.CONSOLE)
			.run(args);
	}

}
