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
 * The persistent class for the application_grade_point database table.
 * 
 */
@Entity
@Table(name = "application_grade_point")
@NamedQuery(name = "ApplicationGradePoint.findAll", query = "SELECT a FROM ApplicationGradePoint a")
public class ApplicationGradePoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "application_id")
	private int applicationId;

	@Column(name = "course_name")
	private String courseName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	private String gp;

	private int orderNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public ApplicationGradePoint() {
	}

	public int getApplicationId() {
		return this.applicationId;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public String getGp() {
		return this.gp;
	}

	public int getId() {
		return this.id;
	}

	public int getOrderNo() {
		return this.orderNo;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setGp(String gp) {
		this.gp = gp;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}