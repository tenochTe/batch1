package mx.com.batch1;

import java.io.File;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import mx.com.batch1.utils.Constants;

public class ListenerJobExecution implements JobExecutionListener {
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		jobExecution.getStepExecutions().stream().forEach(System.out::println);
		
		
		jobExecution.getStepExecutions().stream().forEach(c -> {
			if ( c.getStepName().contains("2") ) {
					System.out.println( "##########>: "+c.getJobExecution()  );
			}
		});
	}
	

	@Override
	public void beforeJob(JobExecution jobExecution) {		
		System.getenv().entrySet().forEach(System.out::println);
		
		File dir =new File(Constants.HOME.getValue().concat(Constants.SEPARATOR.getValue()).concat(Constants.TMP_DIR.getValue()));
		 
		if (!dir.exists() )
			 dir.mkdir();	
					
	}
	


}
