package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.ApplicationNpsForm;

/**
 * ApplicationNpsForm router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "application_nps_form", path = "application_nps_form")
public interface ApplicationNpsFormController extends PagingAndSortingRepository<ApplicationNpsForm, Integer> {
}
