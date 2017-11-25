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
 * The persistent class for the free_item database table.
 * 
 */
@Entity
@Table(name = "free_item")
@NamedQuery(name = "FreeItem.findAll", query = "SELECT f FROM FreeItem f")
public class FreeItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "free_item_1")
	private String freeItem1;

	@Column(name = "free_item_10")
	private String freeItem10;

	@Column(name = "free_item_2")
	private String freeItem2;

	@Column(name = "free_item_3")
	private String freeItem3;

	@Column(name = "free_item_4")
	private String freeItem4;

	@Column(name = "free_item_5")
	private String freeItem5;

	@Column(name = "free_item_6")
	private String freeItem6;

	@Column(name = "free_item_7")
	private String freeItem7;

	@Column(name = "free_item_8")
	private String freeItem8;

	@Column(name = "free_item_9")
	private String freeItem9;

	@Column(name = "free_item_kbn")
	private String freeItemKbn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public FreeItem() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public String getFreeItem1() {
		return this.freeItem1;
	}

	public String getFreeItem10() {
		return this.freeItem10;
	}

	public String getFreeItem2() {
		return this.freeItem2;
	}

	public String getFreeItem3() {
		return this.freeItem3;
	}

	public String getFreeItem4() {
		return this.freeItem4;
	}

	public String getFreeItem5() {
		return this.freeItem5;
	}

	public String getFreeItem6() {
		return this.freeItem6;
	}

	public String getFreeItem7() {
		return this.freeItem7;
	}

	public String getFreeItem8() {
		return this.freeItem8;
	}

	public String getFreeItem9() {
		return this.freeItem9;
	}

	public String getFreeItemKbn() {
		return this.freeItemKbn;
	}

	public int getId() {
		return this.id;
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

	public void setFreeItem1(String freeItem1) {
		this.freeItem1 = freeItem1;
	}

	public void setFreeItem10(String freeItem10) {
		this.freeItem10 = freeItem10;
	}

	public void setFreeItem2(String freeItem2) {
		this.freeItem2 = freeItem2;
	}

	public void setFreeItem3(String freeItem3) {
		this.freeItem3 = freeItem3;
	}

	public void setFreeItem4(String freeItem4) {
		this.freeItem4 = freeItem4;
	}

	public void setFreeItem5(String freeItem5) {
		this.freeItem5 = freeItem5;
	}

	public void setFreeItem6(String freeItem6) {
		this.freeItem6 = freeItem6;
	}

	public void setFreeItem7(String freeItem7) {
		this.freeItem7 = freeItem7;
	}

	public void setFreeItem8(String freeItem8) {
		this.freeItem8 = freeItem8;
	}

	public void setFreeItem9(String freeItem9) {
		this.freeItem9 = freeItem9;
	}

	public void setFreeItemKbn(String freeItemKbn) {
		this.freeItemKbn = freeItemKbn;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}