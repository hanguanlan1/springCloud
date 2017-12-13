package com.wisedu.cloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.wisedu.cloud.entity.User;
import com.wisedu.cloud.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id) {
		return this.userRepository.findOne(id);
	}

	@GetMapping("/eureka-instance")
	public String serviceUrl() {
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
		return instance.getHomePageUrl();
	}

	@GetMapping("/instance-info")
	public ServiceInstance showInfo() {
		ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
		return localServiceInstance;
	}

	@PostMapping("addUser")
	public User addUser(@RequestBody User user) {
		return user;
	}

	@GetMapping("list-all")
	public List<User> getListAll() {
		List<User> userLists = new ArrayList<User>();
		User user1 = new User(1L, "ZHANGSHAN");
		User user2 = new User(2L, "ZHANGSHAN");
		User user3 = new User(3L, "ZHANGSHAN");
		User user4 = new User(4L, "ZHANGSHAN");
		User user5 = new User(5L, "ZHANGSHAN");
		userLists.add(user1);
		userLists.add(user2);
		userLists.add(user3);
		userLists.add(user4);
		userLists.add(user5);
		return userLists;
	}
}
