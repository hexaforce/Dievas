package io.hexaforce.dievas.system.undertow;

import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import io.undertow.Undertow.Builder;

public class UndertowCustomize {
	
	@Bean
	public UndertowServletWebServerFactory embeddedServletContainerFactory() {
		
		UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
		
		factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {

			@Override
			public void customize(Builder builder) {
				builder.addHttpListener(8443, "0.0.0.0");

			}

		});
		return factory;
	}
	
}
