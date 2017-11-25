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

/**
 * The persistent class for the survey_option database table.
 * 
 */
@Entity
@Table(name = "survey_option")
@NamedQuery(name = "SurveyOption.findAll", query = "SELECT s FROM SurveyOption s")
public class SurveyOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "display_order")
	private int displayOrder;

	@Column(name = "survey_id")
	private int surveyId;

	@Lob
	@Column(name = "survey_option")
	private String surveyOption;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public SurveyOption() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public int getDisplayOrder() {
		return this.displayOrder;
	}

	public int getId() {
		return this.id;
	}

	public int getSurveyId() {
		return this.surveyId;
	}

	public String getSurveyOption() {
		return this.surveyOption;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public void setSurveyOption(String surveyOption) {
		this.surveyOption = surveyOption;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}