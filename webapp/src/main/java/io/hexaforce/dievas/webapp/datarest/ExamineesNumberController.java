package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.ExamineesNumber;

/**
 * ExamineesNumber router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "examinees_number", path = "examinees_number")
public interface ExamineesNumberController extends PagingAndSortingRepository<ExamineesNumber, Integer> {
}
