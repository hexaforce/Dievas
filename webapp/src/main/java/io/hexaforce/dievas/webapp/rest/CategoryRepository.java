package io.hexaforce.dievas.webapp.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.rds.entity.Category;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */

@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface CategoryRepository extends PagingAndSortingRepository<Category, Short> {
}
