package io.hexaforce.dievas.database.rds.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.hexaforce.dievas.database.rds.entity.Film;

/**
 * @author T.Tantaka <relics9@gmail.com>
 *
 */
@Repository
public interface FilmRepository extends JpaRepository<Film, Short> {
	
	/**
	 * @param title
	 * @return
	 */
	Film findByTitle(String title);
	
}
