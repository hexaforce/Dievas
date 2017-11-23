package io.hexaforce.dievas.database.entity.exam;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.hexaforce.dievas.database.entity.application.Application;
import io.hexaforce.dievas.database.entity.application.ApplicationState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 試験カテゴリ
 * @author T.Tantaka <relics9@gmail.com>
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exam_category")
public class ExamCategory extends ExamBaseEntity {
	
	// 試験カテゴリID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "exam_category_id")
	private Integer examCategoryId;
	
}
