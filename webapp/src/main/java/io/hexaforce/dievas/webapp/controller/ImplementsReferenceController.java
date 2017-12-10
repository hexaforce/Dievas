package io.hexaforce.dievas.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.hexaforce.dievas.commons.exception.DievasError;
import io.hexaforce.dievas.commons.exception.DievasException;
import io.hexaforce.dievas.service.ImplementsReferenceService;
import io.hexaforce.dievas.service.model.ImplementsReference;
import lombok.extern.slf4j.Slf4j;

/**
 * ImplementsReference router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka
 */

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ImplementsReferenceController {

	@Autowired
	private ImplementsReferenceService implementsReferenceService;

	@ResponseBody
	@GetMapping(value = "/implements-reference/init")
	public ResponseEntity<ImplementsReference> init() {
		// log.trace(msg);
		// log.error(msg);
		// log.debug(msg);
		// log.warn(msg);
		log.info("Controller(java): init()");
		String x = implementsReferenceService.init();
		return new ResponseEntity<ImplementsReference>(new ImplementsReference(x), HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping(value = "/implements-reference")
	public ResponseEntity<List<ImplementsReference>> getList() {
		if(true)
			throw new DievasException(DievasError.WEBAPP_ERROR);
		return null;
	}

	@ResponseBody
	@GetMapping(value = "/implements-reference/test/{id}")
	public ResponseEntity<ImplementsReference> findById(@PathVariable("id") Integer id) {
		if(id != null)
			throw new DievasException(DievasError.WEBAPP_ERROR);
		return null;
	}

	@ResponseBody
	@PatchMapping(value = "/implements-reference/{id}")
	public ResponseEntity<?> updatea(@PathVariable("id") Integer id,
			@RequestBody ImplementsReference implementsReference) {

		return null;
	}

	@ResponseBody
	@PutMapping(value = "/implements-reference/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id,
			@RequestBody ImplementsReference implementsReference) {

		return null;
	}

	@ResponseBody
	@PostMapping(value = "/implements-reference")
	public ResponseEntity<?> save(@RequestBody ImplementsReference implementsReference,
			UriComponentsBuilder uriComponentsBuilder) {

		return null;
	}

	@ResponseBody
	@ResponseStatus
	@DeleteMapping(value = "/implements-reference/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {

		return null;
	}

}
