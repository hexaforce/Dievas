package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.AcceptanceImportPassRejectionService;

/**
 * AcceptanceImportPassRejection service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Transactional
@Service("acceptanceImportPassRejectionService")
public class AcceptanceImportPassRejectionServiceImpl implements AcceptanceImportPassRejectionService {
	@Override
	public String serviceName() {
		return "acceptanceImportPassRejection";
	}
}
