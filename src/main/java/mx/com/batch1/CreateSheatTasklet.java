package mx.com.batch1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import mx.com.batch1.model.Account;
import mx.com.batch1.utils.Constants;

public class CreateSheatTasklet implements Tasklet {
	
	private String filePath;

	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception, IOException {
		System.out.println("jobParameter from Launcher: "+filePath);
		
		FileOutputStream fos 
			=new FileOutputStream( Constants.HOME.getValue()
									.concat(Constants.SEPARATOR.getValue() )
									.concat(Constants.TMP_DIR.getValue() )
									.concat(Constants.SEPARATOR.getValue() )
									.concat("test_file_")
									.concat(new SimpleDateFormat("dd-MM-yy").format(new Date()))
									.concat(".csv")
								 );
		
		
		for ( int x = 0; x < 1_000; x++ ) {
			Account o =new Account();
				o.setCustomer( String.valueOf( (int) ( Math.random() * ( (1000 - 0) + 1 ) ) ) );
				o.setAccount(String.valueOf( (int) ( Math.random() * ( (100_000 - 50_000) +1 ) ) + 50_000 ) );
				o.setIsActive( "Y" );
				
				byte[] stringBytes = "\n".concat(o.toString()).getBytes();
				fos.write(stringBytes);
		}
		
		fos.flush();
		fos.close();
		
		chunkContext.getStepContext().getStepExecution().getJobParameters();
		
		 
		return RepeatStatus.CONTINUABLE;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
