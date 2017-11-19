package io.hexaforce.dievas.system;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.hexaforce.dievas.batch.DievasBatchApplication;
import io.hexaforce.dievas.commons.DievasCommonApplication;
import io.hexaforce.dievas.database.DievasDataApplication;
import io.hexaforce.dievas.database.rds.entity.ActorInfo;
import io.hexaforce.dievas.database.rds.entity.FilmActor;
import io.hexaforce.dievas.service.DievasServiceApplication;
import io.hexaforce.dievas.webapp.DievasWebApplication;

@SpringBootApplication
@EnableAutoConfiguration
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class Dievas implements WebMvcConfigurer {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
			.sources(DievasCommonApplication.class)
			.sources(DievasDataApplication.class)
			.sources(DievasBatchApplication.class)
			.sources(DievasServiceApplication.class)
			.sources(DievasWebApplication.class)
			.sources(Dievas.class)
			.bannerMode(Banner.Mode.CONSOLE)
			.run(args);
	}
	
	@Configuration
	class CustomRestMvcConfiguration {
		@Bean
		public RepositoryRestConfigurer repositoryRestConfigurer() {
			return new RepositoryRestConfigurerAdapter() {
				@Override
				public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
					config.setDefaultMediaType(MediaType.APPLICATION_JSON);
					config.exposeIdsFor(ActorInfo.class,FilmActor.class);
				}
			};
		}
	}
	
	
	
	
	
	
	
	
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
