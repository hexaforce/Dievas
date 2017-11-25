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
 * The persistent class for the mail_api_log database table.
 * 
 */
@Entity
@Table(name = "mail_api_log")
@NamedQuery(name = "MailApiLog.findAll", query = "SELECT m FROM MailApiLog m")
public class MailApiLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Lob
	@Column(name = "request_body")
	private String requestBody;

	@Column(name = "request_url")
	private String requestUrl;

	@Lob
	@Column(name = "response_body")
	private String responseBody;

	@Lob
	@Column(name = "response_headers")
	private String responseHeaders;

	@Column(name = "response_status")
	private int responseStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public MailApiLog() {
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

	public String getRequestBody() {
		return this.requestBody;
	}

	public String getRequestUrl() {
		return this.requestUrl;
	}

	public String getResponseBody() {
		return this.responseBody;
	}

	public String getResponseHeaders() {
		return this.responseHeaders;
	}

	public int getResponseStatus() {
		return this.responseStatus;
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

	public void setId(int id) {
		this.id = id;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	public void setResponseHeaders(String responseHeaders) {
		this.responseHeaders = responseHeaders;
	}

	public void setResponseStatus(int responseStatus) {
		this.responseStatus = responseStatus;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}