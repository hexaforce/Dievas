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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Exam.findAll", query = "SELECT e FROM Exam e")
public class Exam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "course_id")
	private Integer courseId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private Byte deleted;

	@Column(name = "department_id")
	private Integer departmentId;

	@Column(name = "division_id")
	private Integer divisionId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "document_reception_limit")
	private Date documentReceptionLimit;

	@Column(name = "early_decision")
	private Byte earlyDecision;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "entry_closed_at")
	private Date entryClosedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "entry_opened_at")
	private Date entryOpenedAt;

	@Column(name = "exam_date_id")
	private Integer examDateId;

	@Column(name = "exam_fee")
	private Integer examFee;

	@Column(name = "examination_ticket_template_name")
	private String examinationTicketTemplateName;

	@Column(name = "exam_prop_form_id")
	private Integer examPropFormId;

	@Column(name = "exam_type_id")
	private Integer examTypeId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "mailinglabel_template_name")
	private String mailinglabelTemplateName;

	private String name;

	@Column(name = "payment_effective_days")
	private Integer paymentEffectiveDays;

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

}