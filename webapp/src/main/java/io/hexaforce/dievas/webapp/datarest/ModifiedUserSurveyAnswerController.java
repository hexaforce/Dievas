package io.hexaforce.dievas.webapp.datarest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import io.hexaforce.dievas.database.freude.entity.ModifiedUserSurveyAnswer;
/**
 * ModifiedUserSurveyAnswer router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@RepositoryRestResource(collectionResourceRel = "modified_user_survey_answer", path = "modified_user_survey_answer")
public interface ModifiedUserSurveyAnswerController extends PagingAndSortingRepository<ModifiedUserSurveyAnswer, Integer> {}
