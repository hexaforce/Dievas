package io.hexaforce.dievas.database.entity.application;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.hexaforce.dievas.database.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 出願
 * @author T.Tantaka <relics9@gmail.com>
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "application")
public class Application extends BaseEntity {
	
	// 出願ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "application_id")
	private Integer application_id;

	// 出願受験者ID
	@Column(name="user_id")
	private int userId;
	
	// 出願ステータス
	@Column(name="state")
	private ApplicationState state;
	
	
}
