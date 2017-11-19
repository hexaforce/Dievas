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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Table(name = "address")
public class Address extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "address_id")
	private Short addressId;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "address")
	private String address;

	@Size(max = 50)
	@Column(name = "address2")
	private String address2;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "district")
	private String district;

	@Size(max = 10)
	@Column(name = "postal_code")
	private String postalCode;

	// @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
	// message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field
	// contains phone or fax number consider using this annotation to enforce field
	// validation
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "phone")
	private String phone;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
	private Collection<Store> storeCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
	private Collection<Customer> customerCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
	private Collection<Staff> staffCollection;

	@JoinColumn(name = "city_id", referencedColumnName = "city_id")
	@ManyToOne(optional = false)
	private City cityId;

}