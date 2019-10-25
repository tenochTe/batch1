package mx.com.batch1;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class HelloWorldTasklet implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
		
		chunkContext.getStepContext().getStepExecution().getExecutionContext().entrySet().forEach(System.out::println);
		
		System.out.println( chunkContext.getStepContext().getJobExecutionContext().size() );
	
		
		
		return RepeatStatus.FINISHED;
	}

}
