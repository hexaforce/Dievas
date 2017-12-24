package io.hexaforce.dievas.system.errorhandling;

import io.hexaforce.dievas.system.DievasAutoConfiguration.ApiException;
import io.hexaforce.dievas.system.DievasAutoConfiguration.WebException;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.ExceptionHandler;

public class ExceptionHandlers {

	public static void handleWebException(HttpServerExchange exchange) {
		WebException ex = (WebException) exchange.getAttachment(ExceptionHandler.THROWABLE);
		exchange.setStatusCode(ex.getStatusCode());
	}

	public static void handleApiException(HttpServerExchange exchange) {
		ApiException ex = (ApiException) exchange.getAttachment(ExceptionHandler.THROWABLE);
		exchange.setStatusCode(ex.getStatusCode());
	}

	public static void handleAllExceptions(HttpServerExchange exchange) {
		exchange.setStatusCode(500);
	}

	public static void throwWebException(HttpServerExchange exchange) {
		throw new WebException(500, "Web Server Error");
	}

	public static void throwApiException(HttpServerExchange exchange) {
		throw new ApiException(503, "API Server Error");
	}

	public static void throwException(HttpServerExchange exchange) {
		throw new RuntimeException();
	}

	public static void ok(HttpServerExchange exchange) {
		
	}
}
