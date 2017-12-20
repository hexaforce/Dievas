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
@Table(name = "exam_type")
@NamedQuery(name = "ExamType.findAll", query = "SELECT e FROM ExamType e")
public class ExamType extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "display_name")
	private String displayName;

	@Column(name = "display_order")
	private int displayOrder;

	@Column(name = "early_decision")
	private byte earlyDecision;

	@Column(name = "exam_category_id")
	private int examCategoryId;

	@Column(name = "exam_prop_form_id")
	private int examPropFormId;

	@Column(name = "external_code")
	private String externalCode;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

}