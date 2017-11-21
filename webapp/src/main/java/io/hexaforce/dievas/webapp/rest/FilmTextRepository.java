package io.hexaforce.dievas.webapp.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.rds.entity.FilmCategoryPK;
import io.hexaforce.dievas.database.rds.entity.FilmText;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */
@RepositoryRestResource(collectionResourceRel = "film_text", path = "film_text")
public interface FilmTextRepository extends PagingAndSortingRepository<FilmText, FilmCategoryPK> {
}
