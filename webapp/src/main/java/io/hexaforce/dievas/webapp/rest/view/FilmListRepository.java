package io.hexaforce.dievas.webapp.rest.view;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.rds.entity.FilmList;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */
@RepositoryRestResource(collectionResourceRel = "film_list", path = "film_list")
public interface FilmListRepository extends PagingAndSortingRepository<FilmList, String> {
}
