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
 * The persistent class for the exam_prop_input database table.
 * 
 */
@Entity
@Table(name = "exam_prop_input")
@NamedQuery(name = "ExamPropInput.findAll", query = "SELECT e FROM ExamPropInput e")
public class ExamPropInput implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private byte checked;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "exam_prop_form_id")
	private int examPropFormId;

	@Column(name = "group_name")
	private String groupName;

	private String name;

	private byte required;

	private String type;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	private String value;

	public ExamPropInput() {
	}

	public byte getChecked() {
		return this.checked;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public int getExamPropFormId() {
		return this.examPropFormId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public byte getRequired() {
		return this.required;
	}

	public String getType() {
		return this.type;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public String getValue() {
		return this.value;
	}

	public void setChecked(byte checked) {
		this.checked = checked;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setExamPropFormId(int examPropFormId) {
		this.examPropFormId = examPropFormId;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRequired(byte required) {
		this.required = required;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setValue(String value) {
		this.value = value;
	}

}