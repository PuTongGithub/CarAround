package com.cararound.dao;

import java.util.List;

import com.cararound.entity.Testdata;

public interface TestdataMapper {
	public void insertSelective(Testdata testdata);
	
	public List<Testdata> selectTestdata();
}