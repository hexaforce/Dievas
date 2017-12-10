package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.MailMagazine;

/**
 * MailMagazine router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "mail_magazine", path = "mail_magazine")
public interface MailMagazineController extends PagingAndSortingRepository<MailMagazine, Integer> {
}
