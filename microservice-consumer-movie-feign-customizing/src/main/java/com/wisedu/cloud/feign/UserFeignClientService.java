package com.wisedu.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wisedu.config.ConfigurationAuth;

@FeignClient(name="xxxx",url="http://localhost:8761/",configuration=ConfigurationAuth.class)
public interface UserFeignClientService {
	
	@RequestMapping("/eureka/apps/{serviceName}")
	public String findEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
