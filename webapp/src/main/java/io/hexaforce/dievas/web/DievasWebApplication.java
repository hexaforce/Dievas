package io.hexaforce.dievas.web;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

//import org.springframework.boot.actuate.autoconfigure.security.EndpointRequest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class DievasWebApplication implements WebMvcConfigurer {

//	@Controller
//	protected static class HomeController {
//
//		@GetMapping("/")
//		@Secured("ROLE_ADMIN")
//		public String home(Map<String, Object> model) {
//			model.put("message", "Hello World");
//			model.put("title", "Hello Home");
//			model.put("date", new Date());
//			return "home";
//		}
//
//	}
//
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/login").setViewName("login");
//		registry.addViewController("/access").setViewName("access");
//	}
//
//	@Order(Ordered.HIGHEST_PRECEDENCE)
//	@Configuration
//	protected static class AuthenticationSecurity {
//
//		@Bean
//		public InMemoryUserDetailsManager inMemoryUserDetailsManager() throws Exception {
//			String password = UUID.randomUUID().toString();
//			return new InMemoryUserDetailsManager(
//					User.withUsername("admin").password("admin").roles("ADMIN", "USER", "ACTUATOR").build(),
//					User.withUsername("user").password("user").roles("USER").build());
//		}
//
//	}
//
//	@Configuration
//	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.authorizeRequests().antMatchers("/login").permitAll().anyRequest().fullyAuthenticated()
//			.and()
//				.formLogin().loginPage("/login").failureUrl("/login?error")
//			.and()
//				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.and()
//				.exceptionHandling().accessDeniedPage("/access?error");
//		}
//	}
//
//	@Configuration
//	@Order(1)
//	protected static class ActuatorSecurity extends WebSecurityConfigurerAdapter {
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests().anyRequest().authenticated().and()
//					.httpBasic();
//		}
//	}

}
