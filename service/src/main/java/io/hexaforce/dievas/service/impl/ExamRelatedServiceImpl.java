package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.ExamRelatedService;
import lombok.extern.slf4j.Slf4j;

/**
 * ExamRelated service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Slf4j
@Transactional
@Service("examRelatedService")
public class ExamRelatedServiceImpl implements ExamRelatedService {
	
	@Override
	public String init() {
		log.info("ExamRelatedServiceImpl.java init()");
		return "examRelatedService";
	}

}
