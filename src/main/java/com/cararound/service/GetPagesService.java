package com.cararound.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class GetPagesService {
	public String getString(String urlPath, String method) throws Exception {  
		urlPath = encode(urlPath, "utf8");
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
	
	private static String zhPattern = "[\\u4e00-\\u9fa5]+";  
	  
    public static String encode(String str, String charset)  
            throws Exception {  
        str = str.replaceAll(" ", "+");// 对空字符串进行处理  
        Pattern p = Pattern.compile(zhPattern);  
        Matcher m = p.matcher(str);  
        StringBuffer b = new StringBuffer();  
        while (m.find()) {  
            m.appendReplacement(b, URLEncoder.encode(m.group(0), charset));  
        }  
        m.appendTail(b);  
        return b.toString();  
    }  
}
