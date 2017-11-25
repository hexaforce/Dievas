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
 * The persistent class for the examinees_number_issue_paramater database table.
 * 
 */
@Entity
@Table(name = "examinees_number_issue_paramater")
@NamedQuery(name = "ExamineesNumberIssueParamater.findAll", query = "SELECT e FROM ExamineesNumberIssueParamater e")
public class ExamineesNumberIssueParamater implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "course_code")
	private String courseCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "division_code")
	private String divisionCode;

	@Column(name = "exam_date_code")
	private String examDateCode;

	@Column(name = "exam_type_code")
	private String examTypeCode;

	@Column(name = "examinees_number_from")
	private int examineesNumberFrom;

	@Column(name = "examinees_number_to")
	private int examineesNumberTo;

	@Column(name = "other_code")
	private byte otherCode;

	@Column(name = "picked_form_code")
	private String pickedFormCode;

	@Column(name = "selected_course_code")
	private String selectedCourseCode;

	@Column(name = "site_code")
	private String siteCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public ExamineesNumberIssueParamater() {
	}

	public String getCourseCode() {
		return this.courseCode;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public String getDivisionCode() {
		return this.divisionCode;
	}

	public String getExamDateCode() {
		return this.examDateCode;
	}

	public int getExamineesNumberFrom() {
		return this.examineesNumberFrom;
	}

	public int getExamineesNumberTo() {
		return this.examineesNumberTo;
	}

	public String getExamTypeCode() {
		return this.examTypeCode;
	}

	public int getId() {
		return this.id;
	}

	public byte getOtherCode() {
		return this.otherCode;
	}

	public String getPickedFormCode() {
		return this.pickedFormCode;
	}

	public String getSelectedCourseCode() {
		return this.selectedCourseCode;
	}

	public String getSiteCode() {
		return this.siteCode;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	public void setExamDateCode(String examDateCode) {
		this.examDateCode = examDateCode;
	}

	public void setExamineesNumberFrom(int examineesNumberFrom) {
		this.examineesNumberFrom = examineesNumberFrom;
	}

	public void setExamineesNumberTo(int examineesNumberTo) {
		this.examineesNumberTo = examineesNumberTo;
	}

	public void setExamTypeCode(String examTypeCode) {
		this.examTypeCode = examTypeCode;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOtherCode(byte otherCode) {
		this.otherCode = otherCode;
	}

	public void setPickedFormCode(String pickedFormCode) {
		this.pickedFormCode = pickedFormCode;
	}

	public void setSelectedCourseCode(String selectedCourseCode) {
		this.selectedCourseCode = selectedCourseCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}