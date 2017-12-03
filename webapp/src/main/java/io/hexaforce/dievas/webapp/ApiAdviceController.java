package io.hexaforce.dievas.webapp;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiAdviceController extends ResponseEntityExceptionHandler {
//    public ResponseEntity handleHttpStatusException(HttpStatusException exception, WebRequest request) throws JsonProcessingException {
//        return handleExceptionInternal(exception, exception.toResponseJson(), new HttpHeaders(), exception.getHttpStatus(), request);
//    }
}
