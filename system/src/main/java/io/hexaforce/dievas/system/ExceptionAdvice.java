package io.hexaforce.dievas.system;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.hexaforce.dievas.commons.exception.DievasException;

/**
 * @author T.Tantaka
 *
 */
@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = { DievasException.class })
	public ResponseEntity<Object> handleHttpStatusException(DievasException exception, WebRequest request){
		return handleExceptionInternal(exception, exception, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
				request);
	}
	
}
