package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.PracticalExamineesNumber;

/**
 * PracticalExamineesNumber router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "practical_examinees_number", path = "practical_examinees_number")
public interface PracticalExamineesNumberController
		extends PagingAndSortingRepository<PracticalExamineesNumber, Integer> {
}
