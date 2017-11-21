package io.hexaforce.dievas.webapp.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.rds.entity.FilmActor;
import io.hexaforce.dievas.database.rds.entity.FilmActorPK;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */
@RepositoryRestResource(collectionResourceRel = "film_actor", path = "film_actor")
public interface FilmActorRepository extends PagingAndSortingRepository<FilmActor, FilmActorPK> {
}
