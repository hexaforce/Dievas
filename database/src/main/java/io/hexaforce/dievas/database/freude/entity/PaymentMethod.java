package io.hexaforce.dievas.database.freude.entity;

import java.math.BigInteger;

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
@Table(name = "payment_method")
@NamedQuery(name = "PaymentMethod.findAll", query = "SELECT p FROM PaymentMethod p")
public class PaymentMethod extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	private BigInteger charge;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "max_amount")
	private BigInteger maxAmount;

	private String method;

	private String name;

}