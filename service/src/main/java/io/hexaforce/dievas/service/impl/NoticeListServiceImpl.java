package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.NoticeListService;
import lombok.extern.slf4j.Slf4j;

/**
 * NoticeList service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Slf4j
@Transactional
@Service("noticeListService")
public class NoticeListServiceImpl implements NoticeListService {
	
	@Override
	public String init() {
		log.info("Service(java): init()");
		return "noticeListService";
	}

}
