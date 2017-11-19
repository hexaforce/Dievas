package io.hexaforce.dievas.database.rds.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventory")
public class Inventory implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "inventory_id")
	private Integer inventoryId;

	@Basic(optional = false)
	@NotNull
	@Column(name = "last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "inventoryId")
	private Collection<Rental> rentalCollection;

	@JoinColumn(name = "store_id", referencedColumnName = "store_id")
	@ManyToOne(optional = false)
	private Store storeId;

	@JoinColumn(name = "film_id", referencedColumnName = "film_id")
	@ManyToOne(optional = false)
	private Film filmId;

}