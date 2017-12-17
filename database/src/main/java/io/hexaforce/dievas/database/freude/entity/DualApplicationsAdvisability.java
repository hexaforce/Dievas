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
@Table(name = "dual_applications_advisability")
@NamedQuery(name = "DualApplicationsAdvisability.findAll", query = "SELECT d FROM DualApplicationsAdvisability d")
public class DualApplicationsAdvisability extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "bad_exam_id")
	private int badExamId;

	@Column(name = "exam_id")
	private int examId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

}