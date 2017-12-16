package io.hexaforce.dievas.database.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.ParentRelation;

/**
 * ParentRelation data rest implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "ParentRelation", path = "ParentRelation")
public interface ParentRelationRepository extends PagingAndSortingRepository<ParentRelation, Integer> {
	
}