package com.wisedu.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wisedu.cloud.entity.User;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {
	// 两个注意点：1.GetMapping不支持 2。PathVariable要设置value

	@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public User addUser(@RequestBody User user);
}
