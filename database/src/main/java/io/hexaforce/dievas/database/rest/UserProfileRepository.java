package io.hexaforce.dievas.database.rest;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
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
public interface UserProfileRepository
		extends PagingAndSortingRepository<UserProfile, Integer>, JpaSpecificationExecutor<UserProfile> {
	
	// Enables the distinct flag for the query
	List<UserProfile> findDistinctCramSchoolCodeByLastNameOrFirstName(@Param("lastname") String lastname, @Param("firstname") String firstname);
	
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
	
	//Table 4. Supported keywords inside method names
	//Keyword	Sample	JPQL snippet
	//And
	//
	//findByLastnameAndFirstname
	//
	//… where x.lastname = ?1 and x.firstname = ?2
	//
	//Or
	//
	//findByLastnameOrFirstname
	//
	//… where x.lastname = ?1 or x.firstname = ?2
	//
	//Is,Equals
	//
	//findByFirstname,findByFirstnameIs,findByFirstnameEquals
	//
	//… where x.firstname = ?1
	//
	//Between
	//
	//findByStartDateBetween
	//
	//… where x.startDate between ?1 and ?2
	//
	//LessThan
	//
	//findByAgeLessThan
	//
	//… where x.age < ?1
	//
	//LessThanEqual
	//
	//findByAgeLessThanEqual
	//
	//… where x.age <= ?1
	//
	//GreaterThan
	//
	//findByAgeGreaterThan
	//
	//… where x.age > ?1
	//
	//GreaterThanEqual
	//
	//findByAgeGreaterThanEqual
	//
	//… where x.age >= ?1
	//
	//After
	//
	//findByStartDateAfter
	//
	//… where x.startDate > ?1
	//
	//Before
	//
	//findByStartDateBefore
	//
	//… where x.startDate < ?1
	//
	//IsNull
	//
	//findByAgeIsNull
	//
	//… where x.age is null
	//
	//IsNotNull,NotNull
	//
	//findByAge(Is)NotNull
	//
	//… where x.age not null
	//
	//Like
	//
	//findByFirstnameLike
	//
	//… where x.firstname like ?1
	//
	//NotLike
	//
	//findByFirstnameNotLike
	//
	//… where x.firstname not like ?1
	//
	//StartingWith
	//
	//findByFirstnameStartingWith
	//
	//… where x.firstname like ?1 (parameter bound with appended %)
	//
	//EndingWith
	//
	//findByFirstnameEndingWith
	//
	//… where x.firstname like ?1 (parameter bound with prepended %)
	//
	//Containing
	//
	//findByFirstnameContaining
	//
	//… where x.firstname like ?1 (parameter bound wrapped in %)
	//
	//OrderBy
	//
	//findByAgeOrderByLastnameDesc
	//
	//… where x.age = ?1 order by x.lastname desc
	//
	//Not
	//
	//findByLastnameNot
	//
	//… where x.lastname <> ?1
	//
	//In
	//
	//findByAgeIn(Collection<Age> ages)
	//
	//… where x.age in ?1
	//
	//NotIn
	//
	//findByAgeNotIn(Collection<Age> ages)
	//
	//… where x.age not in ?1
	//
	//True
	//
	//findByActiveTrue()
	//
	//… where x.active = true
	//
	//False
	//
	//findByActiveFalse()
	//
	//… where x.active = false
	//
	//IgnoreCase
	//
	//findByFirstnameIgnoreCase
	//
	//… where UPPER(x.firstame) = UPPER(?1)
	
}