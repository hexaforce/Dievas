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
 * The persistent class for the csv_export_history database table.
 * 
 */
@Entity
@Table(name = "csv_export_history")
@NamedQuery(name = "CsvExportHistory.findAll", query = "SELECT c FROM CsvExportHistory c")
public class CsvExportHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "csv_export_id")
	private int csvExportId;

	private byte deleted;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "exported_at")
	private Date exportedAt;

	@Column(name = "file_key")
	private String fileKey;

	private String location;

	@Column(name = "original_name")
	private String originalName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public CsvExportHistory() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public int getCsvExportId() {
		return this.csvExportId;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public Date getExportedAt() {
		return this.exportedAt;
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

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setCsvExportId(int csvExportId) {
		this.csvExportId = csvExportId;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setExportedAt(Date exportedAt) {
		this.exportedAt = exportedAt;
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

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}