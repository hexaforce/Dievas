package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.MailDeliveryRegistrationService;
import lombok.extern.slf4j.Slf4j;

/**
 * MailDeliveryRegistration service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Slf4j
@Transactional
@Service("mailDeliveryRegistrationService")
public class MailDeliveryRegistrationServiceImpl implements MailDeliveryRegistrationService {
	
	@Override
	public String init() {
		log.info("MailDeliveryRegistrationServiceImpl.java init()");
		return "mailDeliveryRegistrationService";
	}

}
