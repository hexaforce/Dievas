package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.ApplicationGradePoint;

/**
 * ApplicationGradePoint router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@RepositoryRestResource(collectionResourceRel = "application_grade_point", path = "application_grade_point")
public interface ApplicationGradePointController extends PagingAndSortingRepository<ApplicationGradePoint, Integer> {
}
