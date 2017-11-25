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
 * The persistent class for the page_message database table.
 * 
 */
@Entity
@Table(name = "page_message")
@NamedQuery(name = "PageMessage.findAll", query = "SELECT p FROM PageMessage p")
public class PageMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Lob
	private String description;

	private String lang;

	@Lob
	private String message;

	@Column(name = "message_no")
	private int messageNo;

	@Column(name = "page_code")
	private String pageCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public PageMessage() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public String getDescription() {
		return this.description;
	}

	public int getId() {
		return this.id;
	}

	public String getLang() {
		return this.lang;
	}

	public String getMessage() {
		return this.message;
	}

	public int getMessageNo() {
		return this.messageNo;
	}

	public String getPageCode() {
		return this.pageCode;
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

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}