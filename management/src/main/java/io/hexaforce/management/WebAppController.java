package io.hexaforce.management;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * @author T.Tantaka 
 *
 */

@Slf4j
@Controller
public class WebAppController {

	@RequestMapping("/")
	public String index(ModelMap modal) {
		log.info("Come in　Dievas index.html");
		return "redirect:/Dievas";
	}

	@RequestMapping("/Dievas")
	public String Dievas(Principal principal, ModelMap modal) {
		log.info("Welcome Dievas >> " + principal.getName());
		return "index";
	}

	@RequestMapping("/content/{page}")
	public String contentHandler(@PathVariable("page") final String page) {
		log.info("contentHandler:" + page + ".html");
		return "content/" + page;
	}

	@RequestMapping("/error/{page}")
	String errorHandler(@PathVariable("page") final String page) {
		log.info("errorHandler:" + page + ".html");
		return "error/" + page;
	}

}
