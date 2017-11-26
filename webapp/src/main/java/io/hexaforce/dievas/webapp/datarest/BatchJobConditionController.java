package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.BatchJobCondition;

/**
 * BatchJobCondition router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@RepositoryRestResource(collectionResourceRel = "batch_job_condition", path = "batch_job_condition")
public interface BatchJobConditionController extends PagingAndSortingRepository<BatchJobCondition, Integer> {
}
