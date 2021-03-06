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
@Table(name = "designated_high_school")
@NamedQuery(name = "DesignatedHighSchool.findAll", query = "SELECT d FROM DesignatedHighSchool d")
public class DesignatedHighSchool extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;


	@Column(name = "department_id")
	private int departmentId;

	@Column(name = "division_external_code")
	private String divisionExternalCode;

	@Column(name = "exam_id")
	private int examId;

	@Column(name = "high_school_code")
	private String highSchoolCode;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

}