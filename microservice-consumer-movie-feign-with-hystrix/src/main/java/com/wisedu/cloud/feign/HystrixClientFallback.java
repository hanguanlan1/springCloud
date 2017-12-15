package com.wisedu.cloud.feign;

import org.springframework.stereotype.Component;

import com.wisedu.cloud.entity.User;

@Component
public class HystrixClientFallback implements UserFeignClient {
	@Override
	public User findById(Long id) {
		User u = new User();
		u.setId(0L);
		return u;
	}
}
