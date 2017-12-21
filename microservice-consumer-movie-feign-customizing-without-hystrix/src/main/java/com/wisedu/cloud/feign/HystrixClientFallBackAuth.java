package com.wisedu.cloud.feign;

public class HystrixClientFallBackAuth implements UserFeignClientService{

	@Override
	public String findEurekaByServiceName(String serviceName) {
		return "haha";
	}

}
