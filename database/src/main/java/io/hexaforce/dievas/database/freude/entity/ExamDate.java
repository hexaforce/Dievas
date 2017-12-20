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
@Table(name = "exam_date")
@NamedQuery(name = "ExamDate.findAll", query = "SELECT e FROM ExamDate e")
public class ExamDate extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "external_code")
	private String externalCode;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

}