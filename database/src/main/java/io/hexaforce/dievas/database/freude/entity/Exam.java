package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the exam database table.
 * 
 */
@Entity
@NamedQuery(name = "Exam.findAll", query = "SELECT e FROM Exam e")
public class Exam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "course_id")
	private int courseId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "department_id")
	private int departmentId;

	@Column(name = "division_id")
	private int divisionId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "document_reception_limit")
	private Date documentReceptionLimit;

	@Column(name = "early_decision")
	private byte earlyDecision;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "entry_closed_at")
	private Date entryClosedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "entry_opened_at")
	private Date entryOpenedAt;

	@Column(name = "exam_date_id")
	private int examDateId;

	@Column(name = "exam_fee")
	private int examFee;

	@Column(name = "exam_prop_form_id")
	private int examPropFormId;

	@Column(name = "exam_type_id")
	private int examTypeId;

	@Column(name = "examination_ticket_template_name")
	private String examinationTicketTemplateName;

	@Column(name = "mailinglabel_template_name")
	private String mailinglabelTemplateName;

	private String name;

	@Column(name = "payment_effective_days")
	private int paymentEffectiveDays;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "payment_limit")
	private Date paymentLimit;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "record_closed_at")
	private Date recordClosedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "record_opened_at")
	private Date recordOpenedAt;

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

	public Exam() {
	}

	public int getCourseId() {
		return this.courseId;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public int getDivisionId() {
		return this.divisionId;
	}

	public Date getDocumentReceptionLimit() {
		return this.documentReceptionLimit;
	}

	public byte getEarlyDecision() {
		return this.earlyDecision;
	}

	public Date getEntryClosedAt() {
		return this.entryClosedAt;
	}

	public Date getEntryOpenedAt() {
		return this.entryOpenedAt;
	}

	public int getExamDateId() {
		return this.examDateId;
	}

	public int getExamFee() {
		return this.examFee;
	}

	public String getExaminationTicketTemplateName() {
		return this.examinationTicketTemplateName;
	}

	public int getExamPropFormId() {
		return this.examPropFormId;
	}

	public int getExamTypeId() {
		return this.examTypeId;
	}

	public int getId() {
		return this.id;
	}

	public String getMailinglabelTemplateName() {
		return this.mailinglabelTemplateName;
	}

	public String getName() {
		return this.name;
	}

	public int getPaymentEffectiveDays() {
		return this.paymentEffectiveDays;
	}

	public Date getPaymentLimit() {
		return this.paymentLimit;
	}

	public Date getRecordClosedAt() {
		return this.recordClosedAt;
	}

	public Date getRecordOpenedAt() {
		return this.recordOpenedAt;
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

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public void setDocumentReceptionLimit(Date documentReceptionLimit) {
		this.documentReceptionLimit = documentReceptionLimit;
	}

	public void setEarlyDecision(byte earlyDecision) {
		this.earlyDecision = earlyDecision;
	}

	public void setEntryClosedAt(Date entryClosedAt) {
		this.entryClosedAt = entryClosedAt;
	}

	public void setEntryOpenedAt(Date entryOpenedAt) {
		this.entryOpenedAt = entryOpenedAt;
	}

	public void setExamDateId(int examDateId) {
		this.examDateId = examDateId;
	}

	public void setExamFee(int examFee) {
		this.examFee = examFee;
	}

	public void setExaminationTicketTemplateName(String examinationTicketTemplateName) {
		this.examinationTicketTemplateName = examinationTicketTemplateName;
	}

	public void setExamPropFormId(int examPropFormId) {
		this.examPropFormId = examPropFormId;
	}

	public void setExamTypeId(int examTypeId) {
		this.examTypeId = examTypeId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMailinglabelTemplateName(String mailinglabelTemplateName) {
		this.mailinglabelTemplateName = mailinglabelTemplateName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPaymentEffectiveDays(int paymentEffectiveDays) {
		this.paymentEffectiveDays = paymentEffectiveDays;
	}

	public void setPaymentLimit(Date paymentLimit) {
		this.paymentLimit = paymentLimit;
	}

	public void setRecordClosedAt(Date recordClosedAt) {
		this.recordClosedAt = recordClosedAt;
	}

	public void setRecordOpenedAt(Date recordOpenedAt) {
		this.recordOpenedAt = recordOpenedAt;
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