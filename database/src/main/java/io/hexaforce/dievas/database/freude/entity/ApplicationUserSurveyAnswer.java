package io.hexaforce.dievas.database.freude.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import io.hexaforce.dievas.database.freude.BasicBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "application_user_survey_answer")
@NamedQuery(name = "ApplicationUserSurveyAnswer.findAll", query = "SELECT a FROM ApplicationUserSurveyAnswer a")
public class ApplicationUserSurveyAnswer extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Lob
	private String answer;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "survey_id")
	private int surveyId;

	@Column(name = "user_id")
	private int userId;

}