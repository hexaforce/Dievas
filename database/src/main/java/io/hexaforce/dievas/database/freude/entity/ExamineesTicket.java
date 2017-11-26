package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "examinees_ticket")
@NamedQuery(name = "ExamineesTicket.findAll", query = "SELECT e FROM ExamineesTicket e")
public class ExamineesTicket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@EmbeddedId
	private ExamineesTicketPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "notice_send_date")
	private Date noticeSendDate;

	@Column(name = "notice_success")
	private byte noticeSuccess;

	@Column(name = "ticket_issue")
	private byte ticketIssue;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ticket_issue_date")
	private Date ticketIssueDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

}