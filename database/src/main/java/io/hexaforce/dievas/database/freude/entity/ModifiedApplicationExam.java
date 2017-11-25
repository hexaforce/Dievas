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

/**
 * The persistent class for the modified_application_exam database table.
 * 
 */
@Entity
@Table(name = "modified_application_exam")
@NamedQuery(name = "ModifiedApplicationExam.findAll", query = "SELECT m FROM ModifiedApplicationExam m")
public class ModifiedApplicationExam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "application_exum_id")
	private int applicationExumId;

	@Column(name = "application_id")
	private int applicationId;

	@Column(name = "course_external_code")
	private String courseExternalCode;

	@Column(name = "course_id")
	private int courseId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "department_external_code")
	private String departmentExternalCode;

	@Column(name = "department_id")
	private int departmentId;

	@Column(name = "division_external_code")
	private String divisionExternalCode;

	@Column(name = "division_id")
	private int divisionId;

	@Column(name = "exam_id")
	private int examId;

	@Column(name = "exam_result")
	private byte examResult;

	@Column(name = "exam_type_external_code")
	private String examTypeExternalCode;

	@Column(name = "exam_type_id")
	private int examTypeId;

	@Column(name = "examinees_number")
	private String examineesNumber;

	@Column(name = "examinees_number_mail_sent")
	private byte examineesNumberMailSent;

	@Column(name = "gpa_status")
	private byte gpaStatus;

	@Column(name = "history_id")
	private int historyId;

	@Column(name = "music_practical_code")
	private byte musicPracticalCode;

	@Column(name = "musical_grammar_code")
	private byte musicalGrammarCode;

	@Column(name = "picked_form_code")
	private String pickedFormCode;

	@Column(name = "practical_code")
	private byte practicalCode;

	@Column(name = "practical_exam_number")
	private int practicalExamNumber;

	@Column(name = "selected_course_code")
	private String selectedCourseCode;

	@Column(name = "site_id")
	private int siteId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public ModifiedApplicationExam() {
	}

	public int getApplicationExumId() {
		return this.applicationExumId;
	}

	public int getApplicationId() {
		return this.applicationId;
	}

	public String getCourseExternalCode() {
		return this.courseExternalCode;
	}

	public int getCourseId() {
		return this.courseId;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public String getDepartmentExternalCode() {
		return this.departmentExternalCode;
	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public String getDivisionExternalCode() {
		return this.divisionExternalCode;
	}

	public int getDivisionId() {
		return this.divisionId;
	}

	public int getExamId() {
		return this.examId;
	}

	public String getExamineesNumber() {
		return this.examineesNumber;
	}

	public byte getExamineesNumberMailSent() {
		return this.examineesNumberMailSent;
	}

	public byte getExamResult() {
		return this.examResult;
	}

	public String getExamTypeExternalCode() {
		return this.examTypeExternalCode;
	}

	public int getExamTypeId() {
		return this.examTypeId;
	}

	public byte getGpaStatus() {
		return this.gpaStatus;
	}

	public int getHistoryId() {
		return this.historyId;
	}

	public int getId() {
		return this.id;
	}

	public byte getMusicalGrammarCode() {
		return this.musicalGrammarCode;
	}

	public byte getMusicPracticalCode() {
		return this.musicPracticalCode;
	}

	public String getPickedFormCode() {
		return this.pickedFormCode;
	}

	public byte getPracticalCode() {
		return this.practicalCode;
	}

	public int getPracticalExamNumber() {
		return this.practicalExamNumber;
	}

	public String getSelectedCourseCode() {
		return this.selectedCourseCode;
	}

	public int getSiteId() {
		return this.siteId;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setApplicationExumId(int applicationExumId) {
		this.applicationExumId = applicationExumId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public void setCourseExternalCode(String courseExternalCode) {
		this.courseExternalCode = courseExternalCode;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setDepartmentExternalCode(String departmentExternalCode) {
		this.departmentExternalCode = departmentExternalCode;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public void setDivisionExternalCode(String divisionExternalCode) {
		this.divisionExternalCode = divisionExternalCode;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public void setExamineesNumber(String examineesNumber) {
		this.examineesNumber = examineesNumber;
	}

	public void setExamineesNumberMailSent(byte examineesNumberMailSent) {
		this.examineesNumberMailSent = examineesNumberMailSent;
	}

	public void setExamResult(byte examResult) {
		this.examResult = examResult;
	}

	public void setExamTypeExternalCode(String examTypeExternalCode) {
		this.examTypeExternalCode = examTypeExternalCode;
	}

	public void setExamTypeId(int examTypeId) {
		this.examTypeId = examTypeId;
	}

	public void setGpaStatus(byte gpaStatus) {
		this.gpaStatus = gpaStatus;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMusicalGrammarCode(byte musicalGrammarCode) {
		this.musicalGrammarCode = musicalGrammarCode;
	}

	public void setMusicPracticalCode(byte musicPracticalCode) {
		this.musicPracticalCode = musicPracticalCode;
	}

	public void setPickedFormCode(String pickedFormCode) {
		this.pickedFormCode = pickedFormCode;
	}

	public void setPracticalCode(byte practicalCode) {
		this.practicalCode = practicalCode;
	}

	public void setPracticalExamNumber(int practicalExamNumber) {
		this.practicalExamNumber = practicalExamNumber;
	}

	public void setSelectedCourseCode(String selectedCourseCode) {
		this.selectedCourseCode = selectedCourseCode;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}