package io.hexaforce.dievas.database.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.database.domain.Owner;

/**
 * @author tanta
 *
 */

public interface OwnerRepository extends CrudRepository<Owner, Integer> {
	
	/**
	 * @param lastName
	 * @return
	 */
	@Query("SELECT DISTINCT owner FROM Owner owner left join fetch owner.pets WHERE owner.lastName LIKE :lastName%")
	@Transactional(readOnly = true)
	Collection<Owner> findByLastName(@Param("lastName") String lastName);

	/**
	 * @param id
	 * @return
	 */
	@Query("SELECT owner FROM Owner owner left join fetch owner.pets WHERE owner.id =:id")
	@Transactional(readOnly = true)
	Optional<Owner> findById(@Param("id") Integer id);

	/**
	 * @param owner
	 */
	Owner save(Owner owner);
	
}
