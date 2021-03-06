package io.hexaforce.dievas.database.freude.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "practical_examinees_number")
@NamedQuery(name = "PracticalExamineesNumber.findAll", query = "SELECT p FROM PracticalExamineesNumber p")
public class PracticalExamineesNumber extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "course_code")
	private String courseCode;

	@Column(name = "division_code")
	private String divisionCode;

	@Column(name = "examinees_number_from")
	private int examineesNumberFrom;

	@Column(name = "exam_type_code")
	private String examTypeCode;

	@Column(name = "gender_code")
	private byte genderCode;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "musical_grammar_code")
	private byte musicalGrammarCode;

	@Column(name = "music_practical_code")
	private byte musicPracticalCode;

	@Column(name = "picked_form_code")
	private String pickedFormCode;

	@Column(name = "practical_code")
	private byte practicalCode;

}