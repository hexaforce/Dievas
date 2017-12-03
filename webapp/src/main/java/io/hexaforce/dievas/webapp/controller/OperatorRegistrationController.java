package io.hexaforce.dievas.webapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.hexaforce.dievas.commons.DievasServerMesseage;
import io.hexaforce.dievas.service.OperatorRegistrationService;
import lombok.extern.slf4j.Slf4j;

/**
 * OperatorRegistration router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Slf4j
@RestController
@RequestMapping("/api")
public class OperatorRegistrationController {
	
	@Autowired
	private OperatorRegistrationService operatorRegistrationService;
	
	@ResponseBody
	@GetMapping(value = "/operator-registration")
	public ResponseEntity<List<DievasServerMesseage>> init() {
		log.info("Controller(java): init()");
		String x = operatorRegistrationService.init();
		return new ResponseEntity<List<DievasServerMesseage>>(Arrays.asList(new DievasServerMesseage(x)),HttpStatus.OK);
	}
	
}
