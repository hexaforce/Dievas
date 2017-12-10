package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.ExamScheduleGanttChartService;
import lombok.extern.slf4j.Slf4j;

/**
 * ExamScheduleGanttChart service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka 
 */

@Slf4j
@Transactional
@Service("examScheduleGanttChartService")
public class ExamScheduleGanttChartServiceImpl implements ExamScheduleGanttChartService {
	
	@Override
	public String init() {
		log.info("Service(java): init()");
		return "examScheduleGanttChartService";
	}

}
