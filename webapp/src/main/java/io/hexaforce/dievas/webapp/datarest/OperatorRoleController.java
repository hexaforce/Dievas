package io.hexaforce.dievas.webapp.datarest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import io.hexaforce.dievas.database.freude.entity.OperatorRole;
/**
 * OperatorRole router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@RepositoryRestResource(collectionResourceRel = "operator_role", path = "operator_role")
public interface OperatorRoleController extends PagingAndSortingRepository<OperatorRole, Integer> {}
