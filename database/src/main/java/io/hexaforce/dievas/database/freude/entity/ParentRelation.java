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
 * The persistent class for the parent_relation database table.
 * 
 */
@Entity
@Table(name = "parent_relation")
@NamedQuery(name = "ParentRelation.findAll", query = "SELECT p FROM ParentRelation p")
public class ParentRelation implements Serializable {
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

	@Column(name = "parent_relation_code")
	private String parentRelationCode;

	@Column(name = "parent_relation_name")
	private String parentRelationName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public ParentRelation() {
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

	public int getId() {
		return this.id;
	}

	public String getParentRelationCode() {
		return this.parentRelationCode;
	}

	public String getParentRelationName() {
		return this.parentRelationName;
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

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setParentRelationCode(String parentRelationCode) {
		this.parentRelationCode = parentRelationCode;
	}

	public void setParentRelationName(String parentRelationName) {
		this.parentRelationName = parentRelationName;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}