package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.AcceptanceReportService;
import lombok.extern.slf4j.Slf4j;

/**
 * AcceptanceReport service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Slf4j
@Transactional
@Service("acceptanceReportService")
public class AcceptanceReportServiceImpl implements AcceptanceReportService {
	
	@Override
	public String init() {
		log.info("AcceptanceReportServiceImpl.java init()");
		return "acceptanceReportService";
	}

}
