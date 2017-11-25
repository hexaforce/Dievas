package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the batch_job_condition database table.
 * 
 */
@Entity
@Table(name = "batch_job_condition")
@NamedQuery(name = "BatchJobCondition.findAll", query = "SELECT b FROM BatchJobCondition b")
public class BatchJobCondition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "batch_job_history_id")
	private int batchJobHistoryId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Lob
	@Column(name = "display_text")
	private String displayText;

	@Lob
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	@Lob
	private String value;

	public BatchJobCondition() {
	}

	public int getBatchJobHistoryId() {
		return this.batchJobHistoryId;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public String getDisplayText() {
		return this.displayText;
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

	public String getValue() {
		return this.value;
	}

	public void setBatchJobHistoryId(int batchJobHistoryId) {
		this.batchJobHistoryId = batchJobHistoryId;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
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

	public void setValue(String value) {
		this.value = value;
	}

}