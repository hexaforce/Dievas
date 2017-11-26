package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.ApplicantPreliminaryReportService;
import lombok.extern.slf4j.Slf4j;

/**
 * ApplicantPreliminaryReport service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Slf4j
@Transactional
@Service("applicantPreliminaryReportService")
public class ApplicantPreliminaryReportServiceImpl implements ApplicantPreliminaryReportService {
	
	@Override
	public String init() {
		log.info("ApplicantPreliminaryReportServiceImpl.java init()");
		return "applicantPreliminaryReportService";
	}

}
