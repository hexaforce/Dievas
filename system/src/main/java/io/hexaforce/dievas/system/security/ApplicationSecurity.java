package io.hexaforce.dievas.system.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.StaticResourceRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// https://docs.spring.io/spring-security/site/docs/current/reference/html/csrf.html#csrf-include-csrf-token-ajax
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		
		http.authorizeRequests().requestMatchers(StaticResourceRequest.toCommonLocations()).permitAll().anyRequest()
				.fullyAuthenticated().and().formLogin().loginPage("/login").successForwardUrl("/")
				.failureUrl("/login?error").permitAll().and().logout().logoutUrl("/login?logout").permitAll();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(this.dataSource);
	}
	
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
