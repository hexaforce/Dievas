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

/**
 * The persistent class for the examinees_ticket database table.
 * 
 */
@Entity
@Table(name = "examinees_ticket")
@NamedQuery(name = "ExamineesTicket.findAll", query = "SELECT e FROM ExamineesTicket e")
public class ExamineesTicket implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ExamineesTicketPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

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

	public ExamineesTicket() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public ExamineesTicketPK getId() {
		return this.id;
	}

	public Date getNoticeSendDate() {
		return this.noticeSendDate;
	}

	public byte getNoticeSuccess() {
		return this.noticeSuccess;
	}

	public byte getTicketIssue() {
		return this.ticketIssue;
	}

	public Date getTicketIssueDate() {
		return this.ticketIssueDate;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setId(ExamineesTicketPK id) {
		this.id = id;
	}

	public void setNoticeSendDate(Date noticeSendDate) {
		this.noticeSendDate = noticeSendDate;
	}

	public void setNoticeSuccess(byte noticeSuccess) {
		this.noticeSuccess = noticeSuccess;
	}

	public void setTicketIssue(byte ticketIssue) {
		this.ticketIssue = ticketIssue;
	}

	public void setTicketIssueDate(Date ticketIssueDate) {
		this.ticketIssueDate = ticketIssueDate;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}