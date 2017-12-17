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

import io.hexaforce.dievas.database.freude.BasicBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "application_user_defect")
@NamedQuery(name = "ApplicationUserDefect.findAll", query = "SELECT a FROM ApplicationUserDefect a")
public class ApplicationUserDefect extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "defect_content")
	private String defectContent;

	@Column(name = "defect_id")
	private int defectId;

	@Column(name = "defect_level_type")
	private byte defectLevelType;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	@Column(name = "user_id")
	private int userId;

}