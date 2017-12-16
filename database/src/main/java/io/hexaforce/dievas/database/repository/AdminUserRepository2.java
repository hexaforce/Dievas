package io.hexaforce.dievas.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.hexaforce.dievas.database.freude.entity.AdminUser;

/**
 * AdminUser data accessor.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@Repository
public interface AdminUserRepository2 extends JpaRepository<AdminUser, Integer> {
	
}