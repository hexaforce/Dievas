package io.hexaforce.dievas.database.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.ModifiedUserSurveyAnswer;

/**
 * ModifiedUserSurveyAnswer data rest implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "ModifiedUserSurveyAnswer", path = "ModifiedUserSurveyAnswer")
public interface ModifiedUserSurveyAnswerRepository extends PagingAndSortingRepository<ModifiedUserSurveyAnswer, Integer> {
	
}