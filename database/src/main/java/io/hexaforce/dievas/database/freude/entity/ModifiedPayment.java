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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the modified_payment database table.
 * 
 */
@Entity
@Table(name = "modified_payment")
@NamedQuery(name = "ModifiedPayment.findAll", query = "SELECT m FROM ModifiedPayment m")
public class ModifiedPayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

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

	@Column(name = "history_id")
	private int historyId;

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

	@Column(name = "sej_haraikomi_no")
	private BigInteger sejHaraikomiNo;

	@Column(name = "sej_haraikomihyo_no")
	private String sejHaraikomihyoNo;

	@Column(name = "sej_haraikomihyo_url")
	private String sejHaraikomihyoUrl;

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

	public ModifiedPayment() {
	}

	public BigInteger getBillNo() {
		return this.billNo;
	}

	public BigInteger getBodyAmount() {
		return this.bodyAmount;
	}

	public int getCartId() {
		return this.cartId;
	}

	public BigInteger getCharge() {
		return this.charge;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public byte getExemptionReasonCode() {
		return this.exemptionReasonCode;
	}

	public int getHistoryId() {
		return this.historyId;
	}

	public int getId() {
		return this.id;
	}

	public BigInteger getOrderId() {
		return this.orderId;
	}

	public BigInteger getPaidAmount() {
		return this.paidAmount;
	}

	public Date getPaidAt() {
		return this.paidAt;
	}

	public Date getPaymentAt() {
		return this.paymentAt;
	}

	public int getPaymentId() {
		return this.paymentId;
	}

	public Date getPaymentLimitAt() {
		return this.paymentLimitAt;
	}

	public int getPaymentMethodId() {
		return this.paymentMethodId;
	}

	public String getSejHaraikomihyoNo() {
		return this.sejHaraikomihyoNo;
	}

	public String getSejHaraikomihyoUrl() {
		return this.sejHaraikomihyoUrl;
	}

	public BigInteger getSejHaraikomiNo() {
		return this.sejHaraikomiNo;
	}

	public BigInteger getTax() {
		return this.tax;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public String getWnConfNo() {
		return this.wnConfNo;
	}

	public String getWnKessaiNo() {
		return this.wnKessaiNo;
	}

	public String getWnKessaiUrl() {
		return this.wnKessaiUrl;
	}

	public String getWnSyunokikanNo() {
		return this.wnSyunokikanNo;
	}

	public void setBillNo(BigInteger billNo) {
		this.billNo = billNo;
	}

	public void setBodyAmount(BigInteger bodyAmount) {
		this.bodyAmount = bodyAmount;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public void setCharge(BigInteger charge) {
		this.charge = charge;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setExemptionReasonCode(byte exemptionReasonCode) {
		this.exemptionReasonCode = exemptionReasonCode;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOrderId(BigInteger orderId) {
		this.orderId = orderId;
	}

	public void setPaidAmount(BigInteger paidAmount) {
		this.paidAmount = paidAmount;
	}

	public void setPaidAt(Date paidAt) {
		this.paidAt = paidAt;
	}

	public void setPaymentAt(Date paymentAt) {
		this.paymentAt = paymentAt;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public void setPaymentLimitAt(Date paymentLimitAt) {
		this.paymentLimitAt = paymentLimitAt;
	}

	public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public void setSejHaraikomihyoNo(String sejHaraikomihyoNo) {
		this.sejHaraikomihyoNo = sejHaraikomihyoNo;
	}

	public void setSejHaraikomihyoUrl(String sejHaraikomihyoUrl) {
		this.sejHaraikomihyoUrl = sejHaraikomihyoUrl;
	}

	public void setSejHaraikomiNo(BigInteger sejHaraikomiNo) {
		this.sejHaraikomiNo = sejHaraikomiNo;
	}

	public void setTax(BigInteger tax) {
		this.tax = tax;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setWnConfNo(String wnConfNo) {
		this.wnConfNo = wnConfNo;
	}

	public void setWnKessaiNo(String wnKessaiNo) {
		this.wnKessaiNo = wnKessaiNo;
	}

	public void setWnKessaiUrl(String wnKessaiUrl) {
		this.wnKessaiUrl = wnKessaiUrl;
	}

	public void setWnSyunokikanNo(String wnSyunokikanNo) {
		this.wnSyunokikanNo = wnSyunokikanNo;
	}

}