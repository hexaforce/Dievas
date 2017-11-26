package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "freude_changelog")
@NamedQuery(name = "FreudeChangelog.findAll", query = "SELECT f FROM FreudeChangelog f")
public class FreudeChangelog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "APPLIED_AT")
	private String appliedAt;

	private String description;

	@Id
	private BigDecimal id;

}