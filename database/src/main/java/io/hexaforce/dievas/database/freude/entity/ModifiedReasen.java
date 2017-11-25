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
 * The persistent class for the modified_reasen database table.
 * 
 */
@Entity
@Table(name = "modified_reasen")
@NamedQuery(name = "ModifiedReasen.findAll", query = "SELECT m FROM ModifiedReasen m")
public class ModifiedReasen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "history_id")
	private int historyId;

	@Lob
	@Column(name = "modified_reasen")
	private String modifiedReasen;

	@Column(name = "modified_term_name")
	private String modifiedTermName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public ModifiedReasen() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public int getHistoryId() {
		return this.historyId;
	}

	public int getId() {
		return this.id;
	}

	public String getModifiedReasen() {
		return this.modifiedReasen;
	}

	public String getModifiedTermName() {
		return this.modifiedTermName;
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

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setModifiedReasen(String modifiedReasen) {
		this.modifiedReasen = modifiedReasen;
	}

	public void setModifiedTermName(String modifiedTermName) {
		this.modifiedTermName = modifiedTermName;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}