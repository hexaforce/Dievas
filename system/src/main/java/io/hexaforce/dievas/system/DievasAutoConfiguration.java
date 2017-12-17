package io.hexaforce.dievas.system;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
	
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		
		return new RepositoryRestConfigurerAdapter() {
			
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				// exposeIdsFor(config, "io.hexaforce.dievas.database.rds.entity");

				// config.exposeIdsFor(Actor.class);
				// config.exposeIdsFor(ActorInfo.class);
				// config.exposeIdsFor(Address.class);
				// config.exposeIdsFor(Category.class);
				// config.exposeIdsFor(City.class);
				// config.exposeIdsFor(Country.class);
				// config.exposeIdsFor(Customer.class);
				// config.exposeIdsFor(CustomerList.class);
				// config.exposeIdsFor(Film.class);
				// config.exposeIdsFor(FilmActor.class);
				// config.exposeIdsFor(FilmActorPK.class);
				// config.exposeIdsFor(FilmCategory.class);
				// config.exposeIdsFor(FilmCategoryPK.class);
				// config.exposeIdsFor(FilmList.class);
				// config.exposeIdsFor(FilmText.class);
				// config.exposeIdsFor(Inventory.class);
				// config.exposeIdsFor(Language.class);
				// config.exposeIdsFor(NicerButSlowerFilmList.class);
				// config.exposeIdsFor(Payment.class);
				// config.exposeIdsFor(Rental.class);
				// config.exposeIdsFor(SalesByFilmCategory.class);
				// config.exposeIdsFor(SalesByStore.class);
				// config.exposeIdsFor(Staff.class);
				// config.exposeIdsFor(StaffList.class);
				// config.exposeIdsFor(Store.class);
				
				
				//config.setDefaultMediaType(MediaType.APPLICATION_JSON);
			}
			
		};
	}

//	private void exposeIdsFor(RepositoryRestConfiguration config, String packages) {
//		try {
//			ImmutableSet<ClassInfo> classInfoList = ClassPath.from(Thread.currentThread().getContextClassLoader())
//					.getTopLevelClasses(packages);
//			classInfoList.stream().map(classInfo -> config.exposeIdsFor(classInfo.load().getClass()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
