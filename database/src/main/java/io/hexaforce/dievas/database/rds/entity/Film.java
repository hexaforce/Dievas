package io.hexaforce.dievas.database.rds.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Table(name = "film")
public class Film implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "film_id")
	private Short filmId;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "title")
	private String title;

	@Lob
	@Size(max = 65535)
	@Column(name = "description")
	private String description;

	@Column(name = "release_year")
	@Temporal(TemporalType.DATE)
	private Date releaseYear;

	@Basic(optional = false)
	@NotNull
	@Column(name = "rental_duration")
	private short rentalDuration;

	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@NotNull
	@Column(name = "rental_rate")
	private BigDecimal rentalRate;

	@Column(name = "length")
	private Short length;

	@Basic(optional = false)
	@NotNull
	@Column(name = "replacement_cost")
	private BigDecimal replacementCost;

	@Size(max = 5)
	@Column(name = "rating")
	private String rating;

	@Size(max = 54)
	@Column(name = "special_features")
	private String specialFeatures;
	@Basic(optional = false)
	@NotNull
	@Column(name = "last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;

	@JoinColumn(name = "original_language_id", referencedColumnName = "language_id")
	@ManyToOne
	private Language originalLanguageId;

	@JoinColumn(name = "language_id", referencedColumnName = "language_id")
	@ManyToOne(optional = false)
	private Language languageId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
	private Collection<FilmActor> filmActorCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "filmId")
	private Collection<Inventory> inventoryCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
	private Collection<FilmCategory> filmCategoryCollection;

}