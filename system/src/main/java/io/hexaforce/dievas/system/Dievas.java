package io.hexaforce.dievas.system;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.hexaforce.dievas.batch.DievasBatchApplication;
import io.hexaforce.dievas.commons.DievasCommonApplication;
import io.hexaforce.dievas.database.DievasDataApplication;
import io.hexaforce.dievas.service.DievasServiceApplication;
import io.hexaforce.dievas.webapp.DievasWebApplication;

@SpringBootApplication
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(securedEnabled = true)
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
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/login").setViewName("login");
//		registry.addViewController("/access").setViewName("access");
//	}

//    @Bean
//    public DataSource hikariDataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .generateUniqueName(true)
//                .setType(EmbeddedDatabaseType.H2)
//                .setScriptEncoding("UTF-8")
//                .addScript("message.sql")
//                .addScript("validation.sql")
//                .build();
//    }

//	
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
	
//	private void exposeIdsFor(RepositoryRestConfiguration config, String packages) {
//		try {
//			ImmutableSet<ClassInfo> classInfoList = ClassPath.from(Thread.currentThread().getContextClassLoader()).getTopLevelClasses(packages);
//			classInfoList.stream().map(classInfo -> config.exposeIdsFor(classInfo.load().getClass()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
}
