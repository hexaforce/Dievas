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
 * The persistent class for the exam_type database table.
 * 
 */
@Entity
@Table(name = "exam_type")
@NamedQuery(name = "ExamType.findAll", query = "SELECT e FROM ExamType e")
public class ExamType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

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

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public ExamType() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public int getDisplayOrder() {
		return this.displayOrder;
	}

	public byte getEarlyDecision() {
		return this.earlyDecision;
	}

	public int getExamCategoryId() {
		return this.examCategoryId;
	}

	public int getExamPropFormId() {
		return this.examPropFormId;
	}

	public String getExternalCode() {
		return this.externalCode;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
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

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public void setEarlyDecision(byte earlyDecision) {
		this.earlyDecision = earlyDecision;
	}

	public void setExamCategoryId(int examCategoryId) {
		this.examCategoryId = examCategoryId;
	}

	public void setExamPropFormId(int examPropFormId) {
		this.examPropFormId = examPropFormId;
	}

	public void setExternalCode(String externalCode) {
		this.externalCode = externalCode;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}