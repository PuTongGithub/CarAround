package com.cararound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cararound.entity.Testdata;
import com.cararound.service.StatusService;

@RestController
@RequestMapping("/status")
public class StatusController {

	@Autowired
	StatusService statusService;
	
	@RequestMapping("/getDatas")
	public List<Testdata> getDatas(){
		return statusService.getTestdatas();
	}
}
