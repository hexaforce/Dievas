package io.hexaforce.dievas.database.freude.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.hexaforce.dievas.database.freude.entity.ValidationRule;
/**
 * ValidationRule data accessor.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Repository
public interface ValidationRuleRepository extends JpaRepository<ValidationRule, Integer> {}