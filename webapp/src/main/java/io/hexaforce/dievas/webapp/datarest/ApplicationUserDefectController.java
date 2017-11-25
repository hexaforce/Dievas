package io.hexaforce.dievas.webapp.datarest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import io.hexaforce.dievas.database.freude.entity.ApplicationUserDefect;
/**
 * ApplicationUserDefect router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@RepositoryRestResource(collectionResourceRel = "application_user_defect", path = "application_user_defect")
public interface ApplicationUserDefectController extends PagingAndSortingRepository<ApplicationUserDefect, Integer> {}
