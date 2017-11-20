package io.hexaforce.dievas.webapp.rest.view;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.rds.entity.NicerButSlowerFilmList;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */
@RepositoryRestResource(collectionResourceRel = "nicer_but_slower_film_list", path = "nicer_but_slower_film_list")
public interface NicerButSlowerFilmListRepository extends PagingAndSortingRepository<NicerButSlowerFilmList, String> {
}
