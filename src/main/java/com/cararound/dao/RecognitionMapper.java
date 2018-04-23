package com.cararound.dao;

import java.util.List;

import com.cararound.entity.Recognition;

public interface RecognitionMapper {
	public void insertSelective(Recognition recognition);
	
	public List<Recognition> selectRecognition();
}