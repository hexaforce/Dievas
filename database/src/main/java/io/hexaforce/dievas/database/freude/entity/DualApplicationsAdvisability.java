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
 * The persistent class for the dual_applications_advisability database table.
 * 
 */
@Entity
@Table(name = "dual_applications_advisability")
@NamedQuery(name = "DualApplicationsAdvisability.findAll", query = "SELECT d FROM DualApplicationsAdvisability d")
public class DualApplicationsAdvisability implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "bad_exam_id")
	private int badExamId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "exam_id")
	private int examId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public DualApplicationsAdvisability() {
	}

	public int getBadExamId() {
		return this.badExamId;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public int getExamId() {
		return this.examId;
	}

	public int getId() {
		return this.id;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setBadExamId(int badExamId) {
		this.badExamId = badExamId;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}