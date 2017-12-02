package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.DashboardService;
import io.hexaforce.dievas.service.logic.LocalLogicCsv;
import lombok.extern.slf4j.Slf4j;
import static io.hexaforce.dievas.commons.utiles.DievasUtiles.*;

 
/**
 * Dashboard service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Slf4j
@Transactional
@Service("dashboardService")
public class DashboardServiceImpl extends LocalLogicCsv implements DashboardService {

	@Override
	public String init() {
		example();
		log.info("DashboardServiceImpl.java init()");
		return "dashboardService";
	}

}
