package io.hexaforce.dievas.system;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @author T.Tantaka
 *
 */
@Data
@ConfigurationProperties(prefix = "spring.dievas", ignoreUnknownFields = true)
public class DievasProperties {

	private String sample;

}
