package io.hexaforce.dievas.system;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.StaticResourceRequest;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.hexaforce.dievas.batch.DievasBatchApplication;
import io.hexaforce.dievas.commons.DievasCommonApplication;
import io.hexaforce.dievas.database.DievasDataApplication;
import io.hexaforce.dievas.database.rds.entity.Actor;
import io.hexaforce.dievas.database.rds.entity.ActorInfo;
import io.hexaforce.dievas.database.rds.entity.Address;
import io.hexaforce.dievas.database.rds.entity.Category;
import io.hexaforce.dievas.database.rds.entity.City;
import io.hexaforce.dievas.database.rds.entity.Country;
import io.hexaforce.dievas.database.rds.entity.Customer;
import io.hexaforce.dievas.database.rds.entity.CustomerList;
import io.hexaforce.dievas.database.rds.entity.Film;
import io.hexaforce.dievas.database.rds.entity.FilmActor;
import io.hexaforce.dievas.database.rds.entity.FilmActorPK;
import io.hexaforce.dievas.database.rds.entity.FilmCategory;
import io.hexaforce.dievas.database.rds.entity.FilmCategoryPK;
import io.hexaforce.dievas.database.rds.entity.FilmList;
import io.hexaforce.dievas.database.rds.entity.FilmText;
import io.hexaforce.dievas.database.rds.entity.Inventory;
import io.hexaforce.dievas.database.rds.entity.Language;
import io.hexaforce.dievas.database.rds.entity.NicerButSlowerFilmList;
import io.hexaforce.dievas.database.rds.entity.Payment;
import io.hexaforce.dievas.database.rds.entity.Rental;
import io.hexaforce.dievas.database.rds.entity.SalesByFilmCategory;
import io.hexaforce.dievas.database.rds.entity.SalesByStore;
import io.hexaforce.dievas.database.rds.entity.Staff;
import io.hexaforce.dievas.database.rds.entity.StaffList;
import io.hexaforce.dievas.database.rds.entity.Store;
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
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// ログインページを登録
		registry.addViewController("/login").setViewName("login");
	}
	
	@Configuration
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {
		
		@Autowired
		private DataSource dataSource;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.requestMatchers(StaticResourceRequest.toCommonLocations()).permitAll().anyRequest().fullyAuthenticated()
			.and()
			.formLogin().loginPage("/login").successForwardUrl("/").failureUrl("/login?error").permitAll()
			.and()
			.logout().logoutUrl("/login?logout").permitAll();
		}
		
		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.jdbcAuthentication().dataSource(this.dataSource);
		}
		
	}
	
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
	
	
	@Configuration
	class CustomRestMvcConfiguration {
		@Bean
		public RepositoryRestConfigurer repositoryRestConfigurer() {
			return new RepositoryRestConfigurerAdapter() {
				@Override
				public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
					// exposeIdsFor(config, "io.hexaforce.dievas.database.rds.entity");
					// IDアノテーションでも出力されるようにします。厳格なRESTfulでは推奨されていないものです。
					config.exposeIdsFor(Actor.class);
					config.exposeIdsFor(ActorInfo.class);
					config.exposeIdsFor(Address.class);
					config.exposeIdsFor(Category.class);
					config.exposeIdsFor(City.class);
					config.exposeIdsFor(Country.class);
					config.exposeIdsFor(Customer.class);
					config.exposeIdsFor(CustomerList.class);
					config.exposeIdsFor(Film.class);
					config.exposeIdsFor(FilmActor.class);
					config.exposeIdsFor(FilmActorPK.class);
					config.exposeIdsFor(FilmCategory.class);
					config.exposeIdsFor(FilmCategoryPK.class);
					config.exposeIdsFor(FilmList.class);
					config.exposeIdsFor(FilmText.class);
					config.exposeIdsFor(Inventory.class);
					config.exposeIdsFor(Language.class);
					config.exposeIdsFor(NicerButSlowerFilmList.class);
					config.exposeIdsFor(Payment.class);
					config.exposeIdsFor(Rental.class);
					config.exposeIdsFor(SalesByFilmCategory.class);
					config.exposeIdsFor(SalesByStore.class);
					config.exposeIdsFor(Staff.class);
					config.exposeIdsFor(StaffList.class);
					config.exposeIdsFor(Store.class);
					config.setDefaultMediaType(MediaType.APPLICATION_JSON);
				}
			};
		}
	}
	
//	private void exposeIdsFor(RepositoryRestConfiguration config, String packages) {
//		try {
//			ImmutableSet<ClassInfo> classInfoList = ClassPath.from(Thread.currentThread().getContextClassLoader()).getTopLevelClasses(packages);
//			classInfoList.stream().map(classInfo -> config.exposeIdsFor(classInfo.load().getClass()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
}
