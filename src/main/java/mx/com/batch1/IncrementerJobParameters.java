package mx.com.batch1;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

public class IncrementerJobParameters implements JobParametersIncrementer {
	
	
	@Override
	public JobParameters getNext(JobParameters parameters) {
		
		if ( parameters == null || parameters.isEmpty() ) {
			return new JobParametersBuilder().addLong("count.run", 1L).toJobParameters();
		}
		
		Long count = parameters.getLong("count.run") + 1;
		
		return new JobParametersBuilder().addLong("count.run", count).toJobParameters();
		
	}

}
