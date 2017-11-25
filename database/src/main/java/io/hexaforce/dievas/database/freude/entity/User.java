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
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	private String email;

	private byte locked;

	@Column(name = "login_failure_count")
	private int loginFailureCount;

	@Column(name = "operational_registered")
	private byte operationalRegistered;

	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "password_changed_at")
	private Date passwordChangedAt;

	@Column(name = "password_reminder_nonce")
	private String passwordReminderNonce;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "password_reminder_nonce_expires_at")
	private Date passwordReminderNonceExpiresAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registered_at")
	private Date registeredAt;

	private byte suspended;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "unlock_at")
	private Date unlockAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public User() {
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

	public byte getLocked() {
		return this.locked;
	}

	public int getLoginFailureCount() {
		return this.loginFailureCount;
	}

	public byte getOperationalRegistered() {
		return this.operationalRegistered;
	}

	public String getPassword() {
		return this.password;
	}

	public Date getPasswordChangedAt() {
		return this.passwordChangedAt;
	}

	public String getPasswordReminderNonce() {
		return this.passwordReminderNonce;
	}

	public Date getPasswordReminderNonceExpiresAt() {
		return this.passwordReminderNonceExpiresAt;
	}

	public Date getRegisteredAt() {
		return this.registeredAt;
	}

	public byte getSuspended() {
		return this.suspended;
	}

	public Date getUnlockAt() {
		return this.unlockAt;
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

	public void setLocked(byte locked) {
		this.locked = locked;
	}

	public void setLoginFailureCount(int loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}

	public void setOperationalRegistered(byte operationalRegistered) {
		this.operationalRegistered = operationalRegistered;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordChangedAt(Date passwordChangedAt) {
		this.passwordChangedAt = passwordChangedAt;
	}

	public void setPasswordReminderNonce(String passwordReminderNonce) {
		this.passwordReminderNonce = passwordReminderNonce;
	}

	public void setPasswordReminderNonceExpiresAt(Date passwordReminderNonceExpiresAt) {
		this.passwordReminderNonceExpiresAt = passwordReminderNonceExpiresAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}

	public void setSuspended(byte suspended) {
		this.suspended = suspended;
	}

	public void setUnlockAt(Date unlockAt) {
		this.unlockAt = unlockAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}