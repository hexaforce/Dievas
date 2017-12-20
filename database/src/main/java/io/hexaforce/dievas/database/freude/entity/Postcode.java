package io.hexaforce.dievas.database.freude.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import io.hexaforce.dievas.database.freude.BasicBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Postcode.findAll", query = "SELECT p FROM Postcode p")
public class Postcode extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String municipality;

	@Column(name = "municipality_kana")
	private String municipalityKana;

	private String postcode;

	@Column(name = "prefecture_code")
	private String prefectureCode;

	@Column(name = "town_area")
	private String townArea;

	@Column(name = "town_area_kana")
	private String townAreaKana;

}