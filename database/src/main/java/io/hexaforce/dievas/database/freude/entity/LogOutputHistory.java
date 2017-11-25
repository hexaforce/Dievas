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
 * The persistent class for the log_output_history database table.
 * 
 */
@Entity
@Table(name = "log_output_history")
@NamedQuery(name = "LogOutputHistory.findAll", query = "SELECT l FROM LogOutputHistory l")
public class LogOutputHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "approve_or_refuse")
	private int approveOrRefuse;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "file_key")
	private String fileKey;

	private String location;

	@Column(name = "log_output_id")
	private int logOutputId;

	@Column(name = "original_name")
	private String originalName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "output_at")
	private Date outputAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public LogOutputHistory() {
	}

	public int getApproveOrRefuse() {
		return this.approveOrRefuse;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
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

	public int getLogOutputId() {
		return this.logOutputId;
	}

	public String getOriginalName() {
		return this.originalName;
	}

	public Date getOutputAt() {
		return this.outputAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setApproveOrRefuse(int approveOrRefuse) {
		this.approveOrRefuse = approveOrRefuse;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
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

	public void setLogOutputId(int logOutputId) {
		this.logOutputId = logOutputId;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public void setOutputAt(Date outputAt) {
		this.outputAt = outputAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}