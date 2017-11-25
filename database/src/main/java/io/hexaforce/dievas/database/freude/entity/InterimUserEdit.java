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
 * The persistent class for the interim_user_edit database table.
 * 
 */
@Entity
@Table(name = "interim_user_edit")
@NamedQuery(name = "InterimUserEdit.findAll", query = "SELECT i FROM InterimUserEdit i")
public class InterimUserEdit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	private String email;

	@Column(name = "modify_nonce")
	private String modifyNonce;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_nonce_expires_at")
	private Date modifyNonceExpiresAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "user_id")
	private int userId;

	public InterimUserEdit() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public String getEmail() {
		return this.email;
	}

	public int getId() {
		return this.id;
	}

	public String getModifyNonce() {
		return this.modifyNonce;
	}

	public Date getModifyNonceExpiresAt() {
		return this.modifyNonceExpiresAt;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setModifyNonce(String modifyNonce) {
		this.modifyNonce = modifyNonce;
	}

	public void setModifyNonceExpiresAt(Date modifyNonceExpiresAt) {
		this.modifyNonceExpiresAt = modifyNonceExpiresAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}