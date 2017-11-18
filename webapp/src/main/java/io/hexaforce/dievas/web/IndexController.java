package io.hexaforce.dievas.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.hexaforce.dievas.businesslogic.PetService;

@Controller
public class IndexController {

	@Autowired
	private PetService petService;
	
//	@RequestMapping("/")
//	public String welcome() {
//		return "index";
//	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

//	@RequestMapping("/login")
//	public String login() {
//		return "login";
//	}

	@RequestMapping("/forms")
	public String forms() {
		return "forms";
	}

	@RequestMapping("/tables")
	public String tables() {
		return "tables";
	}

	@RequestMapping("/morris")
	public String morris() {
		return "morris";
	}

	@RequestMapping("/flot")
	public String flot() {
		return "flot";
	}	
	
	@RequestMapping("/pet")
	public String pet() {
		petService.serach(Long.valueOf(1));
		return "index";
	}
	
}
