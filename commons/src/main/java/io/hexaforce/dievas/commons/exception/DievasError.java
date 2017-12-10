package io.hexaforce.dievas.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DievasError {
	COMMONS_ERROR(1000,""),
	
	DATABASE_ERROR(2000,""),
	
	BATCH_ERROR(3000,""),
	
	SERVICE_ERROR(4000,""),
	
	WEBAPP_ERROR(5000,"あああああああああああああああああ");
	
	private int code;
	private String message;
}
