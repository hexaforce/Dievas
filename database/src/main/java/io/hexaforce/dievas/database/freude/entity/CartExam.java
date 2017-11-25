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
 * The persistent class for the cart_exam database table.
 * 
 */
@Entity
@Table(name = "cart_exam")
@NamedQuery(name = "CartExam.findAll", query = "SELECT c FROM CartExam c")
public class CartExam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "cart_id")
	private int cartId;

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

	@Column(name = "exam_type_external_code")
	private String examTypeExternalCode;

	@Column(name = "exam_type_id")
	private int examTypeId;

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

	public CartExam() {
	}

	public int getCartId() {
		return this.cartId;
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

	public String getExamTypeExternalCode() {
		return this.examTypeExternalCode;
	}

	public int getExamTypeId() {
		return this.examTypeId;
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

	public void setCartId(int cartId) {
		this.cartId = cartId;
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

	public void setExamTypeExternalCode(String examTypeExternalCode) {
		this.examTypeExternalCode = examTypeExternalCode;
	}

	public void setExamTypeId(int examTypeId) {
		this.examTypeId = examTypeId;
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