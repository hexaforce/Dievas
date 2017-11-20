package io.hexaforce.dievas.webapp.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.rds.entity.Film;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */
@RepositoryRestResource(collectionResourceRel = "film", path = "film")
public interface FilmRepository extends PagingAndSortingRepository<Film, Short> {
}
