package io.hexaforce.dievas.webapp.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.rds.entity.Language;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */
@RepositoryRestResource(collectionResourceRel = "language", path = "language")
public interface LanguageRepository extends PagingAndSortingRepository<Language, Short> {
}
