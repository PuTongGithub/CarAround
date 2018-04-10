package com.cararound.dao;

import com.cararound.entity.Config;

public interface ConfigMapper {
	public void insertSelective(Config config);
	
	public Config selectConfig();
}