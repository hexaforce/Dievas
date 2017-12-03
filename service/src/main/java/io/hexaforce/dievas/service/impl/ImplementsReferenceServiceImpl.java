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
import io.hexaforce.dievas.database.freude.repository.AdminUserRepository;
import io.hexaforce.dievas.database.freude.repository.UserProfileRepository;
import io.hexaforce.dievas.service.ImplementsReferenceService;
import lombok.extern.slf4j.Slf4j;

/**
 * ImplementsReference service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Slf4j
@Transactional
@Service("implementsReferenceService")
public class ImplementsReferenceServiceImpl implements ImplementsReferenceService {

	@Autowired
	private AdminUserRepository adminUserRepository;
	
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
		
		String lastname = "", firstname = "";
		
		// Enables the distinct flag for the query
		List<UserProfile> userProfileList = userProfileRepository
				.findDistinctCramSchoolCodeByLastNameOrFirstName(lastname, firstname);

		userProfileList = userProfileRepository.findCramSchoolCodeDistinctByLastNameOrFirstName(lastname, firstname);

		// Enabling ignoring case for an individual property
		userProfileList = userProfileRepository.findByLastNameIgnoreCase(lastname);

		// Enabling ignoring case for all suitable properties
		userProfileList = userProfileRepository.findByLastNameAndFirstNameAllIgnoreCase(lastname, firstname);

		// Enabling static ORDER BY for a query
		userProfileList = userProfileRepository.findByLastNameOrderByFirstNameAsc(lastname);

		userProfileList = userProfileRepository.findByLastNameOrderByFirstNameDesc(lastname);
		
		
	}
}
