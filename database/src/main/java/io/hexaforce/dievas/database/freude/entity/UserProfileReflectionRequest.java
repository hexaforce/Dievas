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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_profile_reflection_request")
@NamedQuery(name = "UserProfileReflectionRequest.findAll", query = "SELECT u FROM UserProfileReflectionRequest u")
public class UserProfileReflectionRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "application_user_profile_id")
	private int applicationUserProfileId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

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

}