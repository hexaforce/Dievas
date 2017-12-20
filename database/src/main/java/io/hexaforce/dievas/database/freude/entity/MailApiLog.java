package io.hexaforce.dievas.database.freude.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import io.hexaforce.dievas.database.freude.BasicBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mail_api_log")
@NamedQuery(name = "MailApiLog.findAll", query = "SELECT m FROM MailApiLog m")
public class MailApiLog extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Lob
	@Column(name = "request_body")
	private String requestBody;

	@Column(name = "request_url")
	private String requestUrl;

	@Lob
	@Column(name = "response_body")
	private String responseBody;

	@Lob
	@Column(name = "response_headers")
	private String responseHeaders;

	@Column(name = "response_status")
	private int responseStatus;


}