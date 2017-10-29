package io.hexaforce.dievas.database.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.hexaforce.dievas.database.NoteRepository;
import io.hexaforce.dievas.database.domain.Note;

@Repository
class JpaNoteRepository implements NoteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Note> findAll() {
		return this.entityManager.createQuery("SELECT n FROM Note n", Note.class)
				.getResultList();
	}

}