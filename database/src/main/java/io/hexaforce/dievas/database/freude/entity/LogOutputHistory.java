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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "log_output_history")
@NamedQuery(name = "LogOutputHistory.findAll", query = "SELECT l FROM LogOutputHistory l")
public class LogOutputHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "approve_or_refuse")
	private int approveOrRefuse;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "file_key")
	private String fileKey;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String location;

	@Column(name = "log_output_id")
	private int logOutputId;

	@Column(name = "original_name")
	private String originalName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "output_at")
	private Date outputAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

}