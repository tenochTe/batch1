package mx.com.batch1;

import java.io.File;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class ListenerJobExecution implements JobExecutionListener {
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		jobExecution.getStepExecutions().stream().forEach(System.out::println);

	}
	

	@Override
	public void beforeJob(JobExecution jobExecution) {		
		String dirPath = System.getProperty("user.home").concat(File.separator).concat("fichTemp");
		File dir =new File(dirPath);
		 
		if (!dir.exists() )
			 dir.mkdir();	
		
					
	}
	


}
