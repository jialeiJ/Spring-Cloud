package com.vienna.jaray.hystric;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vienna.jaray.feign.HelloRemote;

@Component
public class HelloRemoteHystric implements HelloRemote {

	@Override
	@GetMapping(value = "/hello/say/{name}")
	public String hello(@PathVariable(value="name") String name) {
		return "hello " +name+", this messge send failed ";
	}

}
