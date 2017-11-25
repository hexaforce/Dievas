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
 * The persistent class for the exam_date_detail database table.
 * 
 */
@Entity
@Table(name = "exam_date_detail")
@NamedQuery(name = "ExamDateDetail.findAll", query = "SELECT e FROM ExamDateDetail e")
public class ExamDateDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Temporal(TemporalType.DATE)
	@Column(name = "exam_date")
	private Date examDate;

	@Column(name = "exam_date_id")
	private int examDateId;

	@Column(name = "external_code")
	private String externalCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public ExamDateDetail() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public Date getExamDate() {
		return this.examDate;
	}

	public int getExamDateId() {
		return this.examDateId;
	}

	public String getExternalCode() {
		return this.externalCode;
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

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public void setExamDateId(int examDateId) {
		this.examDateId = examDateId;
	}

	public void setExternalCode(String externalCode) {
		this.externalCode = externalCode;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}