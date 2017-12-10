package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.MailApiLog;

/**
 * MailApiLog router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "mail_api_log", path = "mail_api_log")
public interface MailApiLogController extends PagingAndSortingRepository<MailApiLog, Integer> {
}
