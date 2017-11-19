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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "staff")
public class Staff extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "staff_id")
	private Short staffId;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "first_name")
	private String firstName;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "last_name")
	private String lastName;

	@Lob
	@Column(name = "picture")
	private byte[] picture;

	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	// message="Invalid email")//if the field contains email address consider using
	// this annotation to enforce field validation
	@Size(max = 50)
	@Column(name = "email")
	private String email;

	@Basic(optional = false)
	@NotNull
	@Column(name = "active")
	private boolean active;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 16)
	@Column(name = "username")
	private String username;

	@Size(max = 40)
	@Column(name = "password")
	private String password;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "managerStaffId")
	private Store store;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "staffId")
	private Collection<Payment> paymentCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "staffId")
	private Collection<Rental> rentalCollection;

	@JoinColumn(name = "store_id", referencedColumnName = "store_id")
	@ManyToOne(optional = false)
	private Store storeId;

	@JoinColumn(name = "address_id", referencedColumnName = "address_id")
	@ManyToOne(optional = false)
	private Address addressId;

}