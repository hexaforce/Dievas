package io.hexaforce.dievas.system;

import java.io.IOException;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ClassUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

import io.hexaforce.dievas.system.errorhandling.ExceptionHandlers;
import io.hexaforce.dievas.system.servlet.DievasInterceptor;
import io.undertow.Handlers;
import io.undertow.Undertow.Builder;
import io.undertow.server.HttpHandler;
import io.undertow.server.RoutingHandler;

/**
 * @author T.Tantaka
 *
 */
@Configuration
@EnableConfigurationProperties(DievasProperties.class)
public class DievasAutoConfiguration implements WebMvcConfigurer {
//extends WebMvcConfigurationSupport {
	
    @Bean
    public DievasInterceptor interceptor() {
    	
//    	DefaultMessageCodesResolver resolver = new DefaultMessageCodesResolver();
//    	resolver.setPrefix(prefix);
    	
        return new DievasInterceptor();
    }
    
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor());
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}
	
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		
		return new RepositoryRestConfigurerAdapter() {
			
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				//exposeIdsFor(config, "io.hexaforce.dievas.database.freude.entity");
				//config.setDefaultMediaType(MediaType.APPLICATION_JSON);
			}
			
		};
	}

	private void exposeIdsFor(RepositoryRestConfiguration config, String packages) {
		try {
			ImmutableSet<ClassInfo> classInfoList = ClassPath.from(Thread.currentThread().getContextClassLoader())
					.getTopLevelClasses(packages);
			ClassUtils
					.convertClassNamesToClasses(
							classInfoList.stream().map(classInfo -> classInfo.getName()).collect(Collectors.toList()))
					.forEach(domainTypes -> config.exposeIdsFor(domainTypes));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static final HttpHandler ROUTES = new RoutingHandler()
			.get("/throwWebException", ExceptionHandlers::throwWebException)
			.get("/throwApiException", ExceptionHandlers::throwApiException)
			.get("/throwException", ExceptionHandlers::throwException)
			.get("/ok", ExceptionHandlers::ok);
	
	private static final HttpHandler ROOT = Handlers.exceptionHandler(ROUTES)
			.addExceptionHandler(ApiException.class, ExceptionHandlers::handleApiException)
			.addExceptionHandler(WebException.class, ExceptionHandlers::handleWebException)
			.addExceptionHandler(Throwable.class, ExceptionHandlers::handleAllExceptions);
	
	@Bean
	public UndertowServletWebServerFactory embeddedServletContainerFactory() {
		
		UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
		
		factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {

			@Override
			public void customize(Builder builder) {
				//builder.addHttpListener(8443, "0.0.0.0");

				//builder.setHandler(ROOT);
			}

		});
		return factory;
	}
	
    public static class WebException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		private final int statusCode;
        public WebException(int statusCode, String message) {
            super(message);
            this.statusCode = statusCode;
        }

        public int getStatusCode() {
            return statusCode;
        }
    }

    public static class ApiException extends WebException {
		private static final long serialVersionUID = 1L;
		public ApiException(int statusCode, String message) {
            super(statusCode, message);
        }
    }
	
	
	
	
	
	
	
	
}
