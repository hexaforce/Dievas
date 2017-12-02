package io.hexaforce.dievas.system.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DievasHealth implements HealthIndicator {

	@Override
	public Health health() {
		return null;
	}

}
