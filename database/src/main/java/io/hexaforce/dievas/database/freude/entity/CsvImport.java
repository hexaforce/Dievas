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
 * The persistent class for the csv_import database table.
 * 
 */
@Entity
@Table(name = "csv_import")
@NamedQuery(name = "CsvImport.findAll", query = "SELECT c FROM CsvImport c")
public class CsvImport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Lob
	@Column(name = "convert_func")
	private String convertFunc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	private String name;

	private String path;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public CsvImport() {
	}

	public String getConvertFunc() {
		return this.convertFunc;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getPath() {
		return this.path;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setConvertFunc(String convertFunc) {
		this.convertFunc = convertFunc;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}