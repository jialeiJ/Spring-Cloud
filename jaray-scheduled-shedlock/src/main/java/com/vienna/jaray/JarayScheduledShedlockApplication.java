package com.vienna.jaray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;

@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
@SpringBootApplication
public class JarayScheduledShedlockApplication {

	public static void main(String[] args) {
		SpringApplication.run(JarayScheduledShedlockApplication.class, args);
	}

}
