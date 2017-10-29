package io.hexaforce.dievas.database.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import io.hexaforce.dievas.database.domain.Visit;

/**
 * @author tanta
 *
 */
public interface VisitRepository extends Repository<Visit, Integer> {
	
	/**
	 * @param visit
	 * @throws DataAccessException
	 */
	void save(Visit visit) throws DataAccessException;

	/**
	 * @param petId
	 * @return
	 */
	List<Visit> findByPetId(Integer petId);
	
}
