package com.vienna.jaray.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vienna.jaray.hystric.HelloRemoteHystric;

@FeignClient(name = "service-provider-two", fallback = HelloRemoteHystric.class)
public interface HelloRemote {
	
	@GetMapping(value = "/hello/say/{name}")
    public String hello(@PathVariable(value="name") String name);

}
