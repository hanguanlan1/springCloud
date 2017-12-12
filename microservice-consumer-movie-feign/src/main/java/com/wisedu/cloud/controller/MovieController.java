package com.wisedu.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wisedu.cloud.UserFeignClient;
import com.wisedu.cloud.entity.User;

@RestController
public class MovieController {
	@Autowired
	private UserFeignClient userFeignClient;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignClient.findById(id);
	}
	
	@GetMapping("/addUser")
	public User addUser(User user) {
		return userFeignClient.addUser(user);
	}
}
