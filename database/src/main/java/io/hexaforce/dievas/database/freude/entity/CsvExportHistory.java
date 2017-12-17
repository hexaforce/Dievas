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
@Table(name = "csv_export_history")
@NamedQuery(name = "CsvExportHistory.findAll", query = "SELECT c FROM CsvExportHistory c")
public class CsvExportHistory extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "csv_export_id")
	private int csvExportId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "exported_at")
	private Date exportedAt;

	@Column(name = "file_key")
	private String fileKey;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String location;

	@Column(name = "original_name")
	private String originalName;

}