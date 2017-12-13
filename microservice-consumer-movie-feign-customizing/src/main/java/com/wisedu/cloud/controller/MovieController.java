package com.wisedu.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wisedu.cloud.entity.User;
import com.wisedu.cloud.feign.UserFeignClient;
import com.wisedu.cloud.feign.UserFeignClientService;

@RestController
public class MovieController {
	@Autowired
	private UserFeignClient userFeignClient;

	@Autowired
	private UserFeignClientService userFeignClientService;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignClient.findById(id);
	}

	@GetMapping("/{serviceName}")
	public String findEurekaByServiceName(@PathVariable("serviceName") String serviceName) {
		return this.userFeignClientService.findEurekaByServiceName(serviceName);
	}
}
