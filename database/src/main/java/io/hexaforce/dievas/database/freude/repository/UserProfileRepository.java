package io.hexaforce.dievas.database.freude.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.util.concurrent.ListenableFuture;

import io.hexaforce.dievas.database.freude.entity.UserProfile;

/**
 * UserProfile data accessor.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

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
