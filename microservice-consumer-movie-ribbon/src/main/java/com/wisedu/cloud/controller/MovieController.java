package com.wisedu.cloud.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wisedu.cloud.entity.User;

@RestController
public class MovieController {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		// VIP virtual IP HAProxy heartBeat
		return restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}

	@GetMapping("/test")
	public void test() {
		ServiceInstance instance = this.loadBalancerClient.choose("microservice-provider-user");
		System.out.println("111: " + instance.getServiceId() + ": " + instance.getHost() + ": " + instance.getPort());

		ServiceInstance instance1 = this.loadBalancerClient.choose("microservice-provider-user2");
		System.out
				.println("222: " + instance1.getServiceId() + ": " + instance1.getHost() + ": " + instance1.getPort());
	}

	@GetMapping("/getListUser")
	public List<User> getListUser() {
		// wrong
		/*List<User> userArrayList = restTemplate.getForObject("http://microservice-provider-user/list-all/", List.class);
		for(User uu:userArrayList) {
			System.out.println(uu.getUsername());
		}*/
		// right
		User[] userArray = restTemplate.getForObject("http://microservice-provider-user/list-all/", User[].class);
		List<User> userList = Arrays.asList(userArray);
		for (User u : userList) {
			System.out.println(u.getUsername());
		}
		return userList;
	}
	
	@GetMapping("/sidecar")
	public String sidecar() {
		return restTemplate.getForObject("http://microservice-sidecar/", String.class);
	}
}
