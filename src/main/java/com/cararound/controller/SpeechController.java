package com.cararound.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cararound.tool.SpeechRec;

@RestController
public class SpeechController {

	@PostMapping("/speech")
	public Map<String, Object> speech(MultipartFile audioBlob) throws IOException{
		String speechStr = SpeechRec.getStr(audioBlob.getBytes());
		Map<String, Object> map = new HashMap<>();
		map.put("success", true);
		map.put("message", speechStr);
		return map;
	}
}
