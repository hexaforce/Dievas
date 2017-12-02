package io.hexaforce.dievas.webapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.hexaforce.dievas.commons.DievasServerMesseage;
import io.hexaforce.dievas.service.DashboardService;
import io.hexaforce.dievas.service.model.Dashboard;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class ImplementsReferenceController {

	@Autowired
	private DashboardService dashboardService;

	@ResponseBody
	@GetMapping(value = "/dashboard/")
	public ResponseEntity<List<Dashboard>> findAll() {
		
		List<Dashboard> implementsReferenceList = dashboardService.findAll();
		
		if (implementsReferenceList.isEmpty()) {
			log.debug("Data not found.");
			return new ResponseEntity<List<Dashboard>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Dashboard>>(implementsReferenceList, HttpStatus.OK);
		}
		
	}

	@ResponseBody
	@GetMapping(value = "/dashboard/{id}")
	public ResponseEntity<Dashboard> findById(@PathVariable("id") Integer id) {
		
		Optional<Dashboard> implementsReference = dashboardService.findById(id);
		
		if (implementsReference.isPresent()) {
			return new ResponseEntity<Dashboard>(implementsReference.get(), HttpStatus.OK);
		} else {
			log.debug("Data not found.");
			return new ResponseEntity<Dashboard>(HttpStatus.NO_CONTENT);
		}
		
	}
	

	@ResponseBody
	@PostMapping(value = "/dashboard/")
	public ResponseEntity<?> save(@RequestBody Dashboard implementsReference, UriComponentsBuilder uriComponentsBuilder) {
		log.info("Creating new record : {}", implementsReference);

		if (dashboardService.exists(implementsReference)) {
			log.error("Unable to create. A ImplementsReference with name {} already exist", implementsReference);
			return new ResponseEntity<DievasServerMesseage>(
					new DievasServerMesseage("Unable to create. A User with name " + implementsReference.getXxx() + " already exist."),
					HttpStatus.CONFLICT);
		}
		
		Dashboard createdImplementsReference = dashboardService.save(implementsReference);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(uriComponentsBuilder.path("/api/dashboard/{id}").buildAndExpand(createdImplementsReference.getXxx()).toUri());
		return new ResponseEntity<String>(httpHeaders, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@PutMapping(value = "/dashboard/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Dashboard implementsReference) {
		log.info("Updating User with id {}", id);
		Optional<Dashboard> currentImplementsReference = dashboardService.findById(id);
		if (currentImplementsReference.isPresent()) {
			dashboardService.save(implementsReference);
			return new ResponseEntity<Dashboard>(implementsReference,HttpStatus.OK);
		} else {
			log.error("Unable to update. User with id {} not found.", id);
			return new ResponseEntity<DievasServerMesseage>(
					new DievasServerMesseage("Unable to upate. User with id " + id + " not found."), HttpStatus.NOT_FOUND);
		}
		
	}
	

	@ResponseBody
	@ResponseStatus
	@DeleteMapping(value = "/dashboard/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
		log.info("Fetching & Deleting User with id {}", id);
		Optional<Dashboard> currentImplementsReference = dashboardService.findById(id);
		if (currentImplementsReference.isPresent()) {
			dashboardService.deleteById(id);
			return new ResponseEntity<Dashboard>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<DievasServerMesseage>(
					new DievasServerMesseage("Unable to delete. User with id " + id + " not found."), HttpStatus.NOT_FOUND);
		}
	}

}
