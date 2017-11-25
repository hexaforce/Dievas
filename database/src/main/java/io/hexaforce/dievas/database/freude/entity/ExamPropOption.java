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

/**
 * The persistent class for the exam_prop_option database table.
 * 
 */
@Entity
@Table(name = "exam_prop_option")
@NamedQuery(name = "ExamPropOption.findAll", query = "SELECT e FROM ExamPropOption e")
public class ExamPropOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "display_order")
	private int displayOrder;

	@Column(name = "exam_prop_input_id")
	private int examPropInputId;

	private String label;

	private String name;

	private byte selected;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	private String value;

	public ExamPropOption() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public int getDisplayOrder() {
		return this.displayOrder;
	}

	public int getExamPropInputId() {
		return this.examPropInputId;
	}

	public int getId() {
		return this.id;
	}

	public String getLabel() {
		return this.label;
	}

	public String getName() {
		return this.name;
	}

	public byte getSelected() {
		return this.selected;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public String getValue() {
		return this.value;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public void setExamPropInputId(int examPropInputId) {
		this.examPropInputId = examPropInputId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSelected(byte selected) {
		this.selected = selected;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setValue(String value) {
		this.value = value;
	}

}