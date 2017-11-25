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
 * The persistent class for the exam_site database table.
 * 
 */
@Entity
@Table(name = "exam_site")
@NamedQuery(name = "ExamSite.findAll", query = "SELECT e FROM ExamSite e")
public class ExamSite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "capacity_count")
	private int capacityCount;

	@Column(name = "commuted_place_id_to")
	private int commutedPlaceIdTo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "entry_stopped")
	private byte entryStopped;

	@Column(name = "exam_id")
	private int examId;

	@Column(name = "site_id")
	private int siteId;

	@Column(name = "threshold_count")
	private int thresholdCount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public ExamSite() {
	}

	public int getCapacityCount() {
		return this.capacityCount;
	}

	public int getCommutedPlaceIdTo() {
		return this.commutedPlaceIdTo;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public byte getEntryStopped() {
		return this.entryStopped;
	}

	public int getExamId() {
		return this.examId;
	}

	public int getId() {
		return this.id;
	}

	public int getSiteId() {
		return this.siteId;
	}

	public int getThresholdCount() {
		return this.thresholdCount;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setCapacityCount(int capacityCount) {
		this.capacityCount = capacityCount;
	}

	public void setCommutedPlaceIdTo(int commutedPlaceIdTo) {
		this.commutedPlaceIdTo = commutedPlaceIdTo;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setEntryStopped(byte entryStopped) {
		this.entryStopped = entryStopped;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public void setThresholdCount(int thresholdCount) {
		this.thresholdCount = thresholdCount;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}