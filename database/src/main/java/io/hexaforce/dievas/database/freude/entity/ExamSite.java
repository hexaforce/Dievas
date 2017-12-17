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
@Table(name = "exam_site")
@NamedQuery(name = "ExamSite.findAll", query = "SELECT e FROM ExamSite e")
public class ExamSite extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "capacity_count")
	private int capacityCount;

	@Column(name = "commuted_place_id_to")
	private int commutedPlaceIdTo;

	@Column(name = "entry_stopped")
	private byte entryStopped;

	@Column(name = "exam_id")
	private int examId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "site_id")
	private int siteId;

	@Column(name = "threshold_count")
	private int thresholdCount;

}