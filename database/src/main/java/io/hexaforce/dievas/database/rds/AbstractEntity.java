package io.hexaforce.dievas.database.rds;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;
/**
 * @author T.Tantaka <tantaka.tomokazu@gmail.com>
 */
@Data
@MappedSuperclass
public class AbstractEntity implements Serializable {
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
}
