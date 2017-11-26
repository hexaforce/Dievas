package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.OperatorRegistrationService;

/**
 * OperatorRegistration service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Transactional
@Service("operatorRegistrationService")
public class OperatorRegistrationServiceImpl implements OperatorRegistrationService {
	@Override
	public String serviceName() {
		return "operatorRegistration";
	}
}
