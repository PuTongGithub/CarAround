package com.cararound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cararound.service.GetArticleService;

@Controller
public class PagesCountroller {
	
	@Autowired
	GetArticleService getArticleService;
	
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
		return "video/video";
	}
	
	@GetMapping("/fm")
	public String fm() {
		return "fm/fm";
	}
	
	@GetMapping("/weather")
	public String weather() {
		return "weather/weather";
	}
	
	@GetMapping("/map")
	public String map() {
		return "map/map";
	}
	
	@GetMapping("/news")
	public String news() {
		return "news/news";
	}
	
	@GetMapping("/news-article")
	public String news_article(String url, Model model) throws Exception {
		String content = getArticleService.getArticle(url);
		model.addAttribute("article_content", content);
		return "news/news-article";
	}
	
	@GetMapping("/music")
	public String music() {
		return "music/music";
	}
	
	@GetMapping("/music-player")
	public String music_player() {
		return "music/music-player";
	}
	
	@GetMapping("/music-search")
	public String music_search() {
		return "music/music-search";
	}
	
	@GetMapping("/music-list")
	public String music_list() {
		return "music/music-list";
	}
	
	@GetMapping("/com")
	public String com() {
		return "com/com";
	}
	
	@GetMapping("/status")
	public String status() {
		return "status/status";
	}
}
