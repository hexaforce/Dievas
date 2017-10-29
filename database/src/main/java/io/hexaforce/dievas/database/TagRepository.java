package io.hexaforce.dievas.database;

import java.util.List;

import io.hexaforce.dievas.database.domain.Tag;

public interface TagRepository {

	List<Tag> findAll();

}
