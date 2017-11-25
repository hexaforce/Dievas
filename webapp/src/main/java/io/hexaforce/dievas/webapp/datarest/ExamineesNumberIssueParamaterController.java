package io.hexaforce.dievas.webapp.datarest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import io.hexaforce.dievas.database.freude.entity.ExamineesNumberIssueParamater;
/**
 * ExamineesNumberIssueParamater router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@RepositoryRestResource(collectionResourceRel = "examinees_number_issue_paramater", path = "examinees_number_issue_paramater")
public interface ExamineesNumberIssueParamaterController extends PagingAndSortingRepository<ExamineesNumberIssueParamater, Integer> {}
