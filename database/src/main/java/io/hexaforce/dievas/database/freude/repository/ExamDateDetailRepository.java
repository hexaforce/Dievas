package io.hexaforce.dievas.database.freude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.hexaforce.dievas.database.freude.entity.ExamDateDetail;

/**
 * ExamDateDetail data accessor.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@Repository
public interface ExamDateDetailRepository extends JpaRepository<ExamDateDetail, Integer> {
}
