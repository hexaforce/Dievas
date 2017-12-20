package io.hexaforce.dievas.database.freude.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "payment_log")
@NamedQuery(name = "PaymentLog.findAll", query = "SELECT p FROM PaymentLog p")
public class PaymentLog extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "payment_id")
	private int paymentId;

	@Column(name = "payment_kind")
	private byte paymentKind;

	@Lob
	private String req;

	@Lob
	private String res;


}