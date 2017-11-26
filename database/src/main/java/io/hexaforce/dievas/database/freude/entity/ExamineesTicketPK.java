package io.hexaforce.dievas.database.freude.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ExamineesTicketPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "application_id")
	private int applicationId;

	@Column(name = "examinees_number")
	private String examineesNumber;

	@Column(name = "user_id")
	private int userId;

}