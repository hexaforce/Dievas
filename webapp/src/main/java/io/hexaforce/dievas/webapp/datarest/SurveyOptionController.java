package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.SurveyOption;

/**
 * SurveyOption router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "survey_option", path = "survey_option")
public interface SurveyOptionController extends PagingAndSortingRepository<SurveyOption, Integer> {
}
