package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.hexaforce.dievas.database.freude.BasicBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "high_school")
@NamedQuery(name = "HighSchool.findAll", query = "SELECT h FROM HighSchool h")
public class HighSchool extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "educational_institute_type")
	private byte educationalInstituteType;

	@Column(name = "establish_organization_type")
	private byte establishOrganizationType;

	@Column(name = "high_school_code")
	private String highSchoolCode;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(name = "prefecture_code")
	private String prefectureCode;

}