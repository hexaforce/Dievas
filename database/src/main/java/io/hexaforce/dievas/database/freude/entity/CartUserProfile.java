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
 * The persistent class for the cart_user_profile database table.
 * 
 */
@Entity
@Table(name = "cart_user_profile")
@NamedQuery(name = "CartUserProfile.findAll", query = "SELECT c FROM CartUserProfile c")
public class CartUserProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "accident_code")
	private String accidentCode;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private String building;

	@Column(name = "building_kana")
	private String buildingKana;

	@Column(name = "care_of_address")
	private String careOfAddress;

	@Column(name = "care_of_address_kana")
	private String careOfAddressKana;

	@Column(name = "cart_id")
	private int cartId;

	@Column(name = "center_score_request_number")
	private String centerScoreRequestNumber;

	@Column(name = "country_code")
	private String countryCode;

	@Column(name = "cram_school_code")
	private String cramSchoolCode;

	@Column(name = "cram_school_notification_consented")
	private byte cramSchoolNotificationConsented;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private byte deleted;

	@Column(name = "disaster_victim_special_measures")
	private byte disasterVictimSpecialMeasures;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "first_name_kana")
	private String firstNameKana;

	@Column(name = "first_name_roman")
	private String firstNameRoman;

	private byte gender;

	@Column(name = "handicapped_person_code")
	private String handicappedPersonCode;

	@Column(name = "handicapped_person_special_measures")
	private byte handicappedPersonSpecialMeasures;

	@Column(name = "high_school_branch_code")
	private byte highSchoolBranchCode;

	@Column(name = "high_school_code")
	private String highSchoolCode;

	@Column(name = "high_school_course_code")
	private byte highSchoolCourseCode;

	@Column(name = "high_school_graduated_year_month")
	private String highSchoolGraduatedYearMonth;

	@Column(name = "high_school_notification_consented")
	private byte highSchoolNotificationConsented;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "last_name_kana")
	private String lastNameKana;

	@Column(name = "last_name_roman")
	private String lastNameRoman;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "mobile_phone")
	private String mobilePhone;

	private String municipality;

	@Column(name = "municipality_kana")
	private String municipalityKana;

	@Column(name = "parent_building")
	private String parentBuilding;

	@Column(name = "parent_building_kana")
	private String parentBuildingKana;

	@Column(name = "parent_care_of_address")
	private String parentCareOfAddress;

	@Column(name = "parent_care_of_address_kana")
	private String parentCareOfAddressKana;

	@Column(name = "parent_first_name")
	private String parentFirstName;

	@Column(name = "parent_first_name_kana")
	private String parentFirstNameKana;

	@Column(name = "parent_first_name_roman")
	private String parentFirstNameRoman;

	@Column(name = "parent_last_name")
	private String parentLastName;

	@Column(name = "parent_last_name_kana")
	private String parentLastNameKana;

	@Column(name = "parent_last_name_roman")
	private String parentLastNameRoman;

	@Column(name = "parent_mobile_phone")
	private String parentMobilePhone;

	@Column(name = "parent_municipality")
	private String parentMunicipality;

	@Column(name = "parent_municipality_kana")
	private String parentMunicipalityKana;

	@Column(name = "parent_phone")
	private String parentPhone;

	@Column(name = "parent_postcode")
	private String parentPostcode;

	@Column(name = "parent_prefecture_code")
	private String parentPrefectureCode;

	@Column(name = "parent_relation")
	private String parentRelation;

	@Column(name = "parent_town_area")
	private String parentTownArea;

	@Column(name = "parent_town_area_kana")
	private String parentTownAreaKana;

	private String phone;

	@Column(name = "portrait_file_name")
	private String portraitFileName;

	private String postcode;

	private String prefecture;

	@Column(name = "prefecture_code")
	private String prefectureCode;

	@Column(name = "town_area")
	private String townArea;

	@Column(name = "town_area_kana")
	private String townAreaKana;

	@Column(name = "university_belonged")
	private byte universityBelonged;

	@Column(name = "university_code")
	private String universityCode;

	@Column(name = "university_graduated_year_month")
	private String universityGraduatedYearMonth;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	private int version;

	public CartUserProfile() {
	}

	public String getAccidentCode() {
		return this.accidentCode;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public String getBuilding() {
		return this.building;
	}

	public String getBuildingKana() {
		return this.buildingKana;
	}

	public String getCareOfAddress() {
		return this.careOfAddress;
	}

	public String getCareOfAddressKana() {
		return this.careOfAddressKana;
	}

	public int getCartId() {
		return this.cartId;
	}

	public String getCenterScoreRequestNumber() {
		return this.centerScoreRequestNumber;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public String getCramSchoolCode() {
		return this.cramSchoolCode;
	}

	public byte getCramSchoolNotificationConsented() {
		return this.cramSchoolNotificationConsented;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public byte getDisasterVictimSpecialMeasures() {
		return this.disasterVictimSpecialMeasures;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getFirstNameKana() {
		return this.firstNameKana;
	}

	public String getFirstNameRoman() {
		return this.firstNameRoman;
	}

	public byte getGender() {
		return this.gender;
	}

	public String getHandicappedPersonCode() {
		return this.handicappedPersonCode;
	}

	public byte getHandicappedPersonSpecialMeasures() {
		return this.handicappedPersonSpecialMeasures;
	}

	public byte getHighSchoolBranchCode() {
		return this.highSchoolBranchCode;
	}

	public String getHighSchoolCode() {
		return this.highSchoolCode;
	}

	public byte getHighSchoolCourseCode() {
		return this.highSchoolCourseCode;
	}

	public String getHighSchoolGraduatedYearMonth() {
		return this.highSchoolGraduatedYearMonth;
	}

	public byte getHighSchoolNotificationConsented() {
		return this.highSchoolNotificationConsented;
	}

	public int getId() {
		return this.id;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getLastNameKana() {
		return this.lastNameKana;
	}

	public String getLastNameRoman() {
		return this.lastNameRoman;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public String getMunicipality() {
		return this.municipality;
	}

	public String getMunicipalityKana() {
		return this.municipalityKana;
	}

	public String getParentBuilding() {
		return this.parentBuilding;
	}

	public String getParentBuildingKana() {
		return this.parentBuildingKana;
	}

	public String getParentCareOfAddress() {
		return this.parentCareOfAddress;
	}

	public String getParentCareOfAddressKana() {
		return this.parentCareOfAddressKana;
	}

	public String getParentFirstName() {
		return this.parentFirstName;
	}

	public String getParentFirstNameKana() {
		return this.parentFirstNameKana;
	}

	public String getParentFirstNameRoman() {
		return this.parentFirstNameRoman;
	}

	public String getParentLastName() {
		return this.parentLastName;
	}

	public String getParentLastNameKana() {
		return this.parentLastNameKana;
	}

	public String getParentLastNameRoman() {
		return this.parentLastNameRoman;
	}

	public String getParentMobilePhone() {
		return this.parentMobilePhone;
	}

	public String getParentMunicipality() {
		return this.parentMunicipality;
	}

	public String getParentMunicipalityKana() {
		return this.parentMunicipalityKana;
	}

	public String getParentPhone() {
		return this.parentPhone;
	}

	public String getParentPostcode() {
		return this.parentPostcode;
	}

	public String getParentPrefectureCode() {
		return this.parentPrefectureCode;
	}

	public String getParentRelation() {
		return this.parentRelation;
	}

	public String getParentTownArea() {
		return this.parentTownArea;
	}

	public String getParentTownAreaKana() {
		return this.parentTownAreaKana;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getPortraitFileName() {
		return this.portraitFileName;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public String getPrefecture() {
		return this.prefecture;
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

	public byte getUniversityBelonged() {
		return this.universityBelonged;
	}

	public String getUniversityCode() {
		return this.universityCode;
	}

	public String getUniversityGraduatedYearMonth() {
		return this.universityGraduatedYearMonth;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public int getVersion() {
		return this.version;
	}

	public void setAccidentCode(String accidentCode) {
		this.accidentCode = accidentCode;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public void setBuildingKana(String buildingKana) {
		this.buildingKana = buildingKana;
	}

	public void setCareOfAddress(String careOfAddress) {
		this.careOfAddress = careOfAddress;
	}

	public void setCareOfAddressKana(String careOfAddressKana) {
		this.careOfAddressKana = careOfAddressKana;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public void setCenterScoreRequestNumber(String centerScoreRequestNumber) {
		this.centerScoreRequestNumber = centerScoreRequestNumber;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setCramSchoolCode(String cramSchoolCode) {
		this.cramSchoolCode = cramSchoolCode;
	}

	public void setCramSchoolNotificationConsented(byte cramSchoolNotificationConsented) {
		this.cramSchoolNotificationConsented = cramSchoolNotificationConsented;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public void setDisasterVictimSpecialMeasures(byte disasterVictimSpecialMeasures) {
		this.disasterVictimSpecialMeasures = disasterVictimSpecialMeasures;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public void setFirstNameRoman(String firstNameRoman) {
		this.firstNameRoman = firstNameRoman;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public void setHandicappedPersonCode(String handicappedPersonCode) {
		this.handicappedPersonCode = handicappedPersonCode;
	}

	public void setHandicappedPersonSpecialMeasures(byte handicappedPersonSpecialMeasures) {
		this.handicappedPersonSpecialMeasures = handicappedPersonSpecialMeasures;
	}

	public void setHighSchoolBranchCode(byte highSchoolBranchCode) {
		this.highSchoolBranchCode = highSchoolBranchCode;
	}

	public void setHighSchoolCode(String highSchoolCode) {
		this.highSchoolCode = highSchoolCode;
	}

	public void setHighSchoolCourseCode(byte highSchoolCourseCode) {
		this.highSchoolCourseCode = highSchoolCourseCode;
	}

	public void setHighSchoolGraduatedYearMonth(String highSchoolGraduatedYearMonth) {
		this.highSchoolGraduatedYearMonth = highSchoolGraduatedYearMonth;
	}

	public void setHighSchoolNotificationConsented(byte highSchoolNotificationConsented) {
		this.highSchoolNotificationConsented = highSchoolNotificationConsented;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}

	public void setLastNameRoman(String lastNameRoman) {
		this.lastNameRoman = lastNameRoman;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public void setMunicipalityKana(String municipalityKana) {
		this.municipalityKana = municipalityKana;
	}

	public void setParentBuilding(String parentBuilding) {
		this.parentBuilding = parentBuilding;
	}

	public void setParentBuildingKana(String parentBuildingKana) {
		this.parentBuildingKana = parentBuildingKana;
	}

	public void setParentCareOfAddress(String parentCareOfAddress) {
		this.parentCareOfAddress = parentCareOfAddress;
	}

	public void setParentCareOfAddressKana(String parentCareOfAddressKana) {
		this.parentCareOfAddressKana = parentCareOfAddressKana;
	}

	public void setParentFirstName(String parentFirstName) {
		this.parentFirstName = parentFirstName;
	}

	public void setParentFirstNameKana(String parentFirstNameKana) {
		this.parentFirstNameKana = parentFirstNameKana;
	}

	public void setParentFirstNameRoman(String parentFirstNameRoman) {
		this.parentFirstNameRoman = parentFirstNameRoman;
	}

	public void setParentLastName(String parentLastName) {
		this.parentLastName = parentLastName;
	}

	public void setParentLastNameKana(String parentLastNameKana) {
		this.parentLastNameKana = parentLastNameKana;
	}

	public void setParentLastNameRoman(String parentLastNameRoman) {
		this.parentLastNameRoman = parentLastNameRoman;
	}

	public void setParentMobilePhone(String parentMobilePhone) {
		this.parentMobilePhone = parentMobilePhone;
	}

	public void setParentMunicipality(String parentMunicipality) {
		this.parentMunicipality = parentMunicipality;
	}

	public void setParentMunicipalityKana(String parentMunicipalityKana) {
		this.parentMunicipalityKana = parentMunicipalityKana;
	}

	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}

	public void setParentPostcode(String parentPostcode) {
		this.parentPostcode = parentPostcode;
	}

	public void setParentPrefectureCode(String parentPrefectureCode) {
		this.parentPrefectureCode = parentPrefectureCode;
	}

	public void setParentRelation(String parentRelation) {
		this.parentRelation = parentRelation;
	}

	public void setParentTownArea(String parentTownArea) {
		this.parentTownArea = parentTownArea;
	}

	public void setParentTownAreaKana(String parentTownAreaKana) {
		this.parentTownAreaKana = parentTownAreaKana;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPortraitFileName(String portraitFileName) {
		this.portraitFileName = portraitFileName;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
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

	public void setUniversityBelonged(byte universityBelonged) {
		this.universityBelonged = universityBelonged;
	}

	public void setUniversityCode(String universityCode) {
		this.universityCode = universityCode;
	}

	public void setUniversityGraduatedYearMonth(String universityGraduatedYearMonth) {
		this.universityGraduatedYearMonth = universityGraduatedYearMonth;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}