package io.hexaforce.dievas.webapp.rest.view;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.rds.entity.ActorInfo;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */

@RepositoryRestResource(collectionResourceRel = "actor_info", path = "actor_info")
public interface ActorInfoRepository extends PagingAndSortingRepository<ActorInfo, Short> {
}
