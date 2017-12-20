package io.hexaforce.dievas.database.freude.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "batch_job_condition")
@NamedQuery(name = "BatchJobCondition.findAll", query = "SELECT b FROM BatchJobCondition b")
public class BatchJobCondition extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "batch_job_history_id")
	private int batchJobHistoryId;

	@Lob
	@Column(name = "display_text")
	private String displayText;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Lob
	private String name;

	@Lob
	private String value;

}