package io.hexaforce.dievas.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.hexaforce.dievas.service.ExamRelatedService;

/**
 * Dashboard router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@RestController
@RequestMapping("/api")
public class ExamRelatedController {
	@Autowired
	private ExamRelatedService examRelated;

	@ResponseBody
	@GetMapping(value = "/exam_related/")
	public ResponseEntity<String> serviceName() {
		return new ResponseEntity<String>(examRelated.serviceName(), HttpStatus.OK);
	}
}
