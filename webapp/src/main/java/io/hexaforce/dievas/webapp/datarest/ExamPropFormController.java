package io.hexaforce.dievas.webapp.datarest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import io.hexaforce.dievas.database.freude.entity.ExamPropForm;
/**
 * ExamPropForm router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@RepositoryRestResource(collectionResourceRel = "exam_prop_form", path = "exam_prop_form")
public interface ExamPropFormController extends PagingAndSortingRepository<ExamPropForm, Integer> {}
