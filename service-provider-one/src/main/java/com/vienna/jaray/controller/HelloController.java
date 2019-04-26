package com.vienna.jaray.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/hello")
@Api(value="/hello", tags="Hello 控制器")
public class HelloController {
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping("/say/{name}")
	@ApiOperation(value="根据传入的姓名say hello", notes="服务提供者")
    @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String")
    public String hello(@PathVariable String name) {
		logger.info("服务提供者一{}",name);
        return "hello "+name+"，this is one messge";
    }

}
