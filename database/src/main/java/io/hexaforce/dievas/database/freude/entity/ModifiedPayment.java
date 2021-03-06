package io.hexaforce.dievas.database.freude.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.hexaforce.dievas.database.freude.BasicBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "modified_payment")
@NamedQuery(name = "ModifiedPayment.findAll", query = "SELECT m FROM ModifiedPayment m")
public class ModifiedPayment extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "bill_no")
	private BigInteger billNo;

	@Column(name = "body_amount")
	private BigInteger bodyAmount;

	@Column(name = "cart_id")
	private int cartId;

	private BigInteger charge;

	@Column(name = "exemption_reason_code")
	private byte exemptionReasonCode;

	@Column(name = "history_id")
	private int historyId;

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

	@Column(name = "payment_id")
	private int paymentId;

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

	@Column(name = "wn_conf_no")
	private String wnConfNo;

	@Column(name = "wn_kessai_no")
	private String wnKessaiNo;

	@Column(name = "wn_kessai_url")
	private String wnKessaiUrl;

	@Column(name = "wn_syunokikan_no")
	private String wnSyunokikanNo;

}