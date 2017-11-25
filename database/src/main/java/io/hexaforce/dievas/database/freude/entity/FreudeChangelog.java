package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the freude_changelog database table.
 * 
 */
@Entity
@Table(name = "freude_changelog")
@NamedQuery(name = "FreudeChangelog.findAll", query = "SELECT f FROM FreudeChangelog f")
public class FreudeChangelog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "APPLIED_AT")
	private String appliedAt;

	private String description;
	@Id
	private BigDecimal id;

	public FreudeChangelog() {
	}

	public String getAppliedAt() {
		return this.appliedAt;
	}

	public String getDescription() {
		return this.description;
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setAppliedAt(String appliedAt) {
		this.appliedAt = appliedAt;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

}