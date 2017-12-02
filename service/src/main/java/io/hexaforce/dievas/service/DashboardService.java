package io.hexaforce.dievas.service;

import java.util.List;
import java.util.Optional;

import io.hexaforce.dievas.service.model.Dashboard;

/**
 * Dashboard business logic.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

public interface DashboardService {
	
	String init();
	List<Dashboard> findAll();
	Optional<Dashboard> findById(Integer id);
	Dashboard save(Dashboard dashboard);
	boolean exists(Dashboard dashboard);
	void deleteById(Integer id);
}

