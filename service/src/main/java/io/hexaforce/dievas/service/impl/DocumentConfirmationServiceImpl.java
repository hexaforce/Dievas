package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.DocumentConfirmationService;
import lombok.extern.slf4j.Slf4j;

/**
 * DocumentConfirmation service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Slf4j
@Transactional
@Service("documentConfirmationService")
public class DocumentConfirmationServiceImpl implements DocumentConfirmationService {
	
	@Override
	public String init() {
		log.info("DocumentConfirmationServiceImpl.java init()");
		return "documentConfirmationService";
	}

}
