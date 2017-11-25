package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the validation_rule database table.
 * 
 */
@Entity
@Table(name = "validation_rule")
@NamedQuery(name = "ValidationRule.findAll", query = "SELECT v FROM ValidationRule v")
public class ValidationRule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	private byte email;

	@Column(name = "field_name")
	private String fieldName;

	@Column(name = "form_class_name")
	private String formClassName;

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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public ValidationRule() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public byte getEmail() {
		return this.email;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public String getFormClassName() {
		return this.formClassName;
	}

	public int getId() {
		return this.id;
	}

	public int getMax() {
		return this.max;
	}

	public int getMin() {
		return this.min;
	}

	public String getPattern() {
		return this.pattern;
	}

	public String getPatternErrorMessage() {
		return this.patternErrorMessage;
	}

	public byte getRequired() {
		return this.required;
	}

	public String getSizeErrorMessage() {
		return this.sizeErrorMessage;
	}

	public int getSizeMax() {
		return this.sizeMax;
	}

	public int getSizeMin() {
		return this.sizeMin;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setEmail(byte email) {
		this.email = email;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setFormClassName(String formClassName) {
		this.formClassName = formClassName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public void setPatternErrorMessage(String patternErrorMessage) {
		this.patternErrorMessage = patternErrorMessage;
	}

	public void setRequired(byte required) {
		this.required = required;
	}

	public void setSizeErrorMessage(String sizeErrorMessage) {
		this.sizeErrorMessage = sizeErrorMessage;
	}

	public void setSizeMax(int sizeMax) {
		this.sizeMax = sizeMax;
	}

	public void setSizeMin(int sizeMin) {
		this.sizeMin = sizeMin;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}