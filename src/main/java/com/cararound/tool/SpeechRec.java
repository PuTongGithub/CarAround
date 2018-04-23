package com.cararound.tool;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.speech.AipSpeech;

public class SpeechRec {
	public static final String APP_ID = "10591621";
    public static final String API_KEY = "nkqIUPOY16jRKIpFxWkBsxzK";
    public static final String SECRET_KEY = "9826ea1474a594813789462e2fec6965";
    private static AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

    public static String getStr(byte[] speech) {
    	// 设置语音识别模式（普通话，无标点）
    	HashMap<String, Object> options = new HashMap<>();
    	options.put("dev_pid", 1536);
    	
        // 调用接口
        JSONObject res = client.asr(speech, "wav", 16000, options);
        if(res.getLong("err_no") == 0) {
            return res.getJSONArray("result").getString(0);
        }
        else {
        	return null;
        }
    }
}
