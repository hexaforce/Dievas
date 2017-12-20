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
@Table(name = "mail_template")
@NamedQuery(name = "MailTemplate.findAll", query = "SELECT m FROM MailTemplate m")
public class MailTemplate extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "email_from")
	private String emailFrom;

	@Lob
	@Column(name = "email_subject")
	private String emailSubject;

	@Lob
	@Column(name = "email_text")
	private String emailText;

	@Column(name = "email_to_info")
	private String emailToInfo;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

}