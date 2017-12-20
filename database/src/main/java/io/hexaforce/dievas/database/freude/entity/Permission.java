package io.hexaforce.dievas.database.freude.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import io.hexaforce.dievas.database.freude.BasicBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p")
public class Permission extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	private String description;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;


}