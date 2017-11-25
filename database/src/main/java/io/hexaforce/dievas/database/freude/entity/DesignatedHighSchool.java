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
 * The persistent class for the designated_high_school database table.
 * 
 */
@Entity
@Table(name = "designated_high_school")
@NamedQuery(name = "DesignatedHighSchool.findAll", query = "SELECT d FROM DesignatedHighSchool d")
public class DesignatedHighSchool implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "department_id")
	private int departmentId;

	@Column(name = "division_external_code")
	private String divisionExternalCode;

	@Column(name = "exam_id")
	private int examId;

	@Column(name = "high_school_code")
	private String highSchoolCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public DesignatedHighSchool() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public String getDivisionExternalCode() {
		return this.divisionExternalCode;
	}

	public int getExamId() {
		return this.examId;
	}

	public String getHighSchoolCode() {
		return this.highSchoolCode;
	}

	public int getId() {
		return this.id;
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

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public void setDivisionExternalCode(String divisionExternalCode) {
		this.divisionExternalCode = divisionExternalCode;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public void setHighSchoolCode(String highSchoolCode) {
		this.highSchoolCode = highSchoolCode;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}