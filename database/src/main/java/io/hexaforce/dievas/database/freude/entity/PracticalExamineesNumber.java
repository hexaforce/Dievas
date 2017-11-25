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
 * The persistent class for the practical_examinees_number database table.
 * 
 */
@Entity
@Table(name = "practical_examinees_number")
@NamedQuery(name = "PracticalExamineesNumber.findAll", query = "SELECT p FROM PracticalExamineesNumber p")
public class PracticalExamineesNumber implements Serializable {
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

	@Column(name = "exam_type_code")
	private String examTypeCode;

	@Column(name = "examinees_number_from")
	private int examineesNumberFrom;

	@Column(name = "gender_code")
	private byte genderCode;

	@Column(name = "music_practical_code")
	private byte musicPracticalCode;

	@Column(name = "musical_grammar_code")
	private byte musicalGrammarCode;

	@Column(name = "picked_form_code")
	private String pickedFormCode;

	@Column(name = "practical_code")
	private byte practicalCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public PracticalExamineesNumber() {
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

	public int getExamineesNumberFrom() {
		return this.examineesNumberFrom;
	}

	public String getExamTypeCode() {
		return this.examTypeCode;
	}

	public byte getGenderCode() {
		return this.genderCode;
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

	public void setExamineesNumberFrom(int examineesNumberFrom) {
		this.examineesNumberFrom = examineesNumberFrom;
	}

	public void setExamTypeCode(String examTypeCode) {
		this.examTypeCode = examTypeCode;
	}

	public void setGenderCode(byte genderCode) {
		this.genderCode = genderCode;
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

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}