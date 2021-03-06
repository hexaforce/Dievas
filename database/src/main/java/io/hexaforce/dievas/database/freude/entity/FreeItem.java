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
@Table(name = "free_item")
@NamedQuery(name = "FreeItem.findAll", query = "SELECT f FROM FreeItem f")
public class FreeItem extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "free_item_1")
	private String freeItem1;

	@Column(name = "free_item_10")
	private String freeItem10;

	@Column(name = "free_item_2")
	private String freeItem2;

	@Column(name = "free_item_3")
	private String freeItem3;

	@Column(name = "free_item_4")
	private String freeItem4;

	@Column(name = "free_item_5")
	private String freeItem5;

	@Column(name = "free_item_6")
	private String freeItem6;

	@Column(name = "free_item_7")
	private String freeItem7;

	@Column(name = "free_item_8")
	private String freeItem8;

	@Column(name = "free_item_9")
	private String freeItem9;

	@Column(name = "free_item_kbn")
	private String freeItemKbn;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


}