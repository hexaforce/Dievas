package io.hexaforce.dievas.database;

import java.util.List;

import io.hexaforce.dievas.database.domain.Note;

public interface NoteRepository {

	List<Note> findAll();

}
