package io.hexaforce.dievas.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.database.freude.entity.AdminUser;
import io.hexaforce.dievas.database.freude.entity.UserProfile;
import io.hexaforce.dievas.database.repository.AdminUserRepository2;
import io.hexaforce.dievas.database.rest.UserProfileRepository;
import io.hexaforce.dievas.service.ImplementsReferenceService;
import lombok.extern.slf4j.Slf4j;

/**
 * ImplementsReference service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@Slf4j
@Transactional
@Service("implementsReferenceService")
public class ImplementsReferenceServiceImpl implements ImplementsReferenceService {

	@Autowired
	private AdminUserRepository2 adminUserRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public String init() {
		log.info("Service(java): init()");
		return "implementsReferenceService";
	}
	
    /***************************************
     *  Spring data JAP 標準実装機能
     *  https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
     ***************************************/
	@Override
	public void MyBatisToJPAwithHibernate1() {

		// 検索条件用Id
		Integer id = Integer.valueOf(1);
		Collection<Integer> ids = Arrays.asList(id, Integer.valueOf(2), Integer.valueOf(3));

		// Example で私用する検索条件用のentity
		AdminUser targetUser = new AdminUser();
		targetUser.setName("Tantaka");// 検索条件 ： 名前
		targetUser.setDeleted(false);// 検索条件 ： 論理削除フラグ
		Example<AdminUser> example = Example.of(targetUser);

		Collection<AdminUser> adminUsers = Arrays.asList(targetUser, new AdminUser(), new AdminUser());

		// 検索条件用 Sort Pageable
		Sort orderByasc = new Sort(Sort.Direction.ASC, "id");
		Sort orderBydesc = new Sort(Sort.Direction.DESC, "name");
		Pageable pageable = PageRequest.of(1, 10, orderByasc.and(orderBydesc));

		// entity を保存
		AdminUser adminUser1 = adminUserRepository.save(targetUser);

		// 複数の entity を保存
		List<AdminUser> adminUserList0 = adminUserRepository.saveAll(adminUsers);

		// flush
		adminUserRepository.flush();

		// 保存して flush
		adminUserRepository.saveAndFlush(targetUser);

		// ID で存在確認
		boolean exists1 = adminUserRepository.existsById(id);

		// Example で存在確認
		boolean exists2 = adminUserRepository.exists(example);

		// 全権カウント
		long count1 = adminUserRepository.count();

		// Example でカウント
		long count2 = adminUserRepository.count(example);

		// ID で取得
		AdminUser adminUser2 = adminUserRepository.getOne(id);

		// ID で取得
		Optional<AdminUser> optAdminUser1 = adminUserRepository.findById(id);

		// Example で取得
		Optional<AdminUser> optAdminUser2 = adminUserRepository.findOne(example);

		// 全件取得
		List<AdminUser> adminUserList1 = adminUserRepository.findAll();

		// Example で複数取得
		List<AdminUser> adminUserList2 = adminUserRepository.findAll(example);

		// Sort で複数取得
		List<AdminUser> adminUserList3 = adminUserRepository.findAll(orderByasc);

		// Example Sort で複数取得
		List<AdminUser> adminUserList4 = adminUserRepository.findAll(example, orderByasc);

		// 複数のIDで取得
		List<AdminUser> adminUserList5 = adminUserRepository.findAllById(ids);

		// Pageable で複数取得
		Page<AdminUser> pageAdminUser1 = adminUserRepository.findAll(pageable);

		// Example Pageable で複数取得
		Page<AdminUser> pageAdminUser2 = adminUserRepository.findAll(example, pageable);

		// ID で削除
		adminUserRepository.deleteById(id);

		// entity で削除
		adminUserRepository.delete(targetUser);

		// 複数の対象を削除
		adminUserRepository.deleteAll(adminUsers);

		// 全件削除
		adminUserRepository.deleteAll();

	}

    /***************************************
     *  Spring data JAP 拡張機能
     ***************************************/
	@Override
	public void MyBatisToJPAwithHibernate2() {
		
		// クエリをかかなくてもメソッド名でクエリが自動作成されます。
		
		String lastName = "金田", firstName = "夕菜";
		
		// Enables the distinct flag for the query
		List<UserProfile> userProfileList = userProfileRepository
				.findDistinctCramSchoolCodeByLastNameOrFirstName(lastName, firstName);

		userProfileList = userProfileRepository.findCramSchoolCodeDistinctByLastNameOrFirstName(lastName, firstName);

		// Enabling ignoring case for an individual property
		userProfileList = userProfileRepository.findByLastNameIgnoreCase(lastName);

		// Enabling ignoring case for all suitable properties
		userProfileList = userProfileRepository.findByLastNameAndFirstNameAllIgnoreCase(lastName, firstName);

		// Enabling static ORDER BY for a query
		userProfileList = userProfileRepository.findByLastNameOrderByFirstNameAsc(lastName);

		userProfileList = userProfileRepository.findByLastNameOrderByFirstNameDesc(lastName);
		

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
}
