package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "mail_magazine")
@NamedQuery(name = "MailMagazine.findAll", query = "SELECT m FROM MailMagazine m")
public class MailMagazine extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "adbook_id")
	private String adbookId;

	@Column(name = "count_all")
	private int countAll;

	@Column(name = "count_deferral")
	private int countDeferral;

	@Column(name = "count_failure")
	private int countFailure;

	@Column(name = "count_success")
	private int countSuccess;

	@Column(name = "csv_key")
	private String csvKey;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delivery_at")
	private Date deliveryAt;

	@Lob
	@Column(name = "delivery_condition")
	private String deliveryCondition;

	@Column(name = "delivery_id")
	private String deliveryId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "import_id")
	private String importId;

	@Column(name = "mail_id")
	private String mailId;

	private byte status;

	private String subject;

	@Lob
	private String text;

}