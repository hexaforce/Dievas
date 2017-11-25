package io.hexaforce.dievas.database.freude.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.hexaforce.dievas.database.freude.entity.ApplicationUserSurveyAnswer;
/**
 * ApplicationUserSurveyAnswer data accessor.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Repository
public interface ApplicationUserSurveyAnswerRepository extends JpaRepository<ApplicationUserSurveyAnswer, Integer> {}
