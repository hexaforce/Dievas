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
 * The persistent class for the mail_template database table.
 * 
 */
@Entity
@Table(name = "mail_template")
@NamedQuery(name = "MailTemplate.findAll", query = "SELECT m FROM MailTemplate m")
public class MailTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "email_from")
	private String emailFrom;

	@Lob
	@Column(name = "email_subject")
	private String emailSubject;

	@Lob
	@Column(name = "email_text")
	private String emailText;

	@Column(name = "email_to_info")
	private String emailToInfo;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public MailTemplate() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public String getEmailFrom() {
		return this.emailFrom;
	}

	public String getEmailSubject() {
		return this.emailSubject;
	}

	public String getEmailText() {
		return this.emailText;
	}

	public String getEmailToInfo() {
		return this.emailToInfo;
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

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public void setEmailText(String emailText) {
		this.emailText = emailText;
	}

	public void setEmailToInfo(String emailToInfo) {
		this.emailToInfo = emailToInfo;
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

}