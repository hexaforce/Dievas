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
 * The persistent class for the high_school_branch database table.
 * 
 */
@Entity
@Table(name = "high_school_branch")
@NamedQuery(name = "HighSchoolBranch.findAll", query = "SELECT h FROM HighSchoolBranch h")
public class HighSchoolBranch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private byte code;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "external_code")
	private String externalCode;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public HighSchoolBranch() {
	}

	public byte getCode() {
		return this.code;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public String getExternalCode() {
		return this.externalCode;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setCode(byte code) {
		this.code = code;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setExternalCode(String externalCode) {
		this.externalCode = externalCode;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}