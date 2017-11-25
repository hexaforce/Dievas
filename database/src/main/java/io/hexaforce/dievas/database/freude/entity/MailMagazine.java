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
 * The persistent class for the mail_magazine database table.
 * 
 */
@Entity
@Table(name = "mail_magazine")
@NamedQuery(name = "MailMagazine.findAll", query = "SELECT m FROM MailMagazine m")
public class MailMagazine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "adbook_id")
	private String adbookId;

	@Column(name = "count_all")
	private int countAll;

	@Column(name = "count_deferral")
	private int countDeferral;

	@Column(name = "count_failure")
	private int countFailure;

	@Column(name = "count_success")
	private int countSuccess;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "csv_key")
	private String csvKey;

	private byte deleted;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delivery_at")
	private Date deliveryAt;

	@Lob
	@Column(name = "delivery_condition")
	private String deliveryCondition;

	@Column(name = "delivery_id")
	private String deliveryId;

	@Column(name = "import_id")
	private String importId;

	@Column(name = "mail_id")
	private String mailId;

	private byte status;

	private String subject;

	@Lob
	private String text;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public MailMagazine() {
	}

	public String getAdbookId() {
		return this.adbookId;
	}

	public int getCountAll() {
		return this.countAll;
	}

	public int getCountDeferral() {
		return this.countDeferral;
	}

	public int getCountFailure() {
		return this.countFailure;
	}

	public int getCountSuccess() {
		return this.countSuccess;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public String getCsvKey() {
		return this.csvKey;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public Date getDeliveryAt() {
		return this.deliveryAt;
	}

	public String getDeliveryCondition() {
		return this.deliveryCondition;
	}

	public String getDeliveryId() {
		return this.deliveryId;
	}

	public int getId() {
		return this.id;
	}

	public String getImportId() {
		return this.importId;
	}

	public String getMailId() {
		return this.mailId;
	}

	public byte getStatus() {
		return this.status;
	}

	public String getSubject() {
		return this.subject;
	}

	public String getText() {
		return this.text;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setAdbookId(String adbookId) {
		this.adbookId = adbookId;
	}

	public void setCountAll(int countAll) {
		this.countAll = countAll;
	}

	public void setCountDeferral(int countDeferral) {
		this.countDeferral = countDeferral;
	}

	public void setCountFailure(int countFailure) {
		this.countFailure = countFailure;
	}

	public void setCountSuccess(int countSuccess) {
		this.countSuccess = countSuccess;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setCsvKey(String csvKey) {
		this.csvKey = csvKey;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setDeliveryAt(Date deliveryAt) {
		this.deliveryAt = deliveryAt;
	}

	public void setDeliveryCondition(String deliveryCondition) {
		this.deliveryCondition = deliveryCondition;
	}

	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImportId(String importId) {
		this.importId = importId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}