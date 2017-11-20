package io.hexaforce.dievas.webapp.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.rds.entity.Rental;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */
@RepositoryRestResource(collectionResourceRel = "rental", path = "rental")
public interface RentalRepository extends PagingAndSortingRepository<Rental, Integer> {
}
