package io.hexaforce.dievas.webapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import io.hexaforce.dievas.database.domain.City;
import io.hexaforce.dievas.database.domain.Hotel;
import io.hexaforce.dievas.database.domain.Review;
import io.hexaforce.dievas.service.DashboardService;
import io.hexaforce.dievas.service.model.Dashboard;
import io.hexaforce.dievas.service.sample.CityService;
import io.hexaforce.dievas.service.sample.HotelService;
import lombok.extern.slf4j.Slf4j;

/**
 * Dashboard router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Slf4j
@RestController
@RequestMapping("/api")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private HotelService hotelService;
	
	@ResponseBody
	@GetMapping(value = "/dashboard")
	public ResponseEntity<List<Review>> findAll() {
		
		City city =  cityService.getCity("Bath", "UK");
		
		Hotel hotel = hotelService.getHotel(city, "The Bath Priory Hotel");
		
		Sort orderByasc = new Sort(Sort.Direction.ASC, "id");
		Sort orderBydesc = new Sort(Sort.Direction.DESC, "city_id");
		Pageable pageable = PageRequest.of(1, 5, orderByasc.and(orderBydesc));
		
		Page<Review> reviews = hotelService.getReviews(hotel, pageable);
		return new ResponseEntity<List<Review>>(reviews.getContent(),HttpStatus.NO_CONTENT);
//		Dashboard dashboard = dashboardService.findAll();

//		if (dashboard.getAdminUsers().isEmpty()) {
//			log.debug("Data not found.");
//			return new ResponseEntity<Dashboard>(HttpStatus.NO_CONTENT);
//		} else {
//			return new ResponseEntity<Dashboard>(dashboard, HttpStatus.OK);
//		}

	}

	@ResponseBody
	@GetMapping(value = "/dashboard/{id}")
	public ResponseEntity<Dashboard> findById(@PathVariable("id") Integer id) {

		Optional<Dashboard> dashboard = dashboardService.findById(id);

		if (dashboard.isPresent()) {
			return new ResponseEntity<Dashboard>(dashboard.get(), HttpStatus.OK);
		} else {
			log.debug("Data not found.");
			return new ResponseEntity<Dashboard>(HttpStatus.NO_CONTENT);
		}

	}

	@ResponseBody
	@PostMapping(value = "/dashboard")
	public ResponseEntity<?> save(@RequestBody Dashboard dashboard, UriComponentsBuilder uriComponentsBuilder) {
		log.info("Creating new record : {}", dashboard);

		if (dashboardService.exists(dashboard)) {
			log.error("Unable to create. A dashboard with name {} already exist", dashboard);
			return new ResponseEntity<DievasServerMesseage>(
					new DievasServerMesseage(
							"Unable to create. A User with name " + dashboard.getMessage() + " already exist."),
					HttpStatus.CONFLICT);
		}

		Dashboard createddashboard = dashboardService.save(dashboard);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(
				uriComponentsBuilder.path("/api/dashboard/{id}").buildAndExpand(createddashboard.getMessage()).toUri());
		return new ResponseEntity<String>(httpHeaders, HttpStatus.CREATED);
	}

	@ResponseBody
	@PutMapping(value = "/dashboard/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Dashboard dashboard) {
		log.info("Updating User with id {}", id);
		Optional<Dashboard> currentdashboard = dashboardService.findById(id);
		if (currentdashboard.isPresent()) {
			dashboardService.save(dashboard);
			return new ResponseEntity<Dashboard>(dashboard, HttpStatus.OK);
		} else {
			log.error("Unable to update. User with id {} not found.", id);
			return new ResponseEntity<DievasServerMesseage>(
					new DievasServerMesseage("Unable to upate. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

	}

	@ResponseBody
	@ResponseStatus
	@DeleteMapping(value = "/dashboard/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
		log.info("Fetching & Deleting User with id {}", id);
		Optional<Dashboard> currentdashboard = dashboardService.findById(id);
		if (currentdashboard.isPresent()) {
			dashboardService.deleteById(id);
			return new ResponseEntity<Dashboard>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<DievasServerMesseage>(
					new DievasServerMesseage("Unable to delete. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
	}

}
