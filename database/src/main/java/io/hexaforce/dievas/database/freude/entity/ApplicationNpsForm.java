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
@Table(name = "application_nps_form")
@NamedQuery(name = "ApplicationNpsForm.findAll", query = "SELECT a FROM ApplicationNpsForm a")
public class ApplicationNpsForm extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

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
	@Column(name = "expires_at")
	private Date expiresAt;

	@Column(name = "file_id")
	private String fileId;

	@Column(name = "file_location")
	private String fileLocation;

	@Column(name = "form_types")
	private String formTypes;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "session_id")
	private String sessionId;

	private byte status;

	private byte store;



	@Column(name = "user_code")
	private String userCode;

	@Column(name = "user_id")
	private int userId;

}