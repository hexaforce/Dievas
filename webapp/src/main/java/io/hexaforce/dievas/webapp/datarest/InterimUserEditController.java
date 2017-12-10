package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.InterimUserEdit;

/**
 * InterimUserEdit router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "interim_user_edit", path = "interim_user_edit")
public interface InterimUserEditController extends PagingAndSortingRepository<InterimUserEdit, Integer> {
}
