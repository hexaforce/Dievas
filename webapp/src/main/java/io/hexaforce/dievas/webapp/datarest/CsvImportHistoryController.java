package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.CsvImportHistory;

/**
 * CsvImportHistory router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "csv_import_history", path = "csv_import_history")
public interface CsvImportHistoryController extends PagingAndSortingRepository<CsvImportHistory, Integer> {
}
