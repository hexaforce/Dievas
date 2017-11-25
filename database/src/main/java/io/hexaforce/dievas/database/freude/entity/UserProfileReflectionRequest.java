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
 * The persistent class for the user_profile_reflection_request database table.
 * 
 */
@Entity
@Table(name = "user_profile_reflection_request")
@NamedQuery(name = "UserProfileReflectionRequest.findAll", query = "SELECT u FROM UserProfileReflectionRequest u")
public class UserProfileReflectionRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "application_user_profile_id")
	private int applicationUserProfileId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "reflection_type")
	private byte reflectionType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "requesuted_at")
	private Date requesutedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "user_id")
	private int userId;

	public UserProfileReflectionRequest() {
	}

	public int getApplicationUserProfileId() {
		return this.applicationUserProfileId;
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

	public byte getReflectionType() {
		return this.reflectionType;
	}

	public Date getRequesutedAt() {
		return this.requesutedAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setApplicationUserProfileId(int applicationUserProfileId) {
		this.applicationUserProfileId = applicationUserProfileId;
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

	public void setReflectionType(byte reflectionType) {
		this.reflectionType = reflectionType;
	}

	public void setRequesutedAt(Date requesutedAt) {
		this.requesutedAt = requesutedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}