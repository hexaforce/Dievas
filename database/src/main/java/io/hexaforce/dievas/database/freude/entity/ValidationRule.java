package io.hexaforce.dievas.database.freude.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "validation_rule")
@NamedQuery(name = "ValidationRule.findAll", query = "SELECT v FROM ValidationRule v")
public class ValidationRule extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	private byte email;

	@Column(name = "field_name")
	private String fieldName;

	@Column(name = "form_class_name")
	private String formClassName;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private int max;

	private int min;

	private String pattern;

	@Lob
	@Column(name = "pattern_error_message")
	private String patternErrorMessage;

	private byte required;

	@Lob
	@Column(name = "size_error_message")
	private String sizeErrorMessage;

	@Column(name = "size_max")
	private int sizeMax;

	@Column(name = "size_min")
	private int sizeMin;


}