package com.wisedu.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.wisedu.cloud.ExcludeFromComponentScan;

@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {
	@Autowired
	IClientConfig config;
	
	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new RandomRule();
	}
}