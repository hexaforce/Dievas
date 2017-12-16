package io.hexaforce.dievas.database.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.CsvExportHistory;

/**
 * CsvExportHistory data rest implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "CsvExportHistory", path = "CsvExportHistory")
public interface CsvExportHistoryRepository extends PagingAndSortingRepository<CsvExportHistory, Integer> {
	
}