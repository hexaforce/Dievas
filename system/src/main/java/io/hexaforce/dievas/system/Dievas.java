package io.hexaforce.dievas.system;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.h2.server.web.WebServlet;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;
import org.springframework.web.WebApplicationInitializer;

import io.hexaforce.dievas.batch.DievasBatchApplication;
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
		
		String[] profiles = null;
//		FileCopyUtils.copy(in, out);
//		FileSystemUtils.deleteRecursively(root);
		
		for (String bootParameter : args) {
			int index = bootParameter.indexOf("spring.profiles.active");
			if (index != -1) {
				index = bootParameter.lastIndexOf("=");
				profiles = bootParameter.substring(index + 1, bootParameter.length()).split(",");
			}
		}
		
		new SpringApplicationBuilder()
			.sources(DievasDataApplication.class)
			.sources(DievasServiceApplication.class)
			.sources(DievasMypageApplication.class)
			.sources(DievasWebApplication.class)
			.sources(DievasBatchApplication.class)
			.sources(Dievas.class)
			.bannerMode(Banner.Mode.CONSOLE)
			.run(args);
		
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		try {
			File file = File.createTempFile("Dievas-", ".startup");
			file.deleteOnExit();

			Writer writer = new OutputStreamWriter(new FileOutputStream(file));
			writer.write("abcdefghijklmnopqrstuvwxyz\n");
			writer.write("01234567890112345678901234\n");
			writer.write("!@#$%^&*()-=[]{};':',.<>/?\n");
			writer.write("01234567890112345678901234\n");
			writer.write("abcdefghijklmnopqrstuvwxyz\n");
			writer.close();
			
		} catch (IOException e) {
			throw new ServletException(e);
		}


		String[] args = environment.getActiveProfiles();
		log.info(args.toString());
		//servletContext.addServlet("h2Console", new WebServlet()).addMapping("/h2-console/*");
	}
	
}
