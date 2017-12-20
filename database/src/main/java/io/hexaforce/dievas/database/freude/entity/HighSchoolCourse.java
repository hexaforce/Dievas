package io.hexaforce.dievas.database.freude.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import io.hexaforce.dievas.database.freude.BasicBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "high_school_course")
@NamedQuery(name = "HighSchoolCourse.findAll", query = "SELECT h FROM HighSchoolCourse h")
public class HighSchoolCourse extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	private byte code;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

}