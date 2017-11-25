package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the application_no_config database table.
 * 
 */
@Entity
@Table(name = "application_no_config")
@NamedQuery(name = "ApplicationNoConfig.findAll", query = "SELECT a FROM ApplicationNoConfig a")
public class ApplicationNoConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "exam_type_id")
	private int examTypeId;

	@Column(name = "max_application_no")
	private String maxApplicationNo;

	@Column(name = "min_application_no")
	private String minApplicationNo;

	@Column(name = "site_id")
	private int siteId;

	public ApplicationNoConfig() {
	}

	public int getExamTypeId() {
		return this.examTypeId;
	}

	public int getId() {
		return this.id;
	}

	public String getMaxApplicationNo() {
		return this.maxApplicationNo;
	}

	public String getMinApplicationNo() {
		return this.minApplicationNo;
	}

	public int getSiteId() {
		return this.siteId;
	}

	public void setExamTypeId(int examTypeId) {
		this.examTypeId = examTypeId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMaxApplicationNo(String maxApplicationNo) {
		this.maxApplicationNo = maxApplicationNo;
	}

	public void setMinApplicationNo(String minApplicationNo) {
		this.minApplicationNo = minApplicationNo;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

}