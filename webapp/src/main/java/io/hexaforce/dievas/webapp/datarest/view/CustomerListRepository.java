package io.hexaforce.dievas.webapp.datarest.view;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.rds.entity.CustomerList;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */
@RepositoryRestResource(collectionResourceRel = "customer_list", path = "customer_list")
public interface CustomerListRepository extends PagingAndSortingRepository<CustomerList, String> {
}
