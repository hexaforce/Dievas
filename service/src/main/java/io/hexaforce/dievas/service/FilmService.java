package io.hexaforce.dievas.service;

import java.util.List;
import java.util.Optional;

import io.hexaforce.dievas.database.rds.entity.Film;

/**
 * @author T.Tantaka <relics9@gmail.com>
 *
 */
public interface FilmService {
	
	/**
	 * @param id
	 * @return
	 */
	Optional<Film> findById(Short id);

	/**
	 * @param name
	 * @return
	 */
	Film findByTitle(String title);

	/**
	 * @return
	 */
	List<Film> findAll();

	/**
	 * @param Film
	 * @return
	 */
	boolean isExist(Optional<Film> Film);

	/**
	 * @param Film
	 */
	void saveFilm(Optional<Film> Film);

	/**
	 * @param Film
	 */
	void updateFilm(Optional<Film> Film);

	/**
	 * @param id
	 */
	void deleteFilmById(Short id);

	/**
	 * 
	 */
	void deleteAllFilms();
	
}
