package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the inquiry database table.
 * 
 */
@Entity
@NamedQuery(name = "Inquiry.findAll", query = "SELECT i FROM Inquiry i")
public class Inquiry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	private String note;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "operate_at")
	private Date operateAt;

	@Column(name = "staff_name")
	private String staffName;

	private String status;

	private String text;

	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "user_id")
	private int userId;

	public Inquiry() {
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

	public String getNote() {
		return this.note;
	}

	public Date getOperateAt() {
		return this.operateAt;
	}

	public String getStaffName() {
		return this.staffName;
	}

	public String getStatus() {
		return this.status;
	}

	public String getText() {
		return this.text;
	}

	public String getTitle() {
		return this.title;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public int getUserId() {
		return this.userId;
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

	public void setNote(String note) {
		this.note = note;
	}

	public void setOperateAt(Date operateAt) {
		this.operateAt = operateAt;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}