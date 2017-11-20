package io.hexaforce.dievas.webapp.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.rds.entity.FilmCategory;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */
@RepositoryRestResource(collectionResourceRel = "film_category", path = "film_category")
public interface FilmCategoryRepository extends PagingAndSortingRepository<FilmCategory, Short> {
}
