package com.cararound.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cararound.tool.SpeechMatch;
import com.cararound.tool.SpeechRec;

@RestController
public class SpeechController {
	
	@Autowired
	public SpeechMatch speechMatch;

	@PostMapping("/speech")
	public Map<String, Object> speech(MultipartFile audioBlob) throws IOException{
		Map<String, Object> map = new HashMap<>();
		if(audioBlob == null) {
			map.put("success", false);
			map.put("message", "录音文件为空！");
			return map;
		}
		
		String speechStr = SpeechRec.getStr(audioBlob.getBytes());
		if(speechStr == null) {
			map.put("success", false);
			map.put("message", "语音识别错误！");
			return map;
		}
		
		String[] result = speechMatch.match(speechStr);
		if(result == null) {
			map.put("success", false);
			map.put("message", "指令匹配错误！");
			return map;
		}
		
		map.put("success", true);
		map.put("code", result[0]);
		map.put("message", result[1]);
		if(result.length > 2) {
			map.put("message2", result[2]);
		}
		return map;
	}
}
