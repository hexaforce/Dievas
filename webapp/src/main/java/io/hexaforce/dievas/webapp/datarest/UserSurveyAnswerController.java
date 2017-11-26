package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.UserSurveyAnswer;

/**
 * UserSurveyAnswer router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@RepositoryRestResource(collectionResourceRel = "user_survey_answer", path = "user_survey_answer")
public interface UserSurveyAnswerController extends PagingAndSortingRepository<UserSurveyAnswer, Integer> {
}
