package com.cararound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cararound.entity.Config;
import com.cararound.service.ConfigService;

@RestController
@RequestMapping("/com")
public class ConfigController {

	@Autowired
	ConfigService configService;
	
	@RequestMapping("/getConfig")
	public Config getConfig() {
		return configService.getConfig();
	}
	
	@RequestMapping("/setConfig")
	public void setConfig(Config config) {
		configService.setConfig(config);
	}
}
