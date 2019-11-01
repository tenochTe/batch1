package mx.com.batch1;

import java.io.File;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import mx.com.batch1.utils.Constants;

public class ListenerJobExecution implements JobExecutionListener {
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		jobExecution.getStepExecutions().stream().forEach(System.out::println);
		
/**		
		Map<String, Object> item1 =new HashMap<>();
			item1.put("param1", "param1");
			item1.put("param2", "param2");
			item1.put("param3", "param3");
			item1.put("param4", "param4");
			item1.put("param5", "param5");			
		Map<String, Object> item2 =new HashMap<>();
			item1.put("param6", "param6");
			item1.put("param7", "param7");
			item1.put("param8", "param8");
			item1.put("param9", "param9");
			item1.put("param10", "param10");
		List<Map<String, Object>> listItems =new ArrayList<>();
			listItems.add(item1);
			listItems.add(item2);
		Map<String, Object>[] arrMap = listItems.stream().toArray(HashMap[]::new);
//		Map<String, Object>[] arrMap = listItems.stream().toArray(Map[]::new);		
		for ( Map<String, Object> map : arrMap) {
			map.entrySet().forEach(c -> System.out.println(c.getKey().concat(" - ").concat( (String)c.getValue() ) ));
		}
*/
		

	}
	

	@Override
	public void beforeJob(JobExecution jobExecution) {		
		System.getenv().entrySet().forEach(System.out::println);
		
		File dir =new File(Constants.HOME.getValue().concat(Constants.SEPARATOR.getValue()).concat(Constants.TMP_DIR.getValue()));
		 
		if (!dir.exists() )
			 dir.mkdir();	
					
	}
	


}
