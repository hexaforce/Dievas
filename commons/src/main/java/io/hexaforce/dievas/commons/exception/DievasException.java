package io.hexaforce.dievas.commons.exception;

import lombok.Data;

@Data
public class DievasException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private int errorCode;
	private String errorMessage;

	public DievasException(DievasError error) {
		super("DievasException");
		this.errorCode = error.getCode();
		this.errorMessage = error.getMessage();
	}
}
