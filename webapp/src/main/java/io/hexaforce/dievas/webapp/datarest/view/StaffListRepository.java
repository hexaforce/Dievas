package io.hexaforce.dievas.webapp.datarest.view;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.rds.entity.StaffList;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */
@RepositoryRestResource(collectionResourceRel = "staff_list", path = "staff_list")
public interface StaffListRepository extends PagingAndSortingRepository<StaffList, String> {
}
