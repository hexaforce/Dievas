package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "bill_no")
	private BigInteger billNo;

	@Column(name = "body_amount")
	private BigInteger bodyAmount;

	@Column(name = "cart_id")
	private int cartId;

	private BigInteger charge;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "exemption_reason_code")
	private byte exemptionReasonCode;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "order_id")
	private BigInteger orderId;

	@Column(name = "paid_amount")
	private BigInteger paidAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "paid_at")
	private Date paidAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "payment_at")
	private Date paymentAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "payment_limit_at")
	private Date paymentLimitAt;

	@Column(name = "payment_method_id")
	private int paymentMethodId;

	@Column(name = "sej_haraikomihyo_no")
	private String sejHaraikomihyoNo;

	@Column(name = "sej_haraikomihyo_url")
	private String sejHaraikomihyoUrl;

	@Column(name = "sej_haraikomi_no")
	private BigInteger sejHaraikomiNo;

	private BigInteger tax;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "wn_conf_no")
	private String wnConfNo;

	@Column(name = "wn_kessai_no")
	private String wnKessaiNo;

	@Column(name = "wn_kessai_url")
	private String wnKessaiUrl;

	@Column(name = "wn_syunokikan_no")
	private String wnSyunokikanNo;

}