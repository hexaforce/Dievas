package io.hexaforce.dievas.database.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.FreudeChangelog;

/**
 * FreudeChangelog data rest implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "FreudeChangelog", path = "FreudeChangelog")
public interface FreudeChangelogRepository extends PagingAndSortingRepository<FreudeChangelog, Integer> {
	
}