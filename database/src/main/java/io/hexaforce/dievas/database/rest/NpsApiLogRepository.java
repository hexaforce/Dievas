package io.hexaforce.dievas.database.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.NpsApiLog;

/**
 * NpsApiLog data rest implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "NpsApiLog", path = "NpsApiLog")
public interface NpsApiLogRepository extends PagingAndSortingRepository<NpsApiLog, Integer> {
	
}