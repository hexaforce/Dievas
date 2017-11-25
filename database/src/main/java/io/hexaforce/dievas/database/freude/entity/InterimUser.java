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
 * The persistent class for the interim_user database table.
 * 
 */
@Entity
@Table(name = "interim_user")
@NamedQuery(name = "InterimUser.findAll", query = "SELECT i FROM InterimUser i")
public class InterimUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	private String email;

	@Column(name = "register_nonce")
	private String registerNonce;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "register_nonce_expires_at")
	private Date registerNonceExpiresAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public InterimUser() {
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

	public String getRegisterNonce() {
		return this.registerNonce;
	}

	public Date getRegisterNonceExpiresAt() {
		return this.registerNonceExpiresAt;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRegisterNonce(String registerNonce) {
		this.registerNonce = registerNonce;
	}

	public void setRegisterNonceExpiresAt(Date registerNonceExpiresAt) {
		this.registerNonceExpiresAt = registerNonceExpiresAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}