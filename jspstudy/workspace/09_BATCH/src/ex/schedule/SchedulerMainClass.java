package ex.schedule;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerMainClass {

	public static void main(String[] args) {
		try {
			
			// Scheduler 생성 
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			
			// Scheduler 객체 실행 시작 
			scheduler.start();
			 // thread 와 같은 개념으로 메인이 끝나도 스케줄은 계속 진행된다.
			
			// scheduler 객체가 처리할 HelloJob 생성(builder 패턴은 코드가 길기 때문에 줄나눔 )
			JobDetail job = JobBuilder.newJob(HelloJob.class)
							.withIdentity("job1", "group1")
							.build();
			
			// scheduler 객체의 실제 스케쥴 동작 시점 생성 
			Trigger trigger = TriggerBuilder.newTrigger()
						.withIdentity("trigger1", "group1")
						.startNow()
						.withSchedule(SimpleScheduleBuilder.simpleSchedule()
								       .withIntervalInSeconds(5)
								       .repeatForever())
						.build();
			// scheduler 객체에게 job과 trigger 알려주기 
			scheduler.scheduleJob(job, trigger);
			
			// scheduler 동작을 확인하기 위해서 일시 중지 
			Thread.sleep(30000);  /// 30초 sleep
			
			// 스케줄러 종료
			scheduler.shutdown();
			
		} catch(Exception e) { e.printStackTrace(); }

	}

}
