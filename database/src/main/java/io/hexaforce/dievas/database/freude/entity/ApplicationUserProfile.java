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
@Table(name = "application_user_profile")
@NamedQuery(name = "ApplicationUserProfile.findAll", query = "SELECT a FROM ApplicationUserProfile a")
public class ApplicationUserProfile implements Serializable {
	private static final long serialVersionUID = 1L;

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
	private Byte cramSchoolNotificationConsented;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private Byte deleted;

	@Column(name = "disaster_victim_special_measures")
	private Byte disasterVictimSpecialMeasures;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "first_name_kana")
	private String firstNameKana;

	@Column(name = "first_name_roman")
	private String firstNameRoman;

	private Byte gender;

	@Column(name = "handicapped_person_code")
	private String handicappedPersonCode;

	@Column(name = "handicapped_person_special_measures")
	private Byte handicappedPersonSpecialMeasures;

	@Column(name = "high_school_branch_code")
	private Byte highSchoolBranchCode;

	@Column(name = "high_school_code")
	private String highSchoolCode;

	@Column(name = "high_school_course_code")
	private Byte highSchoolCourseCode;

	@Column(name = "high_school_graduated_year_month")
	private String highSchoolGraduatedYearMonth;

	@Column(name = "high_school_notification_consented")
	private Byte highSchoolNotificationConsented;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "last_name_kana")
	private String lastNameKana;

	@Column(name = "last_name_roman")
	private String lastNameRoman;

	@Column(name = "management_status")
	private String managementStatus;

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
	private Byte universityBelonged;

	@Column(name = "university_code")
	private String universityCode;

	@Column(name = "university_graduated_year_month")
	private String universityGraduatedYearMonth;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	private int version;

}