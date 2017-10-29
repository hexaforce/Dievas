package io.hexaforce.dievas.database.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.database.domain.Pet;
import io.hexaforce.dievas.database.domain.PetType;

public interface PetRepository extends Repository<Pet, Integer> {

	/**
	 * @return
	 */
	@Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
	@Transactional(readOnly = true)
	List<PetType> findPetTypes();

	/**
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	Pet findById(Integer id);

	/**
	 * @param pet
	 */
	void save(Pet pet);
}
