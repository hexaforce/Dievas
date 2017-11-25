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

/**
 * The persistent class for the high_school database table.
 * 
 */
@Entity
@Table(name = "high_school")
@NamedQuery(name = "HighSchool.findAll", query = "SELECT h FROM HighSchool h")
public class HighSchool implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "educational_institute_type")
	private byte educationalInstituteType;

	@Column(name = "establish_organization_type")
	private byte establishOrganizationType;

	@Column(name = "high_school_code")
	private String highSchoolCode;

	private String name;

	@Column(name = "prefecture_code")
	private String prefectureCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public HighSchool() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public byte getEducationalInstituteType() {
		return this.educationalInstituteType;
	}

	public byte getEstablishOrganizationType() {
		return this.establishOrganizationType;
	}

	public String getHighSchoolCode() {
		return this.highSchoolCode;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getPrefectureCode() {
		return this.prefectureCode;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setEducationalInstituteType(byte educationalInstituteType) {
		this.educationalInstituteType = educationalInstituteType;
	}

	public void setEstablishOrganizationType(byte establishOrganizationType) {
		this.establishOrganizationType = establishOrganizationType;
	}

	public void setHighSchoolCode(String highSchoolCode) {
		this.highSchoolCode = highSchoolCode;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrefectureCode(String prefectureCode) {
		this.prefectureCode = prefectureCode;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}