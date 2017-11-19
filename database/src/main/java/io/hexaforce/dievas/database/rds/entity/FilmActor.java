package io.hexaforce.dievas.database.rds.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

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
public class FilmActor implements Serializable {

	@EmbeddedId
	protected FilmActorPK filmActorPK;

	@Basic(optional = false)
	@NotNull
	@Column(name = "last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;

	@JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Film film;

	@JoinColumn(name = "actor_id", referencedColumnName = "actor_id", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Actor actor;

}