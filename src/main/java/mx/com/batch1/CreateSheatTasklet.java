package mx.com.batch1;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class CreateSheatTasklet implements Tasklet {
	
	private String filePath;
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setDateFile(String dateFile) {
		this.dateFile = dateFile;
	}

	private String dateFile;

	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
		System.out.println(filePath+" - "+dateFile);
		return RepeatStatus.FINISHED;
	}

}
