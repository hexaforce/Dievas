package io.hexaforce.dievas.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */

@Slf4j
@Controller
public class WebAppController {

	@RequestMapping("/")
	public String index(ModelMap modal) {
		log.info("redirect to >> /Dievas");
		return "redirect:/Dievas";
	}

	@RequestMapping("/Dievas")
	public String Dievas(ModelMap modal) {
		log.info("Dievas");
		return "index";
	}

	@RequestMapping("/partials/{page}")
	public String partialHandler(@PathVariable("page") final String page) {
		log.info("partialHandler");
		return "partials/" + page;
	}
	
	@RequestMapping("/error/{page}")
	String errorHandler(@PathVariable("page") final String page) {
		log.info("errorHandler");
		return "error/"+page;
	}
}