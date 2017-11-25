package io.hexaforce.dievas.webapp.datarest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import io.hexaforce.dievas.database.freude.entity.CsvExportHistory;
/**
 * CsvExportHistory router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@RepositoryRestResource(collectionResourceRel = "csv_export_history", path = "csv_export_history")
public interface CsvExportHistoryController extends PagingAndSortingRepository<CsvExportHistory, Integer> {}
