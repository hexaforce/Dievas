package io.hexaforce.dievas.database.rds.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "sales_by_store")
public class SalesByStore implements Serializable {

	@Id
	@Size(max = 101)
	@Column(name = "store")
	private String store;

	@Size(max = 91)
	@Column(name = "manager")
	private String manager;

	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "total_sales")
	private BigDecimal totalSales;

}