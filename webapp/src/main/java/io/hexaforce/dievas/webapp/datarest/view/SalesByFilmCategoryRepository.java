package io.hexaforce.dievas.webapp.datarest.view;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.rds.entity.SalesByFilmCategory;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */
@RepositoryRestResource(collectionResourceRel = "sales_by_film_category", path = "sales_by_film_category")
public interface SalesByFilmCategoryRepository extends PagingAndSortingRepository<SalesByFilmCategory, String> {
}
