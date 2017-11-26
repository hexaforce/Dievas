package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.ApplicationUserSurveyAnswer;

/**
 * ApplicationUserSurveyAnswer router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@RepositoryRestResource(collectionResourceRel = "application_user_survey_answer", path = "application_user_survey_answer")
public interface ApplicationUserSurveyAnswerController
		extends PagingAndSortingRepository<ApplicationUserSurveyAnswer, Integer> {
}
