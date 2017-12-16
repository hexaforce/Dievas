package io.hexaforce.dievas.database.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.ModifiedReasen;

/**
 * ModifiedReasen data rest implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "ModifiedReasen", path = "ModifiedReasen")
public interface ModifiedReasenRepository extends PagingAndSortingRepository<ModifiedReasen, Integer> {
	
}