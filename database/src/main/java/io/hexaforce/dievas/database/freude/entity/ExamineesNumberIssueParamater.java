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
@Table(name = "examinees_number_issue_paramater")
@NamedQuery(name = "ExamineesNumberIssueParamater.findAll", query = "SELECT e FROM ExamineesNumberIssueParamater e")
public class ExamineesNumberIssueParamater extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "course_code")
	private String courseCode;

	@Column(name = "division_code")
	private String divisionCode;

	@Column(name = "exam_date_code")
	private String examDateCode;

	@Column(name = "examinees_number_from")
	private int examineesNumberFrom;

	@Column(name = "examinees_number_to")
	private int examineesNumberTo;

	@Column(name = "exam_type_code")
	private String examTypeCode;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "other_code")
	private byte otherCode;

	@Column(name = "picked_form_code")
	private String pickedFormCode;

	@Column(name = "selected_course_code")
	private String selectedCourseCode;

	@Column(name = "site_code")
	private String siteCode;

}