package io.hexaforce.dievas.database.freude.entity;

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
@Table(name = "exam_fee")
@NamedQuery(name = "ExamFee.findAll", query = "SELECT e FROM ExamFee e")
public class ExamFee extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	private String description;

	private int fee;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

}