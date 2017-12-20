package io.hexaforce.dievas.database.freude.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import io.hexaforce.dievas.database.freude.BasicBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "page_message")
@NamedQuery(name = "PageMessage.findAll", query = "SELECT p FROM PageMessage p")
public class PageMessage extends BasicBaseEntity {
	private static final long serialVersionUID = 1L;

	@Lob
	private String description;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String lang;

	@Lob
	private String message;

	@Column(name = "message_no")
	private int messageNo;

	@Column(name = "page_code")
	private String pageCode;

}