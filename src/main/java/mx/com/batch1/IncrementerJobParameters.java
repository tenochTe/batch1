package mx.com.batch1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

public class IncrementerJobParameters implements JobParametersIncrementer {
	
	
	@Override
	public JobParameters getNext(JobParameters parameters) {
		
		JobParametersBuilder jobParametersBuilder =new JobParametersBuilder();
			
		System.getenv()
		.entrySet()
			.forEach( c -> { 
				if ( "home".equals(c.getKey().toLowerCase()) 
						|| "userprofile".equals(c.getKey().toLowerCase()) ) {
					jobParametersBuilder.addString( "pathFile" , c.getValue().concat(File.separator).concat("fichTemp") );
				}
			});
		jobParametersBuilder.addString("dateFile", new SimpleDateFormat("dd-MM-yyy HH:ss").format(new Date()) );
		jobParametersBuilder.addString("userHome",System.getProperty("user.home") );
		
		parameters.getParameters().entrySet().forEach(c ->{
			jobParametersBuilder.addParameter(c.getKey().toString(), c.getValue());
		});
		
		
		return jobParametersBuilder.toJobParameters();
	}

}
