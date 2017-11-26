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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exam_initial")
@NamedQuery(name = "ExamInitial.findAll", query = "SELECT e FROM ExamInitial e")
public class ExamInitial implements Serializable {
	private static final long serialVersionUID = 1L;

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

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

}