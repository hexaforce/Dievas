package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.NoticeRegistrationService;
import lombok.extern.slf4j.Slf4j;

/**
 * NoticeRegistration service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Slf4j
@Transactional
@Service("noticeRegistrationService")
public class NoticeRegistrationServiceImpl implements NoticeRegistrationService {
	
	@Override
	public String init() {
		log.info("NoticeRegistrationServiceImpl.java init()");
		return "noticeRegistrationService";
	}

}
