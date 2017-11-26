package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "application_no_config")
@NamedQuery(name = "ApplicationNoConfig.findAll", query = "SELECT a FROM ApplicationNoConfig a")
public class ApplicationNoConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "exam_type_id")
	private int examTypeId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "max_application_no")
	private String maxApplicationNo;

	@Column(name = "min_application_no")
	private String minApplicationNo;

	@Column(name = "site_id")
	private int siteId;

}