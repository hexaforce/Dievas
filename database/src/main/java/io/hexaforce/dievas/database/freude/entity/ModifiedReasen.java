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
@Table(name = "modified_reasen")
@NamedQuery(name = "ModifiedReasen.findAll", query = "SELECT m FROM ModifiedReasen m")
public class ModifiedReasen extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "history_id")
	private int historyId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Lob
	@Column(name = "modified_reasen")
	private String modifiedReasen;

	@Column(name = "modified_term_name")
	private String modifiedTermName;

}