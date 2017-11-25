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
 * The persistent class for the payment_log database table.
 * 
 */
@Entity
@Table(name = "payment_log")
@NamedQuery(name = "PaymentLog.findAll", query = "SELECT p FROM PaymentLog p")
public class PaymentLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "payment_id")
	private int paymentId;

	@Column(name = "payment_kind")
	private byte paymentKind;

	@Lob
	private String req;

	@Lob
	private String res;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public PaymentLog() {
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

	public int getPaymentId() {
		return this.paymentId;
	}

	public byte getPaymentKind() {
		return this.paymentKind;
	}

	public String getReq() {
		return this.req;
	}

	public String getRes() {
		return this.res;
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

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public void setPaymentKind(byte paymentKind) {
		this.paymentKind = paymentKind;
	}

	public void setReq(String req) {
		this.req = req;
	}

	public void setRes(String res) {
		this.res = res;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}