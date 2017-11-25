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
 * The persistent class for the batch_job_history database table.
 * 
 */
@Entity
@Table(name = "batch_job_history")
@NamedQuery(name = "BatchJobHistory.findAll", query = "SELECT b FROM BatchJobHistory b")
public class BatchJobHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "batch_name")
	private String batchName;

	@Column(name = "batch_status_type")
	private byte batchStatusType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ended_at")
	private Date endedAt;

	@Column(name = "exam_category_id")
	private int examCategoryId;

	@Column(name = "failed_count")
	private int failedCount;

	@Column(name = "file_key")
	private String fileKey;

	private String location;

	@Column(name = "original_name")
	private String originalName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "received_at")
	private Date receivedAt;

	@Column(name = "received_operator_id")
	private int receivedOperatorId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "started_at")
	private Date startedAt;

	@Column(name = "success_count")
	private int successCount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public BatchJobHistory() {
	}

	public String getBatchName() {
		return this.batchName;
	}

	public byte getBatchStatusType() {
		return this.batchStatusType;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public Date getEndedAt() {
		return this.endedAt;
	}

	public int getExamCategoryId() {
		return this.examCategoryId;
	}

	public int getFailedCount() {
		return this.failedCount;
	}

	public String getFileKey() {
		return this.fileKey;
	}

	public int getId() {
		return this.id;
	}

	public String getLocation() {
		return this.location;
	}

	public String getOriginalName() {
		return this.originalName;
	}

	public Date getReceivedAt() {
		return this.receivedAt;
	}

	public int getReceivedOperatorId() {
		return this.receivedOperatorId;
	}

	public Date getStartedAt() {
		return this.startedAt;
	}

	public int getSuccessCount() {
		return this.successCount;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public void setBatchStatusType(byte batchStatusType) {
		this.batchStatusType = batchStatusType;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setEndedAt(Date endedAt) {
		this.endedAt = endedAt;
	}

	public void setExamCategoryId(int examCategoryId) {
		this.examCategoryId = examCategoryId;
	}

	public void setFailedCount(int failedCount) {
		this.failedCount = failedCount;
	}

	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public void setReceivedAt(Date receivedAt) {
		this.receivedAt = receivedAt;
	}

	public void setReceivedOperatorId(int receivedOperatorId) {
		this.receivedOperatorId = receivedOperatorId;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}