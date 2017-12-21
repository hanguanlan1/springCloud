package com.wisedu.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.wisedu.cloud.entity.User;
import com.wisedu.config.ConfigurationDefault;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "microservice-provider-user", configuration = ConfigurationDefault.class, fallback = HystrixClientFallback.class)
public interface UserFeignClient {
	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id);

}
