package io.hexaforce.dievas.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.hexaforce.dievas.database.rds.entity.Film;
import io.hexaforce.dievas.database.rds.repository.FilmRepository;

@Transactional
@Service("filmService")
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepository;
	
	@Override
	public Optional<Film> findById(Short id) {
		return filmRepository.findById(id);
	}

	@Override
	public Film findByTitle(String title) {
		return filmRepository.findByTitle(title);
	}

	@Override
	public List<Film> findAll() {
		return filmRepository.findAll();
	}

	@Override
	public boolean isExist(Optional<Film> film) {
		return findByTitle(film.get().getTitle()) != null;
	}

	@Override
	public void saveFilm(Optional<Film> film) {
		filmRepository.save(film.get());
	}

	@Override
	public void updateFilm(Optional<Film> film) {
		saveFilm(film);
	}

	@Override
	public void deleteFilmById(Short id) {
		filmRepository.deleteById(id);
		
	}

	@Override
	public void deleteAllFilms() {
		filmRepository.deleteAll();
	}

}
