package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.ExamSubject;

/**
 * ExamSubject router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "exam_subject", path = "exam_subject")
public interface ExamSubjectController extends PagingAndSortingRepository<ExamSubject, Integer> {
}
