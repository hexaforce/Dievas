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
@Table(name = "batch_job_history")
@NamedQuery(name = "BatchJobHistory.findAll", query = "SELECT b FROM BatchJobHistory b")
public class BatchJobHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "batch_name")
	private String batchName;

	@Column(name = "batch_status_type")
	private byte batchStatusType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ended_at")
	private Date endedAt;

	@Column(name = "exam_category_id")
	private int examCategoryId;

	@Column(name = "failed_count")
	private int failedCount;

	@Column(name = "file_key")
	private String fileKey;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String location;

	@Column(name = "original_name")
	private String originalName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "received_at")
	private Date receivedAt;

	@Column(name = "received_operator_id")
	private int receivedOperatorId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "started_at")
	private Date startedAt;

	@Column(name = "success_count")
	private int successCount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

}