package io.hexaforce.dievas.batch;

import java.util.Date;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;

import lombok.Data;

@Data
public class JobExecutionSummary {
	private JobParameters jobParameters;
	private String jobConfigurationName;
	private  Date startTime;
	private  Date createTime;
	private BatchStatus status;
	private  Date endTime;
	private  Date lastUpdated;
	private ExitStatus exitStatus;
	private JobInstance jobInstance;
}
