package io.hexaforce.dievas.system;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

//import org.h2.server.web.WebServlet;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.WebApplicationInitializer;

import io.hexaforce.dievas.batch.DievasBatchApplication;
import io.hexaforce.dievas.commons.DievasCommonApplication;
import io.hexaforce.dievas.database.DievasDataApplication;
import io.hexaforce.dievas.mypage.DievasMypageApplication;
import io.hexaforce.dievas.service.DievasServiceApplication;
import io.hexaforce.dievas.webapp.DievasWebApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Dievas implements WebApplicationInitializer {

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
		
//		new SpringApplicationBuilder()
//		.sources(DievasCommonApplication.class)
//		.sources(DievasDataApplication.class)
//		.sources(DievasBatchApplication.class)
//		.sources(DievasServiceApplication.class)
//		.sources(DievasMypageApplication.class)
//		.sources(Dievas.class)
//		.bannerMode(Banner.Mode.CONSOLE)
//		.run(args);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//servletContext.addServlet("h2Console", new WebServlet()).addMapping("/h2-console/*");
	}
	
}
