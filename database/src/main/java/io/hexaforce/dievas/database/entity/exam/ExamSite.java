package io.hexaforce.dievas.database.entity.exam;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 試験会場
 * @author T.Tantaka <relics9@gmail.com>
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exam_site")
public class ExamSite extends ExamBaseEntity {
	
	// 試験会場ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "exam_site_id")
	private Integer examSiteId;
	
}