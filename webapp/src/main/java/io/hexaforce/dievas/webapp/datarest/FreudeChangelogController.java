package io.hexaforce.dievas.webapp.datarest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import io.hexaforce.dievas.database.freude.entity.FreudeChangelog;
/**
 * FreudeChangelog router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@RepositoryRestResource(collectionResourceRel = "freude_changelog", path = "freude_changelog")
public interface FreudeChangelogController extends PagingAndSortingRepository<FreudeChangelog, Integer> {}
