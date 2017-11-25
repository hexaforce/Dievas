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
 * The persistent class for the examinees_number database table.
 * 
 */
@Entity
@Table(name = "examinees_number")
@NamedQuery(name = "ExamineesNumber.findAll", query = "SELECT e FROM ExamineesNumber e")
public class ExamineesNumber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "application_id")
	private int applicationId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "exam_id")
	private int examId;

	@Column(name = "examinees_number")
	private int examineesNumber;

	private byte handicapped;

	@Column(name = "pre_application_id")
	private int preApplicationId;

	@Column(name = "pre_exam_id")
	private int preExamId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public ExamineesNumber() {
	}

	public int getApplicationId() {
		return this.applicationId;
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

	public int getExamineesNumber() {
		return this.examineesNumber;
	}

	public byte getHandicapped() {
		return this.handicapped;
	}

	public int getId() {
		return this.id;
	}

	public int getPreApplicationId() {
		return this.preApplicationId;
	}

	public int getPreExamId() {
		return this.preExamId;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
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

	public void setExamineesNumber(int examineesNumber) {
		this.examineesNumber = examineesNumber;
	}

	public void setHandicapped(byte handicapped) {
		this.handicapped = handicapped;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPreApplicationId(int preApplicationId) {
		this.preApplicationId = preApplicationId;
	}

	public void setPreExamId(int preExamId) {
		this.preExamId = preExamId;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}