package io.hexaforce.dievas.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * Jobのランチアップコントローラー
 * @author T.Tantaka <relics9@gmail.com>
 *
 */
@Slf4j
@Controller
public class BatchController implements ApplicationContextAware{
	
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private JobRegistry jobRegistry;

    @Autowired
    private JobRepository jobRepository;

    private ApplicationContext applicationContext;
    
	@ResponseBody
	@RequestMapping("/batch/{jobName}")
	public JobExecutionSummary batch(@PathVariable("jobName") String jobName, ModelMap modal) {
		log.info("/batch/"+jobName);
		
		// ジョブパラメータを作成
		JobParameters jobParameters = buildJobParameter(modal);
		
		JobExecution jobExecution = null;
		
		// 実行履歴を確認
		if (jobRepository.isJobInstanceExists(jobName, jobParameters)) {
			jobExecution = jobRepository.getLastJobExecution(jobName, jobParameters);
		} else {
			// Jobを実行
			try {
				Job job = findJob(jobName, jobParameters);
				jobExecution = jobLauncher.run(job, jobParameters);
			} catch (JobExecutionAlreadyRunningException | JobInstanceAlreadyCompleteException e) {
				jobExecution = jobRepository.getLastJobExecution(jobName, jobParameters);
			} catch (JobRestartException e) {
				e.printStackTrace();
			} catch (JobParametersInvalidException e) {
				e.printStackTrace();
			} catch (NoSuchJobException e) {
				e.printStackTrace();
			}
		}
		
		// 結果をリターン
		JobExecutionSummary jobResult = new JobExecutionSummary();
		BeanUtils.copyProperties(jobExecution, jobResult);
		return jobResult;
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	/**
	 * @param modal
	 * @return
	 */
	private JobParameters buildJobParameter(ModelMap modal) {
		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder()
				.addLong("time",System.currentTimeMillis());
		
		return jobParametersBuilder.toJobParameters();
	}

	/**
	 * @param jobName
	 * @param jobParameters
	 * @return
	 * @throws NoSuchJobException
	 */
	private Job findJob(String jobName, JobParameters jobParameters) throws NoSuchJobException {
		
		Job job = null;
		try {
			job = jobRegistry.getJob(jobName);
		} catch (NoSuchJobException e) {
			Object obj = applicationContext.getBean(jobName);
			if (obj == null) {
				throw e;
			} else {
				if (obj instanceof Job) {
					job = (Job) obj;
				} else {
					throw e;
				}
			}
		}
		return job;

	}
	
}
