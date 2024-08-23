package com.example.SongTracker_Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.reactive.ReactiveManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = {
org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class, ReactiveSecurityAutoConfiguration.class, ReactiveManagementWebSecurityAutoConfiguration.class }
		)
public class SongTrackerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongTrackerBackendApplication.class, args);
	}

}
