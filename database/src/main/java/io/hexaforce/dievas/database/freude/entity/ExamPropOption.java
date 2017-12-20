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
@Table(name = "exam_prop_option")
@NamedQuery(name = "ExamPropOption.findAll", query = "SELECT e FROM ExamPropOption e")
public class ExamPropOption extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "display_order")
	private int displayOrder;

	@Column(name = "exam_prop_input_id")
	private int examPropInputId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String label;

	private String name;

	private byte selected;

	private String value;

}