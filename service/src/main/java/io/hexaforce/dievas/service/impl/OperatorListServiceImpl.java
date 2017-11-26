package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.OperatorListService;

/**
 * OperatorList service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Transactional
@Service("operatorListService")
public class OperatorListServiceImpl implements OperatorListService {
	@Override
	public String serviceName() {
		return "operatorList";
	}
}
