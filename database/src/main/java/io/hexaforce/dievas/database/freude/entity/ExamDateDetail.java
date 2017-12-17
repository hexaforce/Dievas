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
@Table(name = "exam_date_detail")
@NamedQuery(name = "ExamDateDetail.findAll", query = "SELECT e FROM ExamDateDetail e")
public class ExamDateDetail extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name = "exam_date")
	private Date examDate;

	@Column(name = "exam_date_id")
	private int examDateId;

	@Column(name = "external_code")
	private String externalCode;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

}