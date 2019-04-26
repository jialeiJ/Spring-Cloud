package com.vienna.jaray.hystric;

import org.springframework.stereotype.Service;

import com.vienna.jaray.feign.HelloRemote;

@Service
public class HelloRemoteHystric implements HelloRemote {

	@Override
	public String hello(String name) {
		return "hello " +name+", this messge send failed ";
	}

}
