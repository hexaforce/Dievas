package io.hexaforce.dievas.database.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "owners")
public class Owner extends Person {

	/**
	 * 
	 */
	@Column(name = "address")
	@NotEmpty
	private String address;

	/**
	 * 
	 */
	@Column(name = "city")
	@NotEmpty
	private String city;

	/**
	 * 
	 */
	@Column(name = "telephone")
	@NotEmpty
	@Digits(fraction = 0, integer = 10)
	private String telephone;

	/**
	 * 
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets;

}
