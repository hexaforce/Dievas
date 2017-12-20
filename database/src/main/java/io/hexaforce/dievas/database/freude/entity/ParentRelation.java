package io.hexaforce.dievas.database.freude.entity;

import javax.persistence.Column;
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
@Table(name = "parent_relation")
@NamedQuery(name = "ParentRelation.findAll", query = "SELECT p FROM ParentRelation p")
public class ParentRelation extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "display_order")
	private int displayOrder;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "parent_relation_code")
	private String parentRelationCode;

	@Column(name = "parent_relation_name")
	private String parentRelationName;

}