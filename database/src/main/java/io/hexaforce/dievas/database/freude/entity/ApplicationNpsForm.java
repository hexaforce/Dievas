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
 * The persistent class for the application_nps_form database table.
 * 
 */
@Entity
@Table(name = "application_nps_form")
@NamedQuery(name = "ApplicationNpsForm.findAll", query = "SELECT a FROM ApplicationNpsForm a")
public class ApplicationNpsForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String accessKey;

	@Column(name = "application_id")
	private int applicationId;

	@Column(name = "auth_token")
	private String authToken;

	@Column(name = "auth_user")
	private String authUser;

	@Column(name = "cart_id")
	private int cartId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expires_at")
	private Date expiresAt;

	@Column(name = "file_id")
	private String fileId;

	@Column(name = "file_location")
	private String fileLocation;

	@Column(name = "form_types")
	private String formTypes;

	@Column(name = "session_id")
	private String sessionId;

	private byte status;

	private byte store;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "user_code")
	private String userCode;

	@Column(name = "user_id")
	private int userId;

	public ApplicationNpsForm() {
	}

	public String getAccessKey() {
		return this.accessKey;
	}

	public int getApplicationId() {
		return this.applicationId;
	}

	public String getAuthToken() {
		return this.authToken;
	}

	public String getAuthUser() {
		return this.authUser;
	}

	public int getCartId() {
		return this.cartId;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public Date getExpiresAt() {
		return this.expiresAt;
	}

	public String getFileId() {
		return this.fileId;
	}

	public String getFileLocation() {
		return this.fileLocation;
	}

	public String getFormTypes() {
		return this.formTypes;
	}

	public int getId() {
		return this.id;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public byte getStatus() {
		return this.status;
	}

	public byte getStore() {
		return this.store;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public void setAuthUser(String authUser) {
		this.authUser = authUser;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public void setFormTypes(String formTypes) {
		this.formTypes = formTypes;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public void setStore(byte store) {
		this.store = store;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}