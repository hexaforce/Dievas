package io.hexaforce.dievas.database.rest;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

import io.hexaforce.dievas.database.freude.entity.UserProfile;

/**
 * UserProfile data rest implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "UserProfile", path = "UserProfile")
public interface UserProfileRepository extends PagingAndSortingRepository<UserProfile, Integer> {
	
	// Enables the distinct flag for the query
	List<UserProfile> findDistinctCramSchoolCodeByLastNameOrFirstName(String lastname, String firstname);
	
	List<UserProfile> findCramSchoolCodeDistinctByLastNameOrFirstName(String lastname, String firstname);

	// Enabling ignoring case for an individual property
	List<UserProfile> findByLastNameIgnoreCase(String lastname);

	// Enabling ignoring case for all suitable properties
	List<UserProfile> findByLastNameAndFirstNameAllIgnoreCase(String lastname, String firstname);

	// Enabling static ORDER BY for a query
	List<UserProfile> findByLastNameOrderByFirstNameAsc(String lastname);

	List<UserProfile> findByLastNameOrderByFirstNameDesc(String lastname);
	
	UserProfile findFirstByOrderByLastNameAsc();

	UserProfile findTopByOrderByUserIdDesc();

	Page<UserProfile> queryFirst10ByLastName(String lastname, Pageable pageable);

	Slice<UserProfile> findTop3ByLastName(String lastname, Pageable pageable);
	
	Stream<UserProfile> readAllByFirstNameNotNull();
	
	@Async
	Future<UserProfile> findByFirstName(String firstname);               

	@Async
	CompletableFuture<UserProfile> findOneByFirstName(String firstname); 

	@Async
	ListenableFuture<UserProfile> findOneByLastName(String lastname);
	
}