package com.cararound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cararound.dao.TestdataMapper;
import com.cararound.entity.Testdata;

@Service
public class StatusService {

	@Autowired
	TestdataMapper testdataMapper;
	
	public List<Testdata> getTestdatas(){
		return testdataMapper.selectTestdata();
	}
}
