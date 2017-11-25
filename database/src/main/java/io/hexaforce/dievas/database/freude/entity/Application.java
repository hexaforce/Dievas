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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the application database table.
 * 
 */
@Entity
@NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a")
public class Application implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "accident_code")
	private String accidentCode;

	@Column(name = "application_no")
	private String applicationNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "applied_at")
	private Date appliedAt;

	@Column(name = "cart_id")
	private int cartId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "csv_exported")
	private byte csvExported;

	private byte deleted;

	@Column(name = "disaster_victim_special_measures")
	private byte disasterVictimSpecialMeasures;

	@Column(name = "exam_type_id")
	private int examTypeId;

	@Column(name = "examinees_number_issued")
	private byte examineesNumberIssued;

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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "user_id")
	private int userId;

	public Application() {
	}

	public String getAccidentCode() {
		return this.accidentCode;
	}

	public String getApplicationNo() {
		return this.applicationNo;
	}

	public Date getAppliedAt() {
		return this.appliedAt;
	}

	public int getCartId() {
		return this.cartId;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getCsvExported() {
		return this.csvExported;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public byte getDisasterVictimSpecialMeasures() {
		return this.disasterVictimSpecialMeasures;
	}

	public byte getExamineesNumberIssued() {
		return this.examineesNumberIssued;
	}

	public int getExamTypeId() {
		return this.examTypeId;
	}

	public String getGpa() {
		return this.gpa;
	}

	public String getHandicappedPersonCode() {
		return this.handicappedPersonCode;
	}

	public byte getHandicappedPersonSpecialMeasures() {
		return this.handicappedPersonSpecialMeasures;
	}

	public byte getHighSchoolNotificationConsented() {
		return this.highSchoolNotificationConsented;
	}

	public int getId() {
		return this.id;
	}

	public String getManagementStatus() {
		return this.managementStatus;
	}

	public byte getMusicPracticalCode() {
		return this.musicPracticalCode;
	}

	public byte getPaid() {
		return this.paid;
	}

	public String getReferenceNumber() {
		return this.referenceNumber;
	}

	public byte getSpecificLicenseCode() {
		return this.specificLicenseCode;
	}

	public Date getTicketIssuedAt() {
		return this.ticketIssuedAt;
	}

	public BigInteger getTotalFee() {
		return this.totalFee;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setAccidentCode(String accidentCode) {
		this.accidentCode = accidentCode;
	}

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public void setAppliedAt(Date appliedAt) {
		this.appliedAt = appliedAt;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setCsvExported(byte csvExported) {
		this.csvExported = csvExported;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setDisasterVictimSpecialMeasures(byte disasterVictimSpecialMeasures) {
		this.disasterVictimSpecialMeasures = disasterVictimSpecialMeasures;
	}

	public void setExamineesNumberIssued(byte examineesNumberIssued) {
		this.examineesNumberIssued = examineesNumberIssued;
	}

	public void setExamTypeId(int examTypeId) {
		this.examTypeId = examTypeId;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public void setHandicappedPersonCode(String handicappedPersonCode) {
		this.handicappedPersonCode = handicappedPersonCode;
	}

	public void setHandicappedPersonSpecialMeasures(byte handicappedPersonSpecialMeasures) {
		this.handicappedPersonSpecialMeasures = handicappedPersonSpecialMeasures;
	}

	public void setHighSchoolNotificationConsented(byte highSchoolNotificationConsented) {
		this.highSchoolNotificationConsented = highSchoolNotificationConsented;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setManagementStatus(String managementStatus) {
		this.managementStatus = managementStatus;
	}

	public void setMusicPracticalCode(byte musicPracticalCode) {
		this.musicPracticalCode = musicPracticalCode;
	}

	public void setPaid(byte paid) {
		this.paid = paid;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public void setSpecificLicenseCode(byte specificLicenseCode) {
		this.specificLicenseCode = specificLicenseCode;
	}

	public void setTicketIssuedAt(Date ticketIssuedAt) {
		this.ticketIssuedAt = ticketIssuedAt;
	}

	public void setTotalFee(BigInteger totalFee) {
		this.totalFee = totalFee;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}