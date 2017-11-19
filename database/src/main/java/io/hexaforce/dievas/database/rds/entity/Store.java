package io.hexaforce.dievas.database.rds.entity;

import java.util.Collection;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.hexaforce.dievas.database.rds.AbstractEntity;
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
@Table(name = "store")
public class Store extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "store_id")
	private Short storeId;

	@JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id")
	@OneToOne(optional = false)
	private Staff managerStaffId;

	@JoinColumn(name = "address_id", referencedColumnName = "address_id")
	@ManyToOne(optional = false)
	private Address addressId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "storeId")
	private Collection<Customer> customerCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "storeId")
	private Collection<Staff> staffCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "storeId")
	private Collection<Inventory> inventoryCollection;

}