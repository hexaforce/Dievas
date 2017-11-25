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
 * The persistent class for the postcode database table.
 * 
 */
@Entity
@NamedQuery(name = "Postcode.findAll", query = "SELECT p FROM Postcode p")
public class Postcode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	private String municipality;

	@Column(name = "municipality_kana")
	private String municipalityKana;

	private String postcode;

	@Column(name = "prefecture_code")
	private String prefectureCode;

	@Column(name = "town_area")
	private String townArea;

	@Column(name = "town_area_kana")
	private String townAreaKana;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	public Postcode() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public int getId() {
		return this.id;
	}

	public String getMunicipality() {
		return this.municipality;
	}

	public String getMunicipalityKana() {
		return this.municipalityKana;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public String getPrefectureCode() {
		return this.prefectureCode;
	}

	public String getTownArea() {
		return this.townArea;
	}

	public String getTownAreaKana() {
		return this.townAreaKana;
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

	public void setId(int id) {
		this.id = id;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public void setMunicipalityKana(String municipalityKana) {
		this.municipalityKana = municipalityKana;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setPrefectureCode(String prefectureCode) {
		this.prefectureCode = prefectureCode;
	}

	public void setTownArea(String townArea) {
		this.townArea = townArea;
	}

	public void setTownAreaKana(String townAreaKana) {
		this.townAreaKana = townAreaKana;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}