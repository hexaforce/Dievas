package io.hexaforce.dievas.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.hexaforce.dievas.batch.job.Batch1;

@SpringBootApplication
public class DievasBatchApplication {
	
	public static void main(String[] args) throws Exception {
		// System.exit is common for Batch applications since the exit code can be used to drive a workflow
		System.exit(SpringApplication.exit(SpringApplication.run(Batch1.class, args)));
	}
	
}
