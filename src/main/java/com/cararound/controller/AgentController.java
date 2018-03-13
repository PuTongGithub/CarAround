package com.cararound.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AgentController {
	
	private String getJsonString(String urlPath, String method) throws Exception {  
        URL url = new URL(urlPath);  
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setUseCaches(false);
        connection.setRequestMethod(method);
        connection.connect();  
        InputStream inputStream = connection.getInputStream();  
        //对应的字符编码转换  
        Reader reader = new InputStreamReader(inputStream, "UTF-8");  
        BufferedReader bufferedReader = new BufferedReader(reader);  
        String str = null;  
        StringBuffer sb = new StringBuffer();  
        while ((str = bufferedReader.readLine()) != null) {  
            sb.append(str);  
        }  
        reader.close();  
        connection.disconnect();
        return sb.toString();
    }
	
	@GetMapping("/getData.json")
	@ResponseBody
	public String getData(String url) throws Exception{
        url=java.net.URLDecoder.decode(url,"UTF-8");
        return getJsonString(url, "GET");
	}
}
