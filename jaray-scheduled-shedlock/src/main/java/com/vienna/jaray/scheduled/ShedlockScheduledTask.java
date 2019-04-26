package com.vienna.jaray.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import net.javacrumbs.shedlock.core.SchedulerLock;

@EnableScheduling
@Configuration
public class ShedlockScheduledTask {
	private static Logger logger = LoggerFactory.getLogger(ShedlockScheduledTask.class);
	/**
	 * private static final int FOURTEEN_MIN = 14 * 60 * 1000;
	 * lockAtMostFor默认给了一小时;
	 * localAtLeastFor=14分钟,就是说当前节点执行时,就会持有锁14分钟,源码默认给了0分钟;
	 * 
	 * 注：FOURTEEN_MIN定义时间需要 小于定时任务的时间，如下
	 * @Scheduled(cron = "* 0/15 * * * *")   private static final int FOURTEEN_MIN = 14 * 60 * 1000;
	 * @Scheduled(cron="0/5 * * * * *")   private static final int FOURTEEN_MIN =  4 * 1000;
	 * */
	private static final int FOURTEEN_MIN =  4 * 1000;
	
	@Async
	@Scheduled(cron="0/5 * * * * *")
	@SchedulerLock(name="scheduledTaskName", lockAtMostFor = FOURTEEN_MIN, lockAtLeastFor = FOURTEEN_MIN)
	public void  scheduledTask() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("one："+sdf.format(date));
	}
	
	@Async
	@Scheduled(cron="0/5 * * * * *")
	@SchedulerLock(name="scheduledTaskTwo", lockAtMostFor = FOURTEEN_MIN, lockAtLeastFor = FOURTEEN_MIN)
	public void  scheduledTaskTwo() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("two："+sdf.format(date));
	}

}
