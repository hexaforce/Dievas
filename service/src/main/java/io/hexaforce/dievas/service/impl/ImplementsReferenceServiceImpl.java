package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.ImplementsReferenceService;
import lombok.extern.slf4j.Slf4j;

/**
 * ImplementsReference service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Slf4j
@Transactional
@Service("implementsReferenceService")
public class ImplementsReferenceServiceImpl implements ImplementsReferenceService {
	
	@Override
	public String init() {
		log.info("Service(java): init()");
		return "implementsReferenceService";
	}

}
