package io.hexaforce.dievas.database.rds.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.hexaforce.dievas.database.rds.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "film_actor")
public class FilmActor extends AbstractEntity {

	@EmbeddedId
	protected FilmActorPK filmActorPK;

	@JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Film film;

	@JoinColumn(name = "actor_id", referencedColumnName = "actor_id", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Actor actor;

}