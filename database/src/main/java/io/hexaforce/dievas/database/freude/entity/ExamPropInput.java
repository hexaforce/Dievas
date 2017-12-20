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
@Table(name = "exam_prop_input")
@NamedQuery(name = "ExamPropInput.findAll", query = "SELECT e FROM ExamPropInput e")
public class ExamPropInput extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	private byte checked;

	@Column(name = "exam_prop_form_id")
	private int examPropFormId;

	@Column(name = "group_name")
	private String groupName;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private byte required;

	private String type;

	private String value;

}