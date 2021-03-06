package com.wisedu.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {
	
	@Value("${profile}")
	private String profile;
	
	@GetMapping("/getProfile")
	public String getProfile() {
		return profile;
	}

}
