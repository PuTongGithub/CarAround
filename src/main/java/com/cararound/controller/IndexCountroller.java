package com.cararound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexCountroller {
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
