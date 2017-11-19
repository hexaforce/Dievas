package io.hexaforce.dievas.database.rds.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
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
@Table(name = "film_list")
public class FilmList implements Serializable {

	@Id
	@Column(name = "FID")
	private Short fid;

	@Size(max = 255)
	@Column(name = "title")
	private String title;

	@Lob
	@Size(max = 65535)
	@Column(name = "description")
	private String description;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 25)
	@Column(name = "category")
	private String category;

	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "length")
	private Short length;

	@Size(max = 5)
	@Column(name = "rating")
	private String rating;

	@Lob
	@Size(max = 65535)
	@Column(name = "actors")
	private String actors;

}