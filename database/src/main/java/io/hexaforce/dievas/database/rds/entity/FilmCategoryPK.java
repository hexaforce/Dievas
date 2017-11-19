package io.hexaforce.dievas.database.rds.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */
@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategoryPK implements Serializable {

	@Basic(optional = false)
	@NotNull
	@Column(name = "film_id")
	private short filmId;

	@Basic(optional = false)
	@NotNull
	@Column(name = "category_id")
	private short categoryId;

}