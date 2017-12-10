package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.HighSchoolBranch;

/**
 * HighSchoolBranch router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "high_school_branch", path = "high_school_branch")
public interface HighSchoolBranchController extends PagingAndSortingRepository<HighSchoolBranch, Integer> {
}
