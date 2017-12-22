package com.wisedu.cloud.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wisedu.cloud.entity.User;

import feign.hystrix.FallbackFactory;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient> {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserFeignClient.class);

	@Override
	public UserFeignClient create(Throwable cause) {

		return new UserFeignClient() {
			@Override
			public User findById(Long id) {
				User user = new User();
				user.setId(-1L);
				user.setUsername("默认用户");
				return user;
			}

		};
	}

}
