package batch;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


@WebListener
public class TopListener implements ServletContextListener {

	/*field*/
	private Scheduler scheduler;
	
	/* constructor */
    public TopListener() {
    	try {
    		scheduler = new StdSchedulerFactory().getScheduler();
    	} catch(Exception e){
    		e.printStackTrace();
    	}
    }
    /* method */
    public void contextDestroyed(ServletContextEvent sce)  {    // 톰캣에서 제거
       try {
    	   if(scheduler != null ) {
    		   scheduler.shutdown();
    	   }
       } catch(Exception e) {
    	   e.printStackTrace();
       }
    }
    public void contextInitialized(ServletContextEvent sce)  {   // 톰캣에 올라옴 
         try {
        	 // 1) Top3Job
        	 JobDetail job = JobBuilder.newJob(TopJob.class)
        			 		.withIdentity("job", "group")
        			 		.build();
        	 // 2) Trigger
        	 Trigger trigger = TriggerBuilder.newTrigger()
        			 		.withIdentity("trigger", "group")
        			 		.withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *"))
        			 		.build();
        	 // 3) scheduler에 job, trigger 등록
        	 scheduler.scheduleJob(job, trigger);
        	 // 4) scheduler실행 시작
        	 scheduler.start();
         } catch(Exception e) {
        	 e.printStackTrace();
         }
    }
	
}
