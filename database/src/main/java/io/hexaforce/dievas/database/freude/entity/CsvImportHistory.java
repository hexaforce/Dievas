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
@Table(name = "csv_import_history")
@NamedQuery(name = "CsvImportHistory.findAll", query = "SELECT c FROM CsvImportHistory c")
public class CsvImportHistory extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "csv_import_id")
	private int csvImportId;

	@Column(name = "file_key")
	private String fileKey;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "imported_at")
	private Date importedAt;

	private String location;

	@Column(name = "log_id")
	private int logId;

	@Column(name = "original_name")
	private String originalName;

	private byte status;

}