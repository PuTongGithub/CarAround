package com.cararound.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cararound.dao.ConfigMapper;
import com.cararound.entity.Config;

@Service
public class ConfigService {
	@Autowired
	ConfigMapper configMapper;
	
	public Config getConfig() {
		return configMapper.selectConfig();
	}
	
	public void setConfig(Config config) {
		configMapper.insertSelective(config);
	}
}
