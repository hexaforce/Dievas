package io.hexaforce.dievas.webapp.datarest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import io.hexaforce.dievas.database.freude.entity.UserProfileReflectionRequest;
/**
 * UserProfileReflectionRequest router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@RepositoryRestResource(collectionResourceRel = "user_profile_reflection_request", path = "user_profile_reflection_request")
public interface UserProfileReflectionRequestController extends PagingAndSortingRepository<UserProfileReflectionRequest, Integer> {}
