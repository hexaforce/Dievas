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
@Table(name = "interim_user_edit")
@NamedQuery(name = "InterimUserEdit.findAll", query = "SELECT i FROM InterimUserEdit i")
public class InterimUserEdit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	private String email;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

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

}