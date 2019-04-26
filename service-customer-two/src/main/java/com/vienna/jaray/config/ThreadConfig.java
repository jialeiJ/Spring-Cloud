package com.vienna.jaray.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ComponentScan("com.hotpot.*.service.impl")
@EnableAsync
public class ThreadConfig {
	
	/**
     * 执行需要依赖线程池，这里就来配置一个线程池
     * @return
     */
    @Bean  
    public Executor getExecutor() {  
         ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();  
         executor.setCorePoolSize(10);
         executor.setMaxPoolSize(100);
         executor.setQueueCapacity(250);
         executor.initialize(); 
       //用来设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean，这样这些异步任务的销毁就会先于Redis线程池的销毁。
         executor.setWaitForTasksToCompleteOnShutdown(true);
         //该方法用来设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住。
         executor.setAwaitTerminationSeconds(60);
         return executor;  
    }  

}
