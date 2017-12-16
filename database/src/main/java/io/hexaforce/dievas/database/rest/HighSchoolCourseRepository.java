package io.hexaforce.dievas.database.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.HighSchoolCourse;

/**
 * HighSchoolCourse data rest implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "HighSchoolCourse", path = "HighSchoolCourse")
public interface HighSchoolCourseRepository extends PagingAndSortingRepository<HighSchoolCourse, Integer> {
	
}