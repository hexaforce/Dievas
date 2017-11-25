package io.hexaforce.dievas.webapp.datarest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import io.hexaforce.dievas.database.freude.entity.DesignatedHighSchool;
/**
 * DesignatedHighSchool router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@RepositoryRestResource(collectionResourceRel = "designated_high_school", path = "designated_high_school")
public interface DesignatedHighSchoolController extends PagingAndSortingRepository<DesignatedHighSchool, Integer> {}
