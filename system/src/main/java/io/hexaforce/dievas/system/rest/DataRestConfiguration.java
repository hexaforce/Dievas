package io.hexaforce.dievas.system.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.http.MediaType;

@Configuration
public class DataRestConfiguration {
	
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		
		return new RepositoryRestConfigurerAdapter() {
			
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				// exposeIdsFor(config, "io.hexaforce.dievas.database.rds.entity");
				// IDアノテーションでも出力されるようにします。厳格なRESTfulでは推奨されていないものです。
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
}
