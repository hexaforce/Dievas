package io.hexaforce.dievas.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.BatchConfigurationException;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.MapJobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.hexaforce.dievas.batch.job.Batch1;

@SpringBootApplication
public class DievasBatchApplication {
	
	public static void main(String[] args) throws Exception {
		// System.exit is common for Batch applications since the exit code can be used to drive a workflow
		System.exit(SpringApplication.exit(SpringApplication.run(Batch1.class, args)));
	}
}
