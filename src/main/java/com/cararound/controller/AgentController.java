package com.cararound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cararound.service.GetPagesService;

@Controller
public class AgentController {
	
	@Autowired
	GetPagesService getPagesService;
	
	@GetMapping("/getData.json")
	@ResponseBody
	public String getData(String url) throws Exception{
        url=java.net.URLDecoder.decode(url,"UTF-8");
        return getPagesService.getString(url, "GET");
	}
}
