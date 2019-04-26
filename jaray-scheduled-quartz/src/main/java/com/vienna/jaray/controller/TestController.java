package com.vienna.jaray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vienna.jaray.scheduled.QuartzService;
import com.vienna.jaray.scheduled.TestJob1;
import com.vienna.jaray.scheduled.TestJob2;

@RestController
public class TestController {
	
	@Autowired
    private QuartzService quartzService;
    @RequestMapping("/addjob")
    public void startJob(String type) {
        if("TestJob1".equals(type)) {
            quartzService.addJob(TestJob1.class, "job1", "test", "0/5 * * * * ?");
            
        }else {
            quartzService.addJob(TestJob2.class, "job2", "test", "0/5 * * * * ?");
        }
    }
    
    @RequestMapping("/updatejob")
    public void updatejob() {
            quartzService.updateJob("job1", "test", "0/10 * * * * ?");
    }
    
    @RequestMapping("/deletejob")
    public void deletejob() {
            quartzService.deleteJob("job1", "test");
    }
    
    @RequestMapping("/pauseJob")
    public void pauseJob() {
            quartzService.pauseJob("job1", "test");
    }
    
    @RequestMapping("/resumeJob")
    public void resumeJob() {
            quartzService.resumeJob("job1", "test");
    }
    
    @RequestMapping("/queryAllJob")
    public Object queryAllJob() {
            return quartzService.queryAllJob();
    }
    

    @RequestMapping("/queryRunJob")
    public Object queryRunJob() {
            return quartzService.queryRunJob();
    }

}
