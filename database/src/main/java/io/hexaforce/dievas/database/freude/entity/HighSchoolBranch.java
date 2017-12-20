package io.hexaforce.dievas.database.freude.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import io.hexaforce.dievas.database.freude.BasicBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "high_school_branch")
@NamedQuery(name = "HighSchoolBranch.findAll", query = "SELECT h FROM HighSchoolBranch h")
public class HighSchoolBranch extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	private byte code;

	@Column(name = "external_code")
	private String externalCode;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

}