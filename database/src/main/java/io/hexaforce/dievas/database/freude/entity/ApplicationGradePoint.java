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
@Table(name = "application_grade_point")
@NamedQuery(name = "ApplicationGradePoint.findAll", query = "SELECT a FROM ApplicationGradePoint a")
public class ApplicationGradePoint extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "application_id")
	private int applicationId;

	@Column(name = "course_name")
	private String courseName;

	@Column(name = "gp")
	private String gp;

	@Column(name = "order_no")
	private int orderNo;

}