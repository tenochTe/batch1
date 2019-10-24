package mx.com.batch1;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class ListenerJobExecution implements JobExecutionListener {

	@Override
	public void afterJob(JobExecution arg0) {
		System.out.println("#####> Hello AFTER");

	}

	@Override
	public void beforeJob(JobExecution arg0) {
		System.out.println("#####> Hello BEFORE");
	}

}
