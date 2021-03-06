package io.hexaforce.dievas.database.freude.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.hexaforce.dievas.database.freude.BasicBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	private String email;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private byte locked;

	@Column(name = "login_failure_count")
	private int loginFailureCount;

	@Column(name = "operational_registered")
	private byte operationalRegistered;
	
	@JsonIgnore 
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

}