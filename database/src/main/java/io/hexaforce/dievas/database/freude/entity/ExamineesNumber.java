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
@Table(name = "examinees_number")
@NamedQuery(name = "ExamineesNumber.findAll", query = "SELECT e FROM ExamineesNumber e")
public class ExamineesNumber extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "application_id")
	private int applicationId;

	@Column(name = "exam_id")
	private int examId;

	@Column(name = "examinees_number")
	private int examineesNumber;

	private byte handicapped;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "pre_application_id")
	private int preApplicationId;

	@Column(name = "pre_exam_id")
	private int preExamId;

}