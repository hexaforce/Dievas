package io.hexaforce.dievas.database.rds.entity;

import java.io.Serializable;

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
@Table(name = "film_text")
public class FilmText implements Serializable {

	@Id
	@Basic(optional = false)
	@NotNull
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

}