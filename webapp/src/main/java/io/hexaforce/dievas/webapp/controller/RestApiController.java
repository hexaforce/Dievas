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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.hexaforce.dievas.commons.CustomErrorType;
import lombok.extern.slf4j.Slf4j;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */

@Slf4j
@RequestMapping("/api")
@RestController
public class RestApiController {
//
//	@Autowired
//	private FilmService filmService;
//	
//	/**
//	 * @return
//	 */
//	@ResponseBody
//	@GetMapping(value = "/film")
//	public ResponseEntity<List<Film>> listAllFilms() {
//		List<Film> films = filmService.findAll();
//		if (films.isEmpty()) {
//			return new ResponseEntity<List<Film>>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<Film>>(films, HttpStatus.OK);
//	}
//
//	/**
//	 * @param id
//	 * @return
//	 */
//	@ResponseBody
//	@GetMapping(value = "/film/{id}")
//	public ResponseEntity<?> getFilm(@PathVariable("id") short id) {
//		log.info("Fetching Film with id {}", id);
//		Optional<Film> film = filmService.findById(id);
//		if (film == null) {
//			log.error("Film with id {} not found.", id);
//			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Film with id " + id + " not found"),
//					HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<Film>(film.get(), HttpStatus.OK);
//	}
//
//	/**
//	 * @param film
//	 * @param ucBuilder
//	 * @return
//	 */
//	@ResponseBody
//	@PostMapping(value = "/film")
//	public ResponseEntity<?> createFilm(@RequestBody Optional<Film> film, UriComponentsBuilder ucBuilder) {
//		log.info("Creating Film : {}", film);
//
//		if (filmService.isExist(film)) {
//			log.error("Unable to create. A Film with name {} already exist", film.get().getTitle());
//			return new ResponseEntity<CustomErrorType>(
//					new CustomErrorType("Unable to create. A Film with name " + film.get().getTitle() + " already exist."),
//					HttpStatus.CONFLICT);
//		}
//		filmService.saveFilm(film);
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(ucBuilder.path("/api/film/{id}").buildAndExpand(film.get().getFilmId()).toUri());
//		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
//	}
//
//	/**
//	 * @param id
//	 * @param film
//	 * @return
//	 */
//	@ResponseBody
//	@PutMapping(value = "/film/{id}")
//	public ResponseEntity<?> updateFilm(@PathVariable("id") short id, @RequestBody Film film) {
//		log.info("Updating Film with id {}", id);
//
//		Optional<Film> currentFilm = filmService.findById(id);
//
//		if (currentFilm == null) {
//			log.error("Unable to update. Film with id {} not found.", id);
//			return new ResponseEntity<CustomErrorType>(
//					new CustomErrorType("Unable to upate. Film with id " + id + " not found."), HttpStatus.NOT_FOUND);
//		}
//
//		currentFilm.get().setTitle(film.getTitle());
////		currentFilm.get().setAge(film.getAge());
////		currentFilm.get().setSalary(film.getSalary());
//
//		filmService.updateFilm(currentFilm);
//		return new ResponseEntity<Film>(currentFilm.get(),HttpStatus.OK);
//	}
//
//	/**
//	 * @param id
//	 * @return
//	 */
//	@ResponseBody
//	@DeleteMapping(value = "/film/{id}")
//	public ResponseEntity<?> deleteFilm(@PathVariable("id") short id) {
//		log.info("Fetching & Deleting Film with id {}", id);
//
//		Optional<Film> film = filmService.findById(id);
//		if (film == null) {
//			log.error("Unable to delete. Film with id {} not found.", id);
//			return new ResponseEntity<CustomErrorType>(
//					new CustomErrorType("Unable to delete. Film with id " + id + " not found."), HttpStatus.NOT_FOUND);
//		}
//		filmService.deleteFilmById(id);
//		return new ResponseEntity<Film>(film.get(),HttpStatus.NO_CONTENT);
//	}
//
//	/**
//	 * @return
//	 */
//	@ResponseBody
//	@DeleteMapping(value = "/film/")
//	public ResponseEntity<Film> deleteAllFilms() {
//		log.info("Deleting All Films");
//		filmService.deleteAllFilms();
//		return new ResponseEntity<Film>(HttpStatus.NO_CONTENT);
//	}

}
