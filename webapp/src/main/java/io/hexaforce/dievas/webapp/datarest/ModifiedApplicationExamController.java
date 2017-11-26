package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.ModifiedApplicationExam;

/**
 * ModifiedApplicationExam router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@RepositoryRestResource(collectionResourceRel = "modified_application_exam", path = "modified_application_exam")
public interface ModifiedApplicationExamController
		extends PagingAndSortingRepository<ModifiedApplicationExam, Integer> {
}
