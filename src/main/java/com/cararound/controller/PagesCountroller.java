package com.cararound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesCountroller {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/video")
	public String video() {
		return "/video/video";
	}
	
	@GetMapping("/weather")
	public String weather() {
		return "/weather/weather";
	}
}
