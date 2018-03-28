package com.cararound.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetArticleService {

	@Autowired
	GetPagesService getPagesService;
	
	public String getArticle(String urlPath) throws Exception {
		String page = getPagesService.getString(urlPath, "GET");
		String pattern = "<article id=\"J_article\" class=\"J-article article\">(.*?)</article>";
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(page);
		
		if(m.find()) {
			return m.group(0);
		}
		else {
			return "page false!";
		}
	}
}
