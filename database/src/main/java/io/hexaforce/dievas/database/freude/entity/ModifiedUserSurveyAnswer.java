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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "modified_user_survey_answer")
@NamedQuery(name = "ModifiedUserSurveyAnswer.findAll", query = "SELECT m FROM ModifiedUserSurveyAnswer m")
public class ModifiedUserSurveyAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Lob
	private String answer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "history_id")
	private int historyId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "survey_id")
	private int surveyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_survey_answer_id")
	private int userSurveyAnswerId;

}