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
 * The persistent class for the csv_import_history database table.
 * 
 */
@Entity
@Table(name = "csv_import_history")
@NamedQuery(name = "CsvImportHistory.findAll", query = "SELECT c FROM CsvImportHistory c")
public class CsvImportHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "csv_import_id")
	private int csvImportId;

	private byte deleted;

	@Column(name = "file_key")
	private String fileKey;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "imported_at")
	private Date importedAt;

	private String location;

	@Column(name = "log_id")
	private int logId;

	@Column(name = "original_name")
	private String originalName;

	private byte status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public CsvImportHistory() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public int getCsvImportId() {
		return this.csvImportId;
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

	public Date getImportedAt() {
		return this.importedAt;
	}

	public String getLocation() {
		return this.location;
	}

	public int getLogId() {
		return this.logId;
	}

	public String getOriginalName() {
		return this.originalName;
	}

	public byte getStatus() {
		return this.status;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setCsvImportId(int csvImportId) {
		this.csvImportId = csvImportId;
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

	public void setImportedAt(Date importedAt) {
		this.importedAt = importedAt;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}