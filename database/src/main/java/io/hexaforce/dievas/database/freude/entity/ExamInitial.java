package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;
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
 * The persistent class for the exam_initial database table.
 * 
 */
@Entity
@Table(name = "exam_initial")
@NamedQuery(name = "ExamInitial.findAll", query = "SELECT e FROM ExamInitial e")
public class ExamInitial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "document_reception_limit")
	private Date documentReceptionLimit;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "entry_closed_at")
	private Date entryClosedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "entry_opened_at")
	private Date entryOpenedAt;

	@Column(name = "exam_id")
	private int examId;

	@Column(name = "payment_effective_days")
	private int paymentEffectiveDays;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "payment_limit")
	private Date paymentLimit;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "result_closed_at")
	private Date resultClosedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "result_opened_at")
	private Date resultOpenedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ticket_closed_at")
	private Date ticketClosedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ticket_opened_at")
	private Date ticketOpenedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public ExamInitial() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public Date getDocumentReceptionLimit() {
		return this.documentReceptionLimit;
	}

	public Date getEntryClosedAt() {
		return this.entryClosedAt;
	}

	public Date getEntryOpenedAt() {
		return this.entryOpenedAt;
	}

	public int getExamId() {
		return this.examId;
	}

	public int getId() {
		return this.id;
	}

	public int getPaymentEffectiveDays() {
		return this.paymentEffectiveDays;
	}

	public Date getPaymentLimit() {
		return this.paymentLimit;
	}

	public Date getResultClosedAt() {
		return this.resultClosedAt;
	}

	public Date getResultOpenedAt() {
		return this.resultOpenedAt;
	}

	public Date getTicketClosedAt() {
		return this.ticketClosedAt;
	}

	public Date getTicketOpenedAt() {
		return this.ticketOpenedAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDocumentReceptionLimit(Date documentReceptionLimit) {
		this.documentReceptionLimit = documentReceptionLimit;
	}

	public void setEntryClosedAt(Date entryClosedAt) {
		this.entryClosedAt = entryClosedAt;
	}

	public void setEntryOpenedAt(Date entryOpenedAt) {
		this.entryOpenedAt = entryOpenedAt;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPaymentEffectiveDays(int paymentEffectiveDays) {
		this.paymentEffectiveDays = paymentEffectiveDays;
	}

	public void setPaymentLimit(Date paymentLimit) {
		this.paymentLimit = paymentLimit;
	}

	public void setResultClosedAt(Date resultClosedAt) {
		this.resultClosedAt = resultClosedAt;
	}

	public void setResultOpenedAt(Date resultOpenedAt) {
		this.resultOpenedAt = resultOpenedAt;
	}

	public void setTicketClosedAt(Date ticketClosedAt) {
		this.ticketClosedAt = ticketClosedAt;
	}

	public void setTicketOpenedAt(Date ticketOpenedAt) {
		this.ticketOpenedAt = ticketOpenedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}