package io.hexaforce.dievas.webapp.rest.view;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.rds.entity.SalesByStore;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */
@RepositoryRestResource(collectionResourceRel = "sales_by_store", path = "sales_by_store")
public interface SalesByStoreRepository extends PagingAndSortingRepository<SalesByStore, String> {
}
