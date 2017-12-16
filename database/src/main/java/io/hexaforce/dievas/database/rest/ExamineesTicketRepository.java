package io.hexaforce.dievas.database.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.ExamineesTicket;

/**
 * ExamineesTicket data rest implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "ExamineesTicket", path = "ExamineesTicket")
public interface ExamineesTicketRepository extends PagingAndSortingRepository<ExamineesTicket, Integer> {
	
}