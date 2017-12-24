package io.hexaforce.dievas.system;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.h2.server.web.WebServlet;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.WebApplicationInitializer;

import io.hexaforce.dievas.batch.DievasBatchApplication;
import io.hexaforce.dievas.commons.DievasCommonApplication;
import io.hexaforce.dievas.database.DievasDataApplication;
import io.hexaforce.dievas.mypage.DievasMypageApplication;
import io.hexaforce.dievas.service.DievasServiceApplication;
import io.hexaforce.dievas.webapp.DievasWebApplication;
import lombok.extern.slf4j.Slf4j;

/**
 * Main build assembly.
 * 
 * @author T.Tantaka
 */
@Slf4j
@SpringBootApplication
@EnableAutoConfiguration
public class Dievas implements WebApplicationInitializer {

	@Autowired
	private Environment environment;
	
	public static void main(String[] args) {
		
		String spring_profiles_active;
//		FileCopyUtils.copy(in, out);
//		FileSystemUtils.deleteRecursively(root);
		
		for (String bootParameter : args) {
			int index = bootParameter.lastIndexOf("spring.profiles.active");
			if (index != -1) {
				spring_profiles_active = bootParameter.substring(index, bootParameter.length()).replace("=", "");
			}
		}
		
		new SpringApplicationBuilder()
			.sources(DievasCommonApplication.class)
			.sources(DievasDataApplication.class)
			.sources(DievasBatchApplication.class)
			.sources(DievasServiceApplication.class)
			.sources(DievasWebApplication.class)
			.sources(Dievas.class)
			.bannerMode(Banner.Mode.CONSOLE)
			.run(args);
		
//		new SpringApplicationBuilder()
//		.sources(DievasCommonApplication.class)
//		.sources(DievasDataApplication.class)
//		.sources(DievasServiceApplication.class)
//		.sources(DievasMypageApplication.class)
//		.sources(Dievas.class)
//		.bannerMode(Banner.Mode.CONSOLE)
//		.run(args);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		String[] args = environment.getActiveProfiles();
		log.info(args.toString());
		//servletContext.addServlet("h2Console", new WebServlet()).addMapping("/h2-console/*");
	}
	
}
