package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.NpsApiLog;

/**
 * NpsApiLog router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "nps_api_log", path = "nps_api_log")
public interface NpsApiLogController extends PagingAndSortingRepository<NpsApiLog, Integer> {
}
