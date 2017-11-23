package io.hexaforce.dievas.database.entity.exam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@MappedSuperclass
public class ExamBaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// 作成日時
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;
	
	// 更新日時
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;
	
	// 論理削除
	@Column(name="deleted")
	private Boolean deleted;
	
	// 表示順
	@Column(name="display_index")
	private Integer displayIndex;
	
	// 外部システム連携コード
	@Column(name="external_code")
	private String externalCode;
	
	// 名称
	@Column(name="name")
	private String name;
	
}
