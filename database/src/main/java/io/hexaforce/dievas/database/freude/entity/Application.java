package io.hexaforce.dievas.database.freude.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
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
@NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a")
public class Application extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "cart_id")
	private int cartId;

	@Column(name = "exam_type_id")
	private int examTypeId;

	@Column(name = "accident_code")
	private String accidentCode;

	@Column(name = "application_no")
	private String applicationNo;

	@Column(name = "csv_exported")
	private byte csvExported;

	@Column(name = "disaster_victim_special_measures")
	private byte disasterVictimSpecialMeasures;

	@Column(name = "examinees_number_issued")
	private byte examineesNumberIssued;

	@Column(name = "gpa")
	private String gpa;

	@Column(name = "handicapped_person_code")
	private String handicappedPersonCode;

	@Column(name = "handicapped_person_special_measures")
	private byte handicappedPersonSpecialMeasures;

	@Column(name = "high_school_notification_consented")
	private byte highSchoolNotificationConsented;

	@Column(name = "management_status")
	private String managementStatus;

	@Column(name = "music_practical_code")
	private byte musicPracticalCode;

	@Column(name = "paid")
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

}