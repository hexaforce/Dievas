package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the university database table.
 * 
 */
@Entity
@NamedQuery(name = "University.findAll", query = "SELECT u FROM University u")
public class University implements Serializable {
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
	private String establishOrganizationType;

	private String name;

	@Column(name = "prefecture_code")
	private String prefectureCode;

	@Column(name = "university_code")
	private String universityCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public University() {
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

	public String getEstablishOrganizationType() {
		return this.establishOrganizationType;
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

	public String getUniversityCode() {
		return this.universityCode;
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

	public void setEstablishOrganizationType(String establishOrganizationType) {
		this.establishOrganizationType = establishOrganizationType;
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

	public void setUniversityCode(String universityCode) {
		this.universityCode = universityCode;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}