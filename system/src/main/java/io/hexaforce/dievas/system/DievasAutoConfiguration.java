package io.hexaforce.dievas.system;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.hexaforce.dievas.system.servlet.DievasInterceptor;

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
	
}
