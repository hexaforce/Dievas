package io.hexaforce.dievas.database.rds.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
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
@Table(name = "rental")
public class Rental extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "rental_id")
	private Integer rentalId;

	@Basic(optional = false)
	@NotNull
	@Column(name = "rental_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date rentalDate;

	@Column(name = "return_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date returnDate;

	@OneToMany(mappedBy = "rentalId")
	private Collection<Payment> paymentCollection;

	@JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
	@ManyToOne(optional = false)
	private Staff staffId;

	@JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id")
	@ManyToOne(optional = false)
	private Inventory inventoryId;

	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	@ManyToOne(optional = false)
	private Customer customerId;

}