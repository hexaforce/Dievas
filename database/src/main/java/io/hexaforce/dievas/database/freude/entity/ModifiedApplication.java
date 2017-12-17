package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "modified_application")
@NamedQuery(name = "ModifiedApplication.findAll", query = "SELECT m FROM ModifiedApplication m")
public class ModifiedApplication extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "accident_code")
	private String accidentCode;

	@Column(name = "application_id")
	private int applicationId;

	@Column(name = "application_no")
	private String applicationNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "applied_at")
	private Date appliedAt;

	@Column(name = "cart_id")
	private int cartId;

	@Column(name = "csv_exported")
	private byte csvExported;

	@Column(name = "disaster_victim_special_measures")
	private byte disasterVictimSpecialMeasures;

	@Column(name = "examinees_number_issued")
	private byte examineesNumberIssued;

	@Column(name = "exam_type_id")
	private int examTypeId;

	private String gpa;

	@Column(name = "handicapped_person_code")
	private String handicappedPersonCode;

	@Column(name = "handicapped_person_special_measures")
	private byte handicappedPersonSpecialMeasures;

	@Column(name = "high_school_notification_consented")
	private byte highSchoolNotificationConsented;

	@Column(name = "history_id")
	private int historyId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "management_status")
	private String managementStatus;

	@Column(name = "music_practical_code")
	private byte musicPracticalCode;

	private byte paid;

	@Column(name = "reference_number")
	private String referenceNumber;

	@Column(name = "specific_license_code")
	private byte specificLicenseCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ticket_issued_at")
	private Date ticketIssuedAt;

	@Column(name = "total_fee")
	private BigInteger totalFee;

	@Column(name = "user_id")
	private int userId;

}