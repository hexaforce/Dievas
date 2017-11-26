package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.DualApplicationsAdvisability;

/**
 * DualApplicationsAdvisability router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@RepositoryRestResource(collectionResourceRel = "dual_applications_advisability", path = "dual_applications_advisability")
public interface DualApplicationsAdvisabilityController
		extends PagingAndSortingRepository<DualApplicationsAdvisability, Integer> {
}
