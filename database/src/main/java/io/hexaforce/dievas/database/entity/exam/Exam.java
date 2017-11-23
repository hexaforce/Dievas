package io.hexaforce.dievas.database.entity.exam;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.hexaforce.dievas.database.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 試験マスタ
 * @author T.Tantaka <relics9@gmail.com>
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exam")
public class Exam extends BaseEntity {
	
	// 試験マスタID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "exam_id")
	private Integer examId;
	
	// 出願開始日時
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="entry_opened_at")
	private Date entryOpenedAt;
	
	// 出願終了日時
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="entry_closed_at")
	private Date entryClosedAt;

	// オンライン受験票公開開始日
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ticket_opened_at")
	private Date ticketOpenedAt;
	
	// オンライン受験票公開終了日
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ticket_closed_at")
	private Date ticketClosedAt;
	
	// 合否結果公開開始日
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="result_opened_at")
	private Date resultOpenedAt;
	
	// 合否結果公開終了日
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="result_closed_at")
	private Date resultClosedAt;
	
	// 成績照会の公開開始日
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="record_opened_at")
	private Date recordOpenedAt;
	
	// 成績照会の公開終了日
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="record_closed_at")
	private Date recordClosedAt;
	
	// 支払有効日数
	@Column(name="payment_effective_days")
	private Short paymentEffectiveDays;
	
	// 支払い期限日時
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="payment_limit")
	private Date paymentLimit;
	
	// 試験カテゴリID
	@Basic(optional = false)
	@Column(name = "exam_category_id")
	private Integer examCategoryId;

	// 試験種別ID
	@Basic(optional = false)
	@Column(name = "exam_type_id")
	private Integer examTypeId;
	
	// 試験日程ID
	@Basic(optional = false)
	@Column(name = "exam_date_id")
	private Integer examDateId;

	// 試験会場ID
	@Basic(optional = false)
	@Column(name = "exam_site_id")
	private Integer examSiteId;
	
	// 試験学部ID
	@Basic(optional = false)
	@Column(name = "exam_department_id")
	private Integer examDepartmentId;
	
	// 試験学科ID
	@Basic(optional = false)
	@Column(name = "exam_division_id")
	private Integer examDivisionId;
	
	// 試験コースID
	@Basic(optional = false)
	@Column(name = "exam_course_id")
	private Integer examCourseId;

	// 試験実技ID
	@Basic(optional = false)
	@Column(name = "exam_skill_id")
	private Integer examSkillId;
	
}