package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the examinees_ticket database table.
 * 
 */
@Embeddable
public class ExamineesTicketPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "application_id")
	private int applicationId;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "examinees_number")
	private String examineesNumber;

	public ExamineesTicketPK() {
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ExamineesTicketPK)) {
			return false;
		}
		ExamineesTicketPK castOther = (ExamineesTicketPK) other;
		return (this.applicationId == castOther.applicationId) && (this.userId == castOther.userId)
				&& this.examineesNumber.equals(castOther.examineesNumber);
	}

	public int getApplicationId() {
		return this.applicationId;
	}

	public String getExamineesNumber() {
		return this.examineesNumber;
	}

	public int getUserId() {
		return this.userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.applicationId;
		hash = hash * prime + this.userId;
		hash = hash * prime + this.examineesNumber.hashCode();

		return hash;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public void setExamineesNumber(String examineesNumber) {
		this.examineesNumber = examineesNumber;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}