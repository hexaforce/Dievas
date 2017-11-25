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
 * The persistent class for the application_user_defect database table.
 * 
 */
@Entity
@Table(name = "application_user_defect")
@NamedQuery(name = "ApplicationUserDefect.findAll", query = "SELECT a FROM ApplicationUserDefect a")
public class ApplicationUserDefect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "defect_content")
	private String defectContent;

	@Column(name = "defect_id")
	private int defectId;

	@Column(name = "defect_level_type")
	private byte defectLevelType;

	private byte deleted;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "user_id")
	private int userId;

	public ApplicationUserDefect() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public String getDefectContent() {
		return this.defectContent;
	}

	public int getDefectId() {
		return this.defectId;
	}

	public byte getDefectLevelType() {
		return this.defectLevelType;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public int getId() {
		return this.id;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDefectContent(String defectContent) {
		this.defectContent = defectContent;
	}

	public void setDefectId(int defectId) {
		this.defectId = defectId;
	}

	public void setDefectLevelType(byte defectLevelType) {
		this.defectLevelType = defectLevelType;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}