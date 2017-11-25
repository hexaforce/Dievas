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
 * The persistent class for the operator database table.
 * 
 */
@Entity
@NamedQuery(name = "Operator.findAll", query = "SELECT o FROM Operator o")
public class Operator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "closed_at")
	private Date closedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	private byte disabled;

	private String email;

	@Column(name = "login_id")
	private String loginId;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "opened_at")
	private Date openedAt;

	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public Operator() {
	}

	public Date getClosedAt() {
		return this.closedAt;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public byte getDisabled() {
		return this.disabled;
	}

	public String getEmail() {
		return this.email;
	}

	public int getId() {
		return this.id;
	}

	public String getLoginId() {
		return this.loginId;
	}

	public String getName() {
		return this.name;
	}

	public Date getOpenedAt() {
		return this.openedAt;
	}

	public String getPassword() {
		return this.password;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setClosedAt(Date closedAt) {
		this.closedAt = closedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setDisabled(byte disabled) {
		this.disabled = disabled;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOpenedAt(Date openedAt) {
		this.openedAt = openedAt;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}