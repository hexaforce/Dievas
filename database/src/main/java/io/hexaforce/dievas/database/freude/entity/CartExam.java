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

import io.hexaforce.dievas.database.freude.BasicBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart_exam")
@NamedQuery(name = "CartExam.findAll", query = "SELECT c FROM CartExam c")
public class CartExam extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "cart_id")
	private int cartId;

	@Column(name = "course_external_code")
	private String courseExternalCode;

	@Column(name = "course_id")
	private int courseId;

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

	@Column(name = "practical_exam_number")
	private int practicalExamNumber;

	@Column(name = "selected_course_code")
	private String selectedCourseCode;

	@Column(name = "site_id")
	private int siteId;

}