package io.hexaforce.dievas.database.freude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.hexaforce.dievas.database.freude.entity.ExamType;

/**
 * ExamType data accessor.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@Repository
public interface ExamTypeRepository extends JpaRepository<ExamType, Integer> {
}
