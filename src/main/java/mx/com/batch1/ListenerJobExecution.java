package mx.com.batch1;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class ListenerJobExecution implements JobExecutionListener {
	
	private String filePath;

	@Override
	public void afterJob(JobExecution jobExecution) {
		jobExecution
			.getStepExecutions()
				.stream()
					.forEach( c ->  
						System.out.println( "-> "+c.getStepName()+" - "+filePath )
					);
	}
	

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System
			.getenv()
				.entrySet()
					.forEach( c -> { 
						if ( "home".equals(c.getKey().toLowerCase()) 
								|| "userprofile".equals(c.getKey().toLowerCase()) ) {
							filePath = c.getValue();
						}
					});
	
		System.out.println(filePath);
			
	}

}
