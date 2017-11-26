package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.BatchJobExecutionHistoryService;
import lombok.extern.slf4j.Slf4j;

/**
 * BatchJobExecutionHistory service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Slf4j
@Transactional
@Service("batchJobExecutionHistoryService")
public class BatchJobExecutionHistoryServiceImpl implements BatchJobExecutionHistoryService {
	
	@Override
	public String init() {
		log.info("BatchJobExecutionHistoryServiceImpl.java init()");
		return "batchJobExecutionHistoryService";
	}

}
