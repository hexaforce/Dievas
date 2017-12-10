package io.hexaforce.dievas.webapp.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.dievas.database.freude.entity.PaymentCanceled;

/**
 * PaymentCanceled router function.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@RepositoryRestResource(collectionResourceRel = "payment_canceled", path = "payment_canceled")
public interface PaymentCanceledController extends PagingAndSortingRepository<PaymentCanceled, Integer> {
}
