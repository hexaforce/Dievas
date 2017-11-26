package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.AcceptanceImportPassRejectionService;
import lombok.extern.slf4j.Slf4j;

/**
 * AcceptanceImportPassRejection service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Slf4j
@Transactional
@Service("acceptanceImportPassRejectionService")
public class AcceptanceImportPassRejectionServiceImpl implements AcceptanceImportPassRejectionService {
	
	@Override
	public String init() {
		log.info("AcceptanceImportPassRejectionServiceImpl.java init()");
		return "acceptanceImportPassRejectionService";
	}

}
