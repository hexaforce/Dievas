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
 * The persistent class for the modified_user_survey_answer database table.
 * 
 */
@Entity
@Table(name = "modified_user_survey_answer")
@NamedQuery(name = "ModifiedUserSurveyAnswer.findAll", query = "SELECT m FROM ModifiedUserSurveyAnswer m")
public class ModifiedUserSurveyAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Lob
	private String answer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "history_id")
	private int historyId;

	@Column(name = "survey_id")
	private int surveyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_survey_answer_id")
	private int userSurveyAnswerId;

	public ModifiedUserSurveyAnswer() {
	}

	public String getAnswer() {
		return this.answer;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public int getHistoryId() {
		return this.historyId;
	}

	public int getId() {
		return this.id;
	}

	public int getSurveyId() {
		return this.surveyId;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public int getUserId() {
		return this.userId;
	}

	public int getUserSurveyAnswerId() {
		return this.userSurveyAnswerId;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserSurveyAnswerId(int userSurveyAnswerId) {
		this.userSurveyAnswerId = userSurveyAnswerId;
	}

}