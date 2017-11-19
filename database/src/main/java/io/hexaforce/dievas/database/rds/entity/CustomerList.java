package io.hexaforce.dievas.database.rds.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Table(name = "customer_list")
public class CustomerList implements Serializable {

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID")
	private short id;

	@Size(max = 91)
	@Column(name = "name")
	private String name;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "address")
	private String address;

	@Size(max = 10)
	@Column(name = "zip code")
	private String zipCode;

	// @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
	// message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field
	// contains phone or fax number consider using this annotation to enforce field
	// validation
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "phone")
	private String phone;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "city")
	private String city;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "country")
	private String country;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 6)
	@Column(name = "notes")
	private String notes;

	@Basic(optional = false)
	@NotNull
	@Column(name = "SID")
	private short sid;

}