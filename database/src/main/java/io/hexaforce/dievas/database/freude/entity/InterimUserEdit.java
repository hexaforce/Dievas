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

import io.hexaforce.dievas.database.freude.BasicBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "interim_user_edit")
@NamedQuery(name = "InterimUserEdit.findAll", query = "SELECT i FROM InterimUserEdit i")
public class InterimUserEdit extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	private String email;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "modify_nonce")
	private String modifyNonce;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_nonce_expires_at")
	private Date modifyNonceExpiresAt;

	@Column(name = "user_id")
	private int userId;

}