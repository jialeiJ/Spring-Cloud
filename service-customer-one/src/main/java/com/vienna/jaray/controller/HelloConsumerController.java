package com.vienna.jaray.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vienna.jaray.feign.HelloRemote;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/hello")
@Api(value="/hello", tags="Hello Consumer 控制器")
public class HelloConsumerController {
	private static Logger logger = LoggerFactory.getLogger(HelloConsumerController.class);
	
	@Autowired
    private HelloRemote helloRemote;
	
    @GetMapping("/say/{name}")
    public String index(@PathVariable(value="name") String name) {

    	logger.info("服务消费者{}",name);
//    	try {
//            //睡眠60秒，测试feign的熔断、降级
//            Thread.sleep(60 * 1000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return helloRemote.hello(name);
    }

}
